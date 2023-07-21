package milkteaorder.controller.customer;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.controller.customer.dto.PersonalInfoDTO;
import milkteaorder.model.Account;
import milkteaorder.model.api.AuthRequest;
import milkteaorder.service.AccountService;


@Controller
@CrossOrigin(origins ="http://localhost:3000")
public class AccountController {
	@Autowired AccountService accountService;
	@Autowired PasswordEncoder passwordEncoder;
	
	@GetMapping("/customer/my-account-info")
	public ResponseEntity<PersonalInfoDTO> getPersonalInfo(HttpServletRequest request) {
		Account account = accountService.getAccByRequest(request);
		PersonalInfoDTO personalInfo = new PersonalInfoDTO();
		personalInfo.setAddress(account.getAddress());
		personalInfo.setName(account.getName());
		personalInfo.setPhone(account.getPhone());
		return ResponseEntity.ok(personalInfo);
	}
	
	@CrossOrigin(origins = "*", methods = { RequestMethod.PUT })
	@PutMapping("/customer/my-account-info/update")
	public ResponseEntity<?> getPersonalInfo(HttpServletRequest request, @RequestBody PersonalInfoDTO personalInfo) {
		Account account = accountService.getAccByRequest(request);
		
		account.setAddress(personalInfo.getAddress());
		account.setName(personalInfo.getName());
		account.setPhone(personalInfo.getPhone());
		
		account = accountService.updateAccount(account);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping("/customer/my-account-info/password-change")
	public ResponseEntity<?> getEmailAndCreateOTP(HttpServletRequest request) 
			throws UnsupportedEncodingException, MessagingException {
		Account account = accountService.getAccByRequest(request);
		accountService.generateOneTimePassword(account);
		return ResponseEntity.ok(new MessageDto("Enter your OTP, you will see it in your email: " + account.getEmail()));
	}
	
	@PostMapping("/customer/my-account-info/update-password")
	public ResponseEntity<?> changePassword(HttpServletRequest request, 
			@RequestBody @Valid AuthRequest authRequest) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Account account = accountService.getAccByRequest(request);
		if (passwordEncoder.matches(authRequest.getOtp(), account.getOneTimePassword())) {
			account.setPassword(encoder.encode(authRequest.getPassword()));
			accountService.updateAccount(account);
			account = accountService.clearOTP(account);
			return ResponseEntity.ok(account);
		}
		else return ResponseEntity.ok(new MessageDto("Wrong OTP"));
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<?> checkEmailAndCreateOTP(@RequestBody @Valid AuthRequest authRequest) 
			throws UnsupportedEncodingException, MessagingException {
		Account account = accountService.getAccountByEmail(authRequest.getEmail());
		if (account == null) {
			return ResponseEntity.ok(new MessageDto("Email doesn't exist"));
		}
		accountService.generateOneTimePassword(account);
		return ResponseEntity.ok(new MessageDto("Enter your OTP, you will see it in your email: " + account.getEmail()));
	}
	
	@PostMapping("/forgot-password/update")
	public ResponseEntity<?> changePassword(@RequestBody @Valid AuthRequest authRequest) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Account account = accountService.getAccountByEmail(authRequest.getEmail());
		if (passwordEncoder.matches(authRequest.getOtp(), account.getOneTimePassword())) {
			account.setPassword(encoder.encode(authRequest.getPassword()));
			accountService.updateAccount(account);
			account = accountService.clearOTP(account);
			return ResponseEntity.ok(account);
		}
		else return ResponseEntity.ok(new MessageDto("Wrong OTP"));
	}
}

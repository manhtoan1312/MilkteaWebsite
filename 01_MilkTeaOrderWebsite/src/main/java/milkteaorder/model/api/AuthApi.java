package milkteaorder.model.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import milkteaorder.config.security.CustomAccountDetail;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.jwt.JwtTokenUtil;
import milkteaorder.model.Account;
import milkteaorder.service.AccountService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="http://localhost:3000")
public class AuthApi {
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	@Autowired AccountService accountService;
	@Autowired PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			//Authenticate user
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			CustomAccountDetail account = (CustomAccountDetail) authentication.getPrincipal();
			
			String accessToken = jwtUtil.generateAccessToken(account);
			AuthResponse response = new AuthResponse(account.getUsername(), accessToken);
			return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid Account account) {
		if (accountService.checkAccountExisted(account.getEmail())) {
			return ResponseEntity.ok(new MessageDto("Email has already been existed!"));
		}
		accountService.createAccount(account);
		return ResponseEntity.ok(new MessageDto("Registered successfully!")); 
	}
}

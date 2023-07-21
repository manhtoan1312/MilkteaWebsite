package milkteaorder.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import milkteaorder.controller.admin.dto.AccountRequestDto;
import milkteaorder.controller.customer.dto.MessageDto;
import milkteaorder.model.Account;
import milkteaorder.service.AccountService;

@RestController
@RequestMapping("/admin/account")
@CrossOrigin(origins ="http://localhost:3000")
public class AdminAccountController {
	
	@Autowired private AccountService accountService;
	
	@GetMapping("/get-all")
	public ResponseEntity<Object> getAllAccount() {
		List<Account> accounts = accountService.getAllAccount();
		if (accounts == null) {
			throw new NullPointerException();
		}
		return ResponseEntity.ok(accounts);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insertAccount(@RequestBody AccountRequestDto accountInsert) {
		Account accountResponse = accountService.insertAccount(accountInsert);
		if (accountResponse == null) {
			return ResponseEntity.ok(new MessageDto("Insert Account Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(accountResponse);
	}
	
	@PutMapping("/update/{accountId}")
	public ResponseEntity<Object> updateMilktea(@RequestBody AccountRequestDto account, @PathVariable String accountId) {
		Account accountResponse = accountService.updateAccount(account, accountId);
		if (accountResponse == null) {
			return ResponseEntity.ok(new MessageDto("Update Account Unsuccessfully, please check again !"));
		}
		return ResponseEntity.ok(accountResponse);
	}
	
	@PutMapping("/delete/{accountId}")
	public ResponseEntity<Object> deleteAccount(@PathVariable String accountId) {
		boolean isDeleted = accountService.deleteAccount(accountId);
		if (isDeleted) {
			return ResponseEntity.ok(new MessageDto("Delete Account Successfully"));
		}
		return ResponseEntity.ok(new MessageDto("Delete Account Unsuccessfully, please check again !"));
	}
}

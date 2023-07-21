package milkteaorder.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import milkteaorder.model.Account;
import milkteaorder.repository.AccountRepository;

public class CustomAccountDetailService implements UserDetailsService {
	
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account accountEmail = accountRepo.findByEmail(username);
		if (accountEmail == null) {
			throw new UsernameNotFoundException("Account not found");
		}
		return new CustomAccountDetail(accountEmail);
	}

}

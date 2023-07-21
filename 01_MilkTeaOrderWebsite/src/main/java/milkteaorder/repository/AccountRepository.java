package milkteaorder.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import milkteaorder.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	@Query(value = "SELECT * FROM account acc WHERE acc.email = ?1 and acc.enabled = true" , nativeQuery = true)
	Account findByEmail(String email);
	
	@Query(value = "SELECT * FROM account acc WHERE acc.acc_id = ?1 and acc.enabled = true" , nativeQuery = true)
	Optional<Account> findById(String id);
	
	@Query(value = "SELECT * FROM account acc WHERE acc.enabled = true" , nativeQuery = true)
	List<Account> findAll();
}

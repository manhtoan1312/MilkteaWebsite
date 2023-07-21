package milkteaorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import milkteaorder.model.AddOn;

public interface AddOnRepository extends JpaRepository<AddOn, String> {
	@Query(value = "SELECT * FROM add_on ao WHERE ao.add_on_id = ?1 and ao.enabled = true" , nativeQuery = true)
	Optional<AddOn> findById(String id);
	
	@Query(value = "SELECT * FROM add_on ao WHERE ao.enabled = true" , nativeQuery = true)
	List<AddOn> findAll();
}

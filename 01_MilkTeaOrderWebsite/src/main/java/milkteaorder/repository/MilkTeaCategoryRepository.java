package milkteaorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import milkteaorder.model.MilkTeaCategory;

public interface MilkTeaCategoryRepository extends JpaRepository<MilkTeaCategory, String> {
	@Query(value = "SELECT * FROM milk_tea_category mtc WHERE mtc.milk_tea_category_id = ?1 and mtc.enabled = true" , nativeQuery = true)
	Optional<MilkTeaCategory> findById(String id);
	
	@Query(value = "SELECT * FROM milk_tea_category mtc WHERE mtc.enabled = true" , nativeQuery = true)
	List<MilkTeaCategory> findAll();
}

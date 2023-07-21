package milkteaorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import milkteaorder.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, String> {
	
	@Query(value = "select * from salary s where s.role = ?1 and s.on_time=?2 and s.enabled=true", nativeQuery = true)
	Salary findSalaryByRole(String role, boolean isOnTime);
}

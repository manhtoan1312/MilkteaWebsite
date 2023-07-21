package milkteaorder.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
	@Id
	@GenericGenerator(name = "salary_id", strategy = "milkteaorder.idGenerator.SalaryIDGenerator")
	@GeneratedValue(generator = "salary_id")
	@Column(name = "salary_id", length = 10)
	private String salary_id;
	
	@Column(name = "role", length = 40)
	private String role;
	
	@Column(name = "vnd_per_hour")
	private int vnd_per_hour;
	
	@Column(name = "on_time")
	private boolean on_time;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy = "salary")
	@JsonIgnore
	private Set<Staff> staffs;
	
	@OneToMany(mappedBy = "ot_salary")
	@JsonIgnore
	private Set<Staff> ot_staffs;
}

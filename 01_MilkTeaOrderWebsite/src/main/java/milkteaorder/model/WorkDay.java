package milkteaorder.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WorkDay {
	@Id
	@Column(name = "work_day")
	private LocalDate work_day;
	
	@Column(name = "is_holiday")
	private boolean is_holiday;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy = "staff")
	@JsonIgnore
	private Set<StaffWorkDay> staffWorkDays;
}

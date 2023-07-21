package milkteaorder.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffWorkDay {
	@EmbeddedId
	StaffWorkDayKey id;
	
	@ManyToOne
	@MapsId("staff_id")
	@JoinColumn(name = "staff_id")
	Staff staff;
	
	@ManyToOne
	@MapsId("work_day")
	@JoinColumn(name = "work_day")
	WorkDay workDay;
	
	float hours;
	
}

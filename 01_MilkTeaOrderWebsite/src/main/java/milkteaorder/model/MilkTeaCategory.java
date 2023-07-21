package milkteaorder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "milk_tea_category")
public class MilkTeaCategory {
	@Id
	@GenericGenerator(name = "milk_tea_category_id", strategy = "milkteaorder.idGenerator.MilkeTeaCategoryIDGenerator")
	@GeneratedValue(generator = "milk_tea_category_id")
	@Column(name = "milk_tea_category_id", length = 10)
	private String milk_tea_category_id;
	
	@Column(name = "category_name", length = 255)
	private String category_name;
	
	@Column(name = "description", length = 1500)
	private String description;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy = "milk_tea_category")
	@JsonManagedReference(value = "cusMTea-category")
	private List<MilkTea> milkTeas;
}

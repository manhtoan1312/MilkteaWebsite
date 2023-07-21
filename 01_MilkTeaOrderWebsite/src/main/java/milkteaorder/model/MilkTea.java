package milkteaorder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "milk_tea")
public class MilkTea {
	@Id
	@GenericGenerator(name = "milk_tea_id", strategy = "milkteaorder.idGenerator.MilkeTeaIDGenerator")
	@GeneratedValue(generator = "milk_tea_id")
	@Column(name = "milk_tea_id", length = 10)
	private String milk_tea_id;
	
	@Column(name = "name", nullable = false, length = 40)
	private String name;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "cost", nullable = false)
	private int cost;
	
	@Column(name = "image_url", length = 1000)
	private String image_url;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "milk_tea_category_id")
	@JsonBackReference(value = "cusMTea-category")
	private MilkTeaCategory milk_tea_category;
	
	@OneToMany(mappedBy = "milkTea")
	//@JsonManagedReference(value = "mTEa-cusMTea")
	@JsonIgnore
	List<CustomMilkTea> customMilkTeas;
}

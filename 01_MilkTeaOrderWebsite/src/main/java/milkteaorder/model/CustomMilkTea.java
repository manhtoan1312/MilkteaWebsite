package milkteaorder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "custom_milk_tea")
public class CustomMilkTea {
	@Id
	@GenericGenerator(name = "custom_milk_tea_id", strategy = "milkteaorder.idGenerator.CustomMilkTeaIDGenerator")
	@GeneratedValue(generator = "custom_milk_tea_id")
	@Column(name = "custom_milk_tea_id", length = 10)
	private String custom_milk_tea_id;
	
	@ManyToOne
	@JoinColumn(name = "milktea_id")
	private MilkTea milkTea;
	
	@Column(name = "ice_amount")
	private int ice_amount;
	
	@Column(name = "sugar_amount")
	private int sugar_amount;
	
	@Column(name = "size", length = 2)
	private String size;
	
	@Column(name = "total_cost")
	private int total_cost;
	
	@Column(name = "total_price")
	private int total_price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;
	
	@ManyToMany
	@JoinTable(
			schema = "custom_milk_tea_add_on",
			joinColumns = @JoinColumn(name = "custom_milk_tea_id"),
			inverseJoinColumns = @JoinColumn(name = "add_on_id"))
	@JsonIgnoreProperties
	List<AddOn> addOn;
}

package milkteaorder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "add_on")
public class AddOn {
	@Id
	@GenericGenerator(name = "add_on_id", strategy = "milkteaorder.idGenerator.AddOnIDGenerator")
	@GeneratedValue(generator = "add_on_id")
	@Column(name = "add_on_id", length = 10)
	private String add_on_id;
	
	@Column(name = "name", length = 40)
	private String name;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToMany(mappedBy = "addOn", fetch = FetchType.LAZY)
	@JsonIgnore
	List<CustomMilkTea> customMilkTeas;
}

package milkteaorder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
	@Id
	@GenericGenerator(name = "ingredient_id", strategy = "milkteaorder.idGenerator.IngredientIDGenerator")
	@GeneratedValue(generator = "ingredient_id")
	@Column(name = "ingredient_id", length = 10)
	private String ingredient_id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "manufactoring_date")
	private Date manufactoring_date;
	
	@Column(name = "expired_date")
	private Date expired_date;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	
	@Column(name = "note", length = 255)
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	@JsonIgnore
	private Account manager_account;
	
	@Column(name = "enabled")
	private boolean enabled;
}

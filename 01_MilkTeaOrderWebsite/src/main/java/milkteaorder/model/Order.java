package milkteaorder.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "ordering")
public class Order {
	@Id
	@GenericGenerator(name = "order_id", strategy = "milkteaorder.idGenerator.OrderIDGenerator")
	@GeneratedValue(generator = "order_id")
	@Column(name = "order_id", length = 10)
	private String order_id;
	
	@Column(name = "receiver_name", length = 30)
	private String receiver_name;
	
	@Column(name = "address", length = 255)
	private String address;
	
	@Column(name = "phone", length = 11)
	private String phone;
	
	@Column(name = "payment_method", length = 20)
	private String payment_method;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date order_date;
	
	@Column(name = "order_total_price")
	private int order_total_price;
	
	@Column(name = "note", length = 255)
	private String note;
	
	@Column(name = "customer_name", length = 50)
	private String customer_name;
	
	@Column(name = "order_state", length = 40)
	private String order_state;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "shipper_id")
	@JsonIgnore
	private Account shipper_account;
	
	@ManyToOne
	@JoinColumn(name = "staff_manager_id")
	@JsonIgnore
	private Account staff_manager_account;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Account customer_account;
	
	@OneToMany(mappedBy = "order")
	@JsonIgnore
	Set<CustomMilkTea> customMilkTeas;
}

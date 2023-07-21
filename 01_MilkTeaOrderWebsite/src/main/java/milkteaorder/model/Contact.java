package milkteaorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "contact")
public class Contact {
	@Id
	@GenericGenerator(name = "contact_id", strategy = "milkteaorder.idGenerator.ContactIDGenerator")
	@GeneratedValue(generator = "contact_id")
	@Column(name = "contact_id", length = 10)
	private String contact_id;
	
	@Column(name = "type", length = 20)
	private String type;
	
	@Column(name = "content", length = 255)
	private String content;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private Account account;
}

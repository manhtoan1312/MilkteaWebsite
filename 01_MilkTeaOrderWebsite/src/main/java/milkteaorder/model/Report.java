package milkteaorder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "report")
public class Report {
	@Id
	@GenericGenerator(name = "report_id", strategy = "milkteaorder.idGenerator.ReportIDGenerator")
	@GeneratedValue(generator = "report_id")
	@Column(name = "report_id", length = 10)
	private String report_id;
	
	@Column(name = "sender_name", length = 40, nullable = false)
	private String sender_name;
	
	@Column(name = "sender_email", length = 50)
	private String sender_email;
	
	@Column(name = "sender_phone_no", length = 11)
	private String sender_phone_no;
	
	@Column(name = "message", length = 	255, nullable = false)
	private String message;
	
	@Column(name = "send_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date send_date;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "has_read")
	private boolean has_read;
	
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private Account account;
	
}

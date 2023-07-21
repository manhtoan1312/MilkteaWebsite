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
@Table(name = "blog")
public class Blog {
	@Id
	@GenericGenerator(name = "blog_id", strategy = "milkteaorder.idGenerator.BlogIDGenerator")
	@GeneratedValue(generator = "blog_id")
	@Column(name = "blog_id", length = 10)
	private String blog_id;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "image_url")
	private String image_url;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "acc_id", nullable = false)
	private Account account;
}

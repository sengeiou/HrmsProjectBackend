package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;
	
	@Column(name = "application_deadline")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applicationDeadline;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name="is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private Employer employer;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private Job job;
	
}

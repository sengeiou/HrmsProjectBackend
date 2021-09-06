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
@Table(name = "candidate_cv_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvExperience {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "starting_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startingDate;
	
	@Column(name = "quit_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date quitDate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private Job job;

}

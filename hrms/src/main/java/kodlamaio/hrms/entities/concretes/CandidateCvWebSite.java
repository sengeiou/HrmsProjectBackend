package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_cv_web_sites")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWebSite {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "address")
	private String address;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "web_site_id")
	private WebSite webSite;
}

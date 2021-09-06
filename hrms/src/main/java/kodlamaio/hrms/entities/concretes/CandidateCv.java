package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidateCvEducations", "candidateCvExperiences", "candidateCvImages", "candidateCvLanguages" , "candidateCvSkills" , "candidateCvWebSites"})
public class CandidateCv {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvEducation> candidateCvEducations;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvExperience> candidateCvExperiences;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvImage> candidateCvImages;
	
	@OneToMany(mappedBy = "candidateCv")
    private List<CandidateCvLanguage> candidateCvLanguages;

	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvSkill> candidateCvSkills;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvWebSite> candidateCvWebSites;
}

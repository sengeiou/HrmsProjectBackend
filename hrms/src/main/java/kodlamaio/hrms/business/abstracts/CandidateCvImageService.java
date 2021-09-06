package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageService {
	
	Result create(MultipartFile multipartFile, long id);
	
	DataResult<List<CandidateCvImage>> getAll();
	
	DataResult<List<CandidateCvImage>> getByCandidateCvId(long candidateCvId);
	
	DataResult<CandidateCvImage> getByCandidateId(long candidateId);

}

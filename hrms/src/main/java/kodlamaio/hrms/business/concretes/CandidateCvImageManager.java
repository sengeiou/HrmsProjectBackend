package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvImageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvImage;

@Service
public class CandidateCvImageManager implements CandidateCvImageService{
	
	private CandidateCvImageDao candidateCvImageDao;
	private CloudinaryService cloudinaryService;
	private CandidateService candidateService;
	
	@Autowired
	public CandidateCvImageManager(CandidateCvImageDao candidateCvImageDao, CloudinaryService cloudinaryService, CandidateService candidateService) {
		this.candidateCvImageDao = candidateCvImageDao;
		this.cloudinaryService = cloudinaryService;
		this.candidateService = candidateService;
	}

	@Override
	public Result create(MultipartFile multipartFile, long id) {
		var result = this.cloudinaryService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult("Candidate cv image upload failed!");
		}
		var candidate = this.candidateService.getById(id).getData();
		CandidateCvImage candidateCvImage = new CandidateCvImage();
		candidateCvImage.setCandidateCv(candidate.getCandidateCv());
		candidateCvImage.setUrl(result.getData().get("url"));
		
		this.candidateCvImageDao.save(candidateCvImage);
		return new SuccessResult("Candidate cv image created!");
	}

	@Override
	public DataResult<List<CandidateCvImage>> getAll() {
		return new SuccessDataResult<List<CandidateCvImage>>(this.candidateCvImageDao.findAll(), "Candidate cv images listed!");
	}

	@Override
	public DataResult<List<CandidateCvImage>> getByCandidateCvId(long candidateCvId) {
		return new SuccessDataResult<List<CandidateCvImage>>(this.candidateCvImageDao.findByCandidateCvId(candidateCvId), "Candidate cv images listed by candidateCvId!");
	}

	@Override
	public DataResult<CandidateCvImage> getByCandidateId(long candidateId) {
		return new SuccessDataResult<CandidateCvImage>(this.candidateCvImageDao.findByCandidateCv_Candidate_Id(candidateId), "Candidate image listed by candidateId!");
	}

}

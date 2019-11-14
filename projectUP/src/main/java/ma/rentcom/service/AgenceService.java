package ma.rentcom.service;



import static com.github.adminfaces.template.util.Assert.has;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.github.adminfaces.template.exception.BusinessException;

import ma.rentcom.model.entity.Agence;
import ma.rentcom.model.entity.Car;
import ma.rentcom.model.entity.Ville;
import ma.rentcom.repository.AgenceRepository;
import ma.rentcom.repository.VilleRepository;


@Service
public class AgenceService implements Serializable{


	
		

	
	@Inject
	private AgenceRepository agenceRepository;
	

	
    
	public void validate(Agence agence) {
		BusinessException be = new BusinessException();

		if (!agence.hasName()) {
			be.addException(new BusinessException("Agence name cannot be empty"));
		}
		if (!agence.hasTel()) {
			be.addException(new BusinessException("Tel cannot be empty"));
		}
		if (!agence.hasAdresse()) {
			be.addException(new BusinessException("Adresse cannot be empty"));
		}
		if (!agence.hasEmail()) {
				be.addException(new BusinessException("Email cannot be empty"));	
		}
		
	
		if (has(be.getExceptionList())) {
			throw be;
		}
	}
	
	public Agence getAgenceById(Long id) {

		return (Agence) agenceRepository.getAgenceById(id);
	}

	
	public List<Agence> getAll() {
		return agenceRepository.findAll();
	}
    
	
	public Agence getAgence(Long agenceId) {
		return agenceRepository.getOne(agenceId);
	}

	public Agence findById(Long id) {
		return agenceRepository.getOne(id);
	}


	public void remove(Agence agence) {
		agenceRepository.delete(agence);
	}


	public void add(Agence agence) {
		agenceRepository.save(agence);
	}
	public  Agence save(Agence agence) {
		return agenceRepository.save(agence);

	}

	 public Page<Agence> findByNom(String nom, PageRequest pageRequest) {
	        return agenceRepository.findByNom(nom, pageRequest);
	    }

	    public List<Agence> findByEmail(String email) {
	        return agenceRepository.findByEmail(email);
	    }

	
	public Agence getAgenceById(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
}
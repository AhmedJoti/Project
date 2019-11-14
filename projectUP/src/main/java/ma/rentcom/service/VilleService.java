package ma.rentcom.service;



import static com.github.adminfaces.template.util.Assert.has;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.github.adminfaces.template.exception.BusinessException;

import ma.rentcom.model.entity.Car;
import ma.rentcom.model.entity.Ville;
import ma.rentcom.repository.VilleRepository;


@Service
public class VilleService implements Serializable{
	
	private static final long serialVersionUID = -7494285187127167835L;
	
	@Inject
	private VilleRepository villeRepository;
	
	public void validate(Ville ville) {
		BusinessException be = new BusinessException();

		
		if (!ville.hasVille()) {
			be.addException(new BusinessException("ville name cannot be empty"));
		}
		if (has(be.getExceptionList())) {
			throw be;
		}
      
	}
	
	public List<Ville> getAll() {
		return villeRepository.findAll();
	}


	public Ville findById(Long id) {
		return villeRepository.getOne(id);
	}


	public void remove(Ville ville) {
		villeRepository.delete(ville);
	}


	public void add(Ville ville) {
		villeRepository.save(ville);
	
}
}
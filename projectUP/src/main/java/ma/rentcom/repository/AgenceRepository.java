package ma.rentcom.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.rentcom.model.entity.Agence;


public interface AgenceRepository extends JpaRepository<Agence, Long> {
	Agence getAgenceById(Long id);
	
	Agence findByNom(String nom);
     
	
	Page<Agence> findByNom(String nom, PageRequest pageRequest);

    List<Agence> findByEmail(String email);
    
    
}




package ma.rentcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.rentcom.model.entity.Ville;



public interface VilleRepository extends JpaRepository<Ville, Long> {

}

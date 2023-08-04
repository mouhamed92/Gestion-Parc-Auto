package tn.sncft.entretienservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.sncft.entretienservice.entities.Entretien;

@RepositoryRestResource
public interface EntretienRepository extends JpaRepository<Entretien,Long> {
}

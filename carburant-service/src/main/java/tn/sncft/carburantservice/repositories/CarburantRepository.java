package tn.sncft.carburantservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.sncft.carburantservice.entities.Carburant;
@RepositoryRestResource
public interface CarburantRepository extends JpaRepository<Carburant,Long> {
}

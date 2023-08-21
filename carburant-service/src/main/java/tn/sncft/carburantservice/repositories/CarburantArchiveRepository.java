package tn.sncft.carburantservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.sncft.carburantservice.entities.Carburant;
import tn.sncft.carburantservice.entities.CarburantArchive;

@RepositoryRestResource
public interface CarburantArchiveRepository extends JpaRepository<CarburantArchive,Long> {
}

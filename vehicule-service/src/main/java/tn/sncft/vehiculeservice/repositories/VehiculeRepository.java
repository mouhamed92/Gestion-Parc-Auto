package tn.sncft.vehiculeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.sncft.vehiculeservice.entities.Vehicule;

@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}

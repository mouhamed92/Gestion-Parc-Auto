package tn.sncft.missionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.sncft.missionservice.entities.Mission;

@RepositoryRestResource
public interface MissionRepository extends JpaRepository<Mission,Long> {
}

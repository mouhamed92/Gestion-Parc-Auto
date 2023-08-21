package tn.sncft.Agentservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.sncft.Agentservice.entities.Agent;
@RepositoryRestResource
public interface AgentRepository extends JpaRepository<Agent,Long> {
}

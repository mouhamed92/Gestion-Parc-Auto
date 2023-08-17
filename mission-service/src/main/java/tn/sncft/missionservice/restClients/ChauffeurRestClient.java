package tn.sncft.missionservice.restClients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CHAUFFEUR-SERVICE")
public interface ChauffeurRestClient {
}

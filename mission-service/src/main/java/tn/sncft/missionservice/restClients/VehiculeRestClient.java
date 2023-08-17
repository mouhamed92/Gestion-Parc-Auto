package tn.sncft.missionservice.restClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.sncft.missionservice.dtos.VehiculeResponseDto;

import java.util.List;

@FeignClient(name = "VEHICULE-SERVICE")
public interface VehiculeRestClient {

    @GetMapping(path = "/findVehicule/{id}")
    VehiculeResponseDto findVehiculeById(@PathVariable Long id);
}

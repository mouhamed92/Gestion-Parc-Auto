package tn.sncft.entretienservice.restClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.sncft.entretienservice.model.Vehicule;

@FeignClient(name = "VEHICULE-SERVICE")
public interface VehiculeRestClient {

    @GetMapping(path = "/findVehicule/{idVehicule}")
    Vehicule findVehicule(@PathVariable Long idVehicule);


}

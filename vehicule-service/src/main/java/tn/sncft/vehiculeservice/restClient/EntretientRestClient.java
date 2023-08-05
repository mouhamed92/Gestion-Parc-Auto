package tn.sncft.vehiculeservice.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tn.sncft.vehiculeservice.model.Entretien;

import java.util.List;

@FeignClient(name = "ENTRETIEN-SERVICE")
public interface EntretientRestClient {

    @GetMapping("/entretiens")
    List<Entretien> findAllEntretien();
}

package tn.sncft.vehiculeservice.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tn.sncft.vehiculeservice.model.Entretien;
import tn.sncft.vehiculeservice.model.Mission;

import java.util.List;

@FeignClient("MISSION-SERVICE")
public interface MissionRestClient {

    @GetMapping("/mission")
    List<Mission> findAllMission();
}

package tn.sncft.vehiculeservice.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tn.sncft.vehiculeservice.dtos.MissionResponseDto;
import tn.sncft.vehiculeservice.model.Mission;
import java.util.List;

@FeignClient(name = "MISSION-SERVICE")
public interface MissionRestClient {


    @GetMapping(path = "/listMissions")
    List<MissionResponseDto> findAllMission();
}

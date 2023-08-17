package tn.sncft.missionservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.sncft.missionservice.dtos.MissionRequestDto;
import tn.sncft.missionservice.dtos.MissionResponseDto;
import tn.sncft.missionservice.services.MissionService;

import java.util.List;

@RestController
public class MissionController {

    @Autowired
    MissionService missionService ;

    @PostMapping(path = "/addMission")
    public MissionResponseDto saveMission(@RequestBody MissionRequestDto missionRequestDto){
        return missionService.aadMission(missionRequestDto);
    }

    @GetMapping("/listMissions")
    List<MissionResponseDto> findAllMission(){
               return missionService.findAllMission();
    }
}

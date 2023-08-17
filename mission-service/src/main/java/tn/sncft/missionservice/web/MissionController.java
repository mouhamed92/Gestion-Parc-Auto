package tn.sncft.missionservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sncft.missionservice.dtos.MissionIdRequestDto;
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

    @GetMapping(path = "/findmission")
    public MissionResponseDto findVehicule(@RequestBody MissionIdRequestDto missionIdRequestDto){
        return missionService.findMission(missionIdRequestDto);
    }
    @PutMapping(path = "/updateMission")
    public  MissionResponseDto updateMission(@RequestBody MissionRequestDto missionRequestDto) throws Exception {
        return missionService.updateMission(missionRequestDto);
    }

    @DeleteMapping(path = "/deleteMission")
    public void deleteMission(@RequestBody MissionIdRequestDto missionIdRequestDto){
        missionService.deleteMission(missionIdRequestDto);
    }

}

package tn.sncft.missionservice.services;

import tn.sncft.missionservice.dtos.MissionIdRequestDto;
import tn.sncft.missionservice.dtos.MissionRequestDto;
import tn.sncft.missionservice.dtos.MissionResponseDto;
import tn.sncft.missionservice.repositories.MissionRepository;

import java.util.List;

public interface MissionService {


    public MissionResponseDto aadMission(MissionRequestDto missionRequestDto);
    public MissionResponseDto updateMission(MissionRequestDto missionRequestDto) throws Exception;
    public void deleteMission(MissionIdRequestDto missionIdRequestDto);
    public MissionResponseDto findMission(MissionIdRequestDto missionIdRequestDto);
    public List<MissionResponseDto> findAllMission();

}

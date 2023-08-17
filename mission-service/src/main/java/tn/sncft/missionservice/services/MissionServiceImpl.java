package tn.sncft.missionservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.sncft.missionservice.dtos.MissionRequestDto;
import tn.sncft.missionservice.dtos.MissionResponseDto;
import tn.sncft.missionservice.dtos.VehiculeResponseDto;
import tn.sncft.missionservice.entities.Mission;
import tn.sncft.missionservice.repositories.MissionRepository;
import tn.sncft.missionservice.restClients.ChauffeurRestClient;
import tn.sncft.missionservice.restClients.VehiculeRestClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MissionServiceImpl implements MissionService {

    @Autowired
    MissionRepository missionRepository;
    @Autowired
    VehiculeRestClient vehiculeRestClient;
    @Autowired
    ChauffeurRestClient chauffeurRestClient;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public MissionResponseDto aadMission(MissionRequestDto missionRequestDto) {

        Mission mission;
        MissionResponseDto missionResponseDto ;
        VehiculeResponseDto vehicule = vehiculeRestClient.findVehiculeById(missionRequestDto.getIdVehicule());

         mission = new Mission().builder()
                .idVehicule(vehicule.getId())    /*  Feign client service chauffeur n'est pas encore devlopper */
                .idChauffeur(missionRequestDto.getIdChauffeur())
                .dateMission(missionRequestDto.getDateMission())
                .destination(missionRequestDto.getDestination())
                .build();

        missionRepository.save(mission);

        missionResponseDto = modelMapper.map(mission,MissionResponseDto.class);

        return missionResponseDto ;
    }

    @Override
    public MissionResponseDto findMission(MissionRequestDto missionRequestDto) {
        return null;
    }

    @Override
    public List<MissionResponseDto> findAllMission() {

        List<MissionResponseDto> missionResponseDto = new ArrayList<>();
        List<Mission> missions = new ArrayList<>() ;

        missionRepository.findAll().forEach(m->
        {
            missions.add(m);
            System.out.println(m);
        });

        missions.forEach(mission -> {
            missionResponseDto.add(modelMapper.map(mission, MissionResponseDto.class));
        });
        return missionResponseDto;
    }

    @Override
    public MissionResponseDto updateMission(MissionRequestDto missionRequestDto) throws Exception {
        return null;
    }

    @Override
    public void deleteMission(MissionRequestDto missionRequestDto) {

    }




}

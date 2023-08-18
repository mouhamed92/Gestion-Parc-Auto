package tn.sncft.missionservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.sncft.missionservice.dtos.MissionIdRequestDto;
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
    public MissionResponseDto findMission(MissionIdRequestDto idRequestDto) {
        Mission mission ;
        MissionResponseDto missionResponseDto ;

        mission = missionRepository.findById(idRequestDto.getId()).get();

        if (mission==null){
            System.out.println("mission introuvable..!");
        }

        missionResponseDto = modelMapper.map(mission,MissionResponseDto.class);

        return missionResponseDto ;
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
        Mission mission ;
        MissionResponseDto missionResponseDto ;

        mission = missionRepository.findById(missionRequestDto.getId()).get();

        if(mission.equals(null)) throw new Exception("mission introuvable !");

        mission.setIdVehicule(missionRequestDto.getIdVehicule());
        mission.setIdChauffeur(missionRequestDto.getIdChauffeur());
        mission.setDateMission(missionRequestDto.getDateMission());
        mission.setDestination(missionRequestDto.getDestination());

        missionRepository.save(mission);

        missionResponseDto = modelMapper.map(mission,MissionResponseDto.class);

        return missionResponseDto ;
    }

    @Override
    public void deleteMission(MissionIdRequestDto missionIdRequestDto) {

        Mission mission ;
        mission = missionRepository.findById(missionIdRequestDto.getId()).get();
        try {
            missionRepository.delete(mission);
            System.out.println("Supression éffectuer avec succé...");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public MissionResponseDto saveMisssion(Mission mission){
        missionRepository.save(mission);
        MissionResponseDto responseDto = modelMapper.map(mission,MissionResponseDto.class);
        return responseDto ;
    }

}

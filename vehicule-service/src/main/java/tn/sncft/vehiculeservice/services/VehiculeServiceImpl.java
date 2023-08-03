package tn.sncft.vehiculeservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.sncft.vehiculeservice.dtos.*;
import tn.sncft.vehiculeservice.entities.Vehicule;
import tn.sncft.vehiculeservice.model.Entretien;
import tn.sncft.vehiculeservice.model.Mission;
import tn.sncft.vehiculeservice.repositories.VehiculeRepository;
import tn.sncft.vehiculeservice.restClient.EntretientRestClient;
import tn.sncft.vehiculeservice.restClient.MissionRestClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    VehiculeRepository vehiculeRepository ;
    @Autowired
    EntretientRestClient entretientRestClient;
    @Autowired
    MissionRestClient missionRestClient ;
    @Autowired
    ModelMapper modelMapper ;

    @Override
    public VehiculeResponseDto aadVehicule(VehiculeRequestDto vehiculeRequestDto) {

        Vehicule vehicule ;
        VehiculeResponseDto vehiculeResponseDto ;

            vehicule = new Vehicule().builder()
                     .marque(vehiculeRequestDto.getMarque())
                     .modele(vehiculeRequestDto.getModele())
                     .annee(vehiculeRequestDto.getAnnee())
                     .typeCarburant(vehiculeRequestDto.getTypeCarburant())
                     .matricule(vehiculeRequestDto.getMatricule())
                     .build();

             vehiculeRepository.save(vehicule);

             vehiculeResponseDto = modelMapper.map(vehicule,VehiculeResponseDto.class);

        return vehiculeResponseDto ;
    }

    @Override
    public VehiculeResponseDto updateVehicule(VehiculeRequestDto vehiculeRequestDto) throws Exception {

        Vehicule vehicule ;
        VehiculeResponseDto vehiculeResponseDto ;

        vehicule = vehiculeRepository.findById(vehiculeRequestDto.getId()).get();

        if(vehicule.equals(null)) throw new Exception("vehicule introuvable !");

        vehicule.setMarque(vehiculeRequestDto.getMarque());
        vehicule.setModele(vehiculeRequestDto.getModele());
        vehicule.setAnnee(vehiculeRequestDto.getAnnee());
        vehicule.setTypeCarburant(vehiculeRequestDto.getTypeCarburant());
        vehicule.setMatricule(vehicule.getMatricule());

        vehiculeRepository.save(vehicule);

        vehiculeResponseDto = modelMapper.map(vehicule,VehiculeResponseDto.class);

        return vehiculeResponseDto;
    }

    @Override
    public void deleteVehicule(VehiculeIdRequestDto idRequestDto) {

        Vehicule vehicule ;
        vehicule = vehiculeRepository.findById(idRequestDto.getId()).get();
        try {
            vehiculeRepository.delete(vehicule);
            System.out.println("Supression éffectuer avec succé...");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public VehiculeResponseDto findVehicule(VehiculeIdRequestDto idRequestDto) {

        Vehicule vehicule ;
        VehiculeResponseDto vehiculeResponseDto ;

        vehicule = vehiculeRepository.findById(idRequestDto.getId()).get();

        if (vehicule==null){
            System.out.println("vehicule introuvable..!");
        }

        vehiculeResponseDto = modelMapper.map(vehicule,VehiculeResponseDto.class);

        return vehiculeResponseDto;
    }

    @Override
    public List<VehiculeResponseDto> findAllVehicule() {

        List<VehiculeResponseDto> vehiculeResponseDto = new ArrayList<>();
        List<Vehicule> vehicules = new ArrayList<>() ;

         vehiculeRepository.findAll().forEach(v->
         {
             vehicules.add(v);
             System.out.println(v);
         });

         vehicules.forEach(vehicule -> {
             vehiculeResponseDto.add(modelMapper.map(vehicule, VehiculeResponseDto.class));
         });
             return vehiculeResponseDto;
    }

    @Override
    public List<EntretientResponseDto> findHistoriqueEntretiens(VehiculeIdRequestDto vehiculeIdRequestDto) {

        List<Entretien> entretiens = new ArrayList<>();

        entretientRestClient.findAllEntretien().forEach(entretien -> {
            if (entretien.getIdVehicle() == vehiculeIdRequestDto.getId()){
                entretiens.add(entretien) ;
            }
        });

        if(entretiens.equals(null)) {
            System.out.println("pas des entretiens à afficher");
            return null ;
        }else {
            List<EntretientResponseDto> entretientResponseDto = new ArrayList<>() ;
            entretiens.forEach(entretien -> {
                entretientResponseDto.add(modelMapper.map(entretien,EntretientResponseDto.class));
            });
            return entretientResponseDto ;
        }
    }

    @Override
    public List<MissionResponseDto> findHistoriqueMission(VehiculeIdRequestDto vehiculeIdRequestDto) {
        List<Mission> missions= new ArrayList<>();

        missionRestClient.findAllMission().forEach(mission -> {
            if (mission.getIdVehicle() == vehiculeIdRequestDto.getId()){
                missions.add(mission) ;
            }
        });

        if(missions.equals(null)) {
            System.out.println("pas des missions à afficher");
            return null ;
        }else {
            List<MissionResponseDto> missionResponseDto = new ArrayList<>() ;
            missions.forEach(mission -> {
                missionResponseDto.add(modelMapper.map(mission,MissionResponseDto.class));
            });
            return missionResponseDto ;
        }
    }
}
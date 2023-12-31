package tn.sncft.vehiculeservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import tn.sncft.vehiculeservice.dtos.*;
import tn.sncft.vehiculeservice.entities.Vehicule;
import tn.sncft.vehiculeservice.model.Entretien;
import tn.sncft.vehiculeservice.model.Mission;
import tn.sncft.vehiculeservice.repositories.VehiculeRepository;
import tn.sncft.vehiculeservice.restClient.EntretientRestClient;
import tn.sncft.vehiculeservice.restClient.MissionRestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {
    /**
     * Service vehicule contient tout les operation
     * ajout-suppression-modification-consultation liste des entretiens lié a une véhicule...
     */
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
        vehicule.setMatricule(vehiculeRequestDto.getMatricule());

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

        List<EntretientResponseDto> entretientResponseDto = new ArrayList<>();

        List<EntretientResponseDto> entretiens =  entretientRestClient.findAllEntretien();
        System.out.println(entretiens);

        if (entretiens.isEmpty()) {
            System.out.println("pas des entretiens à afficher");
        } else {
            entretiens.forEach(entretien -> {
                if(entretien.getIdVehicle()==vehiculeIdRequestDto.getId()){
                entretientResponseDto.add(modelMapper.map(entretien, EntretientResponseDto.class));
                }
            });
        }
        return entretientResponseDto;
    }

    @Override
    public List<MissionResponseDto> findHistoriqueMission(VehiculeIdRequestDto vehiculeIdRequestDto) {
        List<MissionResponseDto> missionResponseDto = new ArrayList<>();

        List<MissionResponseDto> missions =  missionRestClient.findAllMission();
        System.out.println(missions);

        if (missions.isEmpty()) {
            System.out.println("pas des missions à afficher");
        } else {
            missions.forEach(mission -> {
                if(mission.getIdVehicule()==vehiculeIdRequestDto.getId()){
                    missionResponseDto.add(modelMapper.map(mission, MissionResponseDto.class));
                }
            });
        }
        return missionResponseDto;
    }



    /**
     * methode pour le prototype avec thymeleaf utilisé dans le controller V2
     */
    @Override
    public Vehicule findVehiculeById(Long id) {
        return vehiculeRepository.findById(id).get();
    }

    public List<VehiculeResponseDto> findByContainName(String keyWord){
        List<Vehicule> vehicules = vehiculeRepository.findByMarqueContains(keyWord);
        List<VehiculeResponseDto> vehiculeResponseDtos = new ArrayList<>();
        vehicules.forEach(v->{
            vehiculeResponseDtos.add(modelMapper.map(v,VehiculeResponseDto.class));
        });

        return  vehiculeResponseDtos ;
    }

    public VehiculeResponseDto saveVehicule(Vehicule vehicule){
        vehiculeRepository.save(vehicule);
        VehiculeResponseDto responseDto = modelMapper.map(vehicule,VehiculeResponseDto.class);
        return responseDto ;
    }

    @Override
    public List<EntretientResponseDto> listeEntretiens(Long id) {

        List<EntretientResponseDto> entretientResponseDto = new ArrayList<>();

        List<EntretientResponseDto> entretiens =  entretientRestClient.findAllEntretien();
        System.out.println(entretiens);

        if (entretiens.isEmpty()) {
            System.out.println("pas des entretiens à afficher");
        } else {
            entretiens.forEach(entretien -> {
                if(entretien.getIdVehicle()==id){
                    entretientResponseDto.add(modelMapper.map(entretien, EntretientResponseDto.class));
                }
            });
        }
        return entretientResponseDto;
    }

    @Override
    public List<MissionResponseDto> listeMissions(Long id) {
        List<MissionResponseDto> missionResponseDtos = new ArrayList<>();

        List<MissionResponseDto> missions =  missionRestClient.findAllMission();
        System.out.println(missions);

        if (missions.isEmpty()) {
            System.out.println("pas des entretiens à afficher");
        } else {
            missions.forEach(mission -> {
                if(mission.getIdVehicule()==id){
                    missionResponseDtos.add(modelMapper.map(mission, MissionResponseDto.class));
                }
            });
        }
        return missionResponseDtos;
    }

}

package tn.sncft.entretienservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.sncft.entretienservice.dtos.*;
import tn.sncft.entretienservice.entities.Entretien;
import tn.sncft.entretienservice.model.Vehicule;
import tn.sncft.entretienservice.repositories.EntretienRepository;
import tn.sncft.entretienservice.restClients.VehiculeRestClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EntretienServiceImpl implements EntretienService {

    @Autowired
    EntretienRepository entretienRepository ;
    @Autowired
    VehiculeRestClient vehiculeRestClient ;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public EntretienResponseDto aadEntretien(EntretienRequestDto entretienRequestDto) {
        
        EntretienResponseDto entretienResponseDto = new EntretienResponseDto();
        Long idVehicule = entretienRequestDto.getIdVehicle();

            Vehicule vehicule = vehiculeRestClient.findVehicule(idVehicule);
            System.out.println(vehicule);

            if (vehicule.getId() != vehicule.getId()) {
                System.out.println("vérifier identifiant véhicule..!");
            } else {
                Entretien entretien = new Entretien().builder()
                        .idVehicle(entretienRequestDto.getIdVehicle())
                        .dateMaintenance(entretienRequestDto.getDateMaintenance())
                        .detailsMaintenance(entretienRequestDto.getDetailsMaintenance())
                        .montantMaintenance(entretienRequestDto.getMontantMaintenance())
                        .build();

                entretienRepository.save(entretien);
                System.out.println(entretien);
                System.out.println("Entretien ajouté avec succé...");

                entretienResponseDto = modelMapper.map(entretien, EntretienResponseDto.class);

            }

            return entretienResponseDto;

        }
    @Override
    public EntretienResponseDto updateEntretien(EntretienRequestDto entretienRequestDto) throws Exception {

        Entretien entretien ;
        EntretienResponseDto entretienResponseDto ;

        entretien = entretienRepository.findById(entretienRequestDto.getId()).get();

        if(entretien.equals(null)) throw new Exception("entretien introuvable !");

        entretien.setIdVehicle(entretienRequestDto.getIdVehicle());
        entretien.setDateMaintenance(entretienRequestDto.getDateMaintenance());
        entretien.setMontantMaintenance(entretien.getMontantMaintenance());
        entretien.setDetailsMaintenance(entretienRequestDto.getDetailsMaintenance());

        entretienRepository.save(entretien);

        entretienResponseDto = modelMapper.map(entretien,EntretienResponseDto.class);

        return entretienResponseDto;
    }

    @Override
    public void deleteEntretien(EntretienIdRequestDto entretienIdRequestDto) {

        Entretien entretien ;
        entretien = entretienRepository.findById(entretienIdRequestDto.getId()).get();
        try {
            entretienRepository.delete(entretien);
            System.out.println("Supression éffectuer avec succé...");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public EntretienResponseDto findEntretien(EntretienIdRequestDto entretienIdRequestDto) {

        Entretien entretien ;
        EntretienResponseDto entretienResponseDto ;

        entretien = entretienRepository.findById(entretienIdRequestDto.getId()).get();

        if (entretien==null){
            System.out.println("entretien introuvable..!");
        }

        entretienResponseDto = modelMapper.map(entretien,EntretienResponseDto.class);

        return entretienResponseDto ;
    }

    @Override
    public List<EntretienResponseDto> findAllEntretien() {

        List<EntretienResponseDto> entretienResponseDto = new ArrayList<>();
        List<Entretien> entretiens = new ArrayList<>() ;

        entretienRepository.findAll().forEach(e->
        {
            entretiens.add(e);
            System.out.println(e);
        });

        entretiens.forEach(entretien -> {
            entretienResponseDto.add(modelMapper.map(entretien, EntretienResponseDto.class));
        });
        return entretienResponseDto;
    }
}





















/*        try {
            if (vehiculeRestClient.findVehicule(entretienRequestDto.getIdVehicle()) == null) {
                System.out.println("vérifier identifiant véhicule..!");
            } else {
                entretien = new Entretien().builder()
                        .idVehicle(entretienRequestDto.getIdVehicle())
                        .dateMaintenance(entretienRequestDto.getDateMaintenance())
                        .detailsMaintenance(entretienRequestDto.getDetailsMaintenance())
                        .montantMaintenance(entretienRequestDto.getMontantMaintenance())
                        .build();

                entretienRepository.save(entretien);
                System.out.println(entretien);
                System.out.println("Entretien ajouté avec succé...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
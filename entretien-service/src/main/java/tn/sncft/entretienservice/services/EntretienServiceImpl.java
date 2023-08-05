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
        
/*        Entretien entretien = new Entretien().builder()
                .idVehicle(entretienRequestDto.getIdVehicle())
                .dateMaintenance(entretienRequestDto.getDateMaintenance())
                .detailsMaintenance(entretienRequestDto.getDetailsMaintenance())
                .montantMaintenance(entretienRequestDto.getMontantMaintenance())
                .build();

        entretienRepository.save(entretien);
        System.out.println(entretien);
        System.out.println("Entretien ajouté avec succé...");*/

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
        return null;
    }

    @Override
    public void deleteEntretien(EntretienIdRequestDto entretienIdRequestDto) {

    }

    @Override
    public EntretienResponseDto findEntretien(EntretienIdRequestDto entretienIdRequestDto) {
        return null;
    }

    @Override
    public List<EntretienResponseDto> findAllEntretien() {
        return null;
    }
}

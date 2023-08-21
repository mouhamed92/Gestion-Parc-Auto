package tn.sncft.entretienservice.services;

import tn.sncft.entretienservice.dtos.EntretienIdRequestDto;
import tn.sncft.entretienservice.dtos.EntretienRequestDto;
import tn.sncft.entretienservice.dtos.EntretienResponseDto;

import java.util.List;

public interface EntretienService {

    public EntretienResponseDto aadEntretien(EntretienRequestDto entretienRequestDto);
    public EntretienResponseDto updateEntretien(EntretienRequestDto entretienRequestDto) throws Exception;
    public void deleteEntretien(EntretienIdRequestDto entretienIdRequestDto);
    public EntretienResponseDto findEntretien(EntretienIdRequestDto entretienIdRequestDto);
    public List<EntretienResponseDto> findAllEntretien();

    //Afficher l'historique d'entretien d'un véhicule

    //Vérifier les entretiens à venir

    //Notifier les entretiens prévus

   //Générer des rapports liés aux entrtiens
}

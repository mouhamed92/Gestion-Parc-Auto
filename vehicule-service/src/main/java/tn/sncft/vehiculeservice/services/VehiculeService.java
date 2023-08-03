package tn.sncft.vehiculeservice.services;

import tn.sncft.vehiculeservice.dtos.*;

import java.util.List;

public interface VehiculeService {

    public VehiculeResponseDto aadVehicule(VehiculeRequestDto vehiculeRequestDto);
    public VehiculeResponseDto updateVehicule(VehiculeRequestDto vehiculeRequestDto) throws Exception;
    public void deleteVehicule(VehiculeIdRequestDto vehiculeIdRequestDto);
    public VehiculeResponseDto findVehicule(VehiculeIdRequestDto vehiculeIdRequestDto);
    public List<VehiculeResponseDto> findAllVehicule();
    public List<EntretientResponseDto> findHistoriqueEntretiens(VehiculeIdRequestDto vehiculeIdRequestDto);
    public List<MissionResponseDto> findHistoriqueMission(VehiculeIdRequestDto vehiculeIdRequestDto);

   //Générer des rapports liés aux véhicules

   //Vérifier la disponibilité d'un véhicule
}

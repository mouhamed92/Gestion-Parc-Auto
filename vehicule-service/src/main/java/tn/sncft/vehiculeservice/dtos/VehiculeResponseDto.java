package tn.sncft.vehiculeservice.dtos;

import lombok.Data;

@Data
public class VehiculeResponseDto {
    Long id;
    String marque;
    String modele;
    int annee;
    String typeCarburant;
    String matricule ;
}

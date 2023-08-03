package tn.sncft.vehiculeservice.dtos;

import lombok.Data;

@Data
public class VehiculeRequestDto {

    Long id;
    String marque;
    String modele;
    int annee;
    String typeCarburant;
    String matricule ;
}

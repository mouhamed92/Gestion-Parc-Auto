package tn.sncft.missionservice.model;

import lombok.Data;

@Data
public class Vehicule {

    Long id;
    String marque;
    String modele;
    int annee;
    String typeCarburant;
    String matricule ;
}

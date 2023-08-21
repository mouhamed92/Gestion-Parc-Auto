package tn.sncft.entretienservice.model;

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

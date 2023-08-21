package tn.sncft.carburantservice.model;

import lombok.Data;

@Data
public class Agent {

    private Long id ;
    private String matricule ;
    private String nom ;
    private String prenom ;
    private String email;

   // private CategorieAgent categorie;
}

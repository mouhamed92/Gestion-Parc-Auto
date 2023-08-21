package tn.sncft.carburantservice.dtos;

import lombok.Data;

@Data
public class AgentResponseDto {
    private Long id ;
    private String matricule ;
    private String nom ;
    private String prenom ;
    private String email;

    // private CategorieAgent categorie;
}

package tn.sncft.Agentservice.dtos;

import lombok.Data;
import tn.sncft.Agentservice.Enum.CategorieAgent;

@Data
public class AgentRequestDto {

    private String matricule ;
    private String nom ;
    private String prenom ;
    private String email;
    private CategorieAgent categorie;
}

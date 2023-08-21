package tn.sncft.Agentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.sncft.Agentservice.Enum.CategorieAgent;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Agent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String matricule ;
    private String nom ;
    private String prenom ;
    private String email;
    @Enumerated(EnumType.STRING)
    private CategorieAgent categorie;

}

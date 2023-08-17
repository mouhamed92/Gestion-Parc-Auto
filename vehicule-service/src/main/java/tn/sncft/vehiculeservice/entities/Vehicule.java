package tn.sncft.vehiculeservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty
    @Size(min = 3, max = 20)
    String marque;
    String modele;
    @DecimalMin("2000")
    @DecimalMax("2023")
    int annee;
    String typeCarburant;
    @Size(min = 9,max = 9)
    String matricule ;

}

package tn.sncft.missionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Mission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long idVehicule;
    private Long idChauffeur;
    private LocalDate dateMission;
    private String destination ;
}

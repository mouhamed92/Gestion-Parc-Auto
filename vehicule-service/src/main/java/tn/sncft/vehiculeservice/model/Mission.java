package tn.sncft.vehiculeservice.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Mission {
   private Long id ;
   private Long idVehicule;
   private Long idChauffeur;
   private LocalDate dateMission;
   private String destination ;
}

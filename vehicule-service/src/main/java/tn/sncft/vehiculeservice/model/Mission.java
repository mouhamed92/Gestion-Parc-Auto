package tn.sncft.vehiculeservice.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Mission {
   private Long id;
   private Long idVehicle;
   private Long idChauffeur;
   private LocalDate startDate;
   private LocalDate endDate;
}

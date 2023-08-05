package tn.sncft.entretienservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntretienRequestDto {
   private Long idVehicle;
   private LocalDate dateMaintenance;
   private double montantMaintenance;
   private String detailsMaintenance ;
}

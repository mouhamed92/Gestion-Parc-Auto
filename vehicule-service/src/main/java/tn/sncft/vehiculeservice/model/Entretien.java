package tn.sncft.vehiculeservice.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Entretien {

  private Long id;
  private Long idVehicle;
  private LocalDate maintenanceDate;
  private double maintenanceCost;
  private String replacedParts;

}

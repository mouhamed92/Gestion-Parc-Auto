package tn.sncft.vehiculeservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntretientResponseDto {

    private Long id;
    private Long idVehicle;
    private LocalDate maintenanceDate;
    private double maintenanceCost;
    private String replacedParts;

}

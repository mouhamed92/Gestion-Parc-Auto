package tn.sncft.entretienservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntretienRequestDto {
    Long id;
    Long idVehicle;
    LocalDate dateMaintenance;
    double montantMaintenance;
    String detailsMaintenance ;
}

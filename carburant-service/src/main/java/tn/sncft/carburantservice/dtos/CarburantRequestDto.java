package tn.sncft.carburantservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarburantRequestDto {

    private int qteRecharger;
    private int stockeCarburant;
    private LocalDate date ;
    private String details ;
}

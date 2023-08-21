package tn.sncft.carburantservice.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CarburantResponseDto {

    private Long id ;
    private int qteRecharger;
    private int stockeCarburant;
    private LocalDate date ;
    private String details ;
}

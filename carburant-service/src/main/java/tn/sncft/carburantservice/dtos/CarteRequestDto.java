package tn.sncft.carburantservice.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import java.time.LocalDate;

@Data
public class CarteRequestDto {

    private String numCarte;
    private Long idAgent;
    private String matriculeAgent ;
    private int qteRecharger;
    private String typeCarburant;
    private int soldeCarburant ;
    private LocalDate dateRecharge;
}

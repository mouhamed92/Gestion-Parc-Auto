package tn.sncft.carburantservice.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CarteResponseDto {

    private Long id ;
    private String numCarte;
    private String matriculeAgent ;
    private String typeCarburant;
    private int qteRecharger;
    private int soldeCarburant ;
    private LocalDate dateRecharge;
}

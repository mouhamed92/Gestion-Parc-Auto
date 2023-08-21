package tn.sncft.carburantservice.dtos;

import lombok.Data;

@Data
public class RecCarteReqestDto {

    private Long idCarburant;
    private int qteRecharge ;
    private Long idCarte;
}

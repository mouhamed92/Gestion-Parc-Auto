package tn.sncft.carburantservice.services;

import tn.sncft.carburantservice.dtos.CarteRequestDto;
import tn.sncft.carburantservice.dtos.CarteResponseDto;
import tn.sncft.carburantservice.dtos.RecCarteReqestDto;

public interface CarteService {

    public CarteResponseDto createCarte(CarteRequestDto carteRequestDto);

    public CarteResponseDto rechargeCarte(RecCarteReqestDto recCarteReqestDto);

}

package tn.sncft.carburantservice.services;

import tn.sncft.carburantservice.dtos.CarburantArchiveResponseDto;
import tn.sncft.carburantservice.dtos.CarburantIdRequestDto;
import tn.sncft.carburantservice.dtos.CarburantRequestDto;
import tn.sncft.carburantservice.dtos.CarburantResponseDto;

import java.util.List;

public interface CarburantService {

    public CarburantResponseDto ajoutCarburant(CarburantRequestDto carburantRequestDto);
    public List<CarburantArchiveResponseDto> consulterArchiveCarburant();

    public CarburantResponseDto consulterCarburant(Long idCarburant);

    public CarburantResponseDto updateCarburant(int qteCarburant,Long idCarburant);

    public CarburantResponseDto consulterCarburantR(CarburantIdRequestDto carburantIdRequestDto);
}

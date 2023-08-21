package tn.sncft.carburantservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sncft.carburantservice.dtos.CarburantArchiveResponseDto;
import tn.sncft.carburantservice.dtos.CarburantIdRequestDto;
import tn.sncft.carburantservice.dtos.CarburantRequestDto;
import tn.sncft.carburantservice.dtos.CarburantResponseDto;
import tn.sncft.carburantservice.services.CarburantService;

import java.util.List;

@RestController
public class CarburantController {

    @Autowired
    CarburantService carburantService;

    @PostMapping(path = "/addCarburant")
    public CarburantResponseDto addCarburant(@RequestBody CarburantRequestDto carburantRequestDto) {
        return carburantService.ajoutCarburant(carburantRequestDto);
    }

    @GetMapping(path = "/findCarburant")
    public CarburantResponseDto findCarburant(@RequestBody CarburantIdRequestDto carburantIdRequestDto) {
        return carburantService.consulterCarburantR(carburantIdRequestDto);
    }


    @GetMapping(path = "/findArchiveCrb")
    public List<CarburantArchiveResponseDto> archiveCarburant(){
        return carburantService.consulterArchiveCarburant();
    }
}

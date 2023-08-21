package tn.sncft.carburantservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.sncft.carburantservice.dtos.CarteRequestDto;
import tn.sncft.carburantservice.dtos.CarteResponseDto;
import tn.sncft.carburantservice.dtos.RecCarteReqestDto;
import tn.sncft.carburantservice.services.CarteService;

@RestController
public class CarteController {

    @Autowired
    CarteService carteService ;

    @PostMapping(path = "/createCarte")
    public CarteResponseDto crateCarte(@RequestBody CarteRequestDto carteRequestDto){
        return carteService.createCarte(carteRequestDto);
    }

    @PutMapping(path = "/rechargeC")
    public CarteResponseDto rechargeCarte(@RequestBody RecCarteReqestDto recCarteReqestDto){
        return carteService.rechargeCarte(recCarteReqestDto);
    }
}

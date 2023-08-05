package tn.sncft.entretienservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.sncft.entretienservice.dtos.EntretienRequestDto;
import tn.sncft.entretienservice.dtos.EntretienResponseDto;
import tn.sncft.entretienservice.services.EntretienService;

@RestController
public class EntretienController {

    @Autowired
    EntretienService entretienService ;

    @PostMapping(path= "/addEntretien")
    EntretienResponseDto saveEntretien(@RequestBody EntretienRequestDto entretienRequestDto){
        return entretienService.aadEntretien(entretienRequestDto);
    }
}

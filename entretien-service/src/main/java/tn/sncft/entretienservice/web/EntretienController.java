package tn.sncft.entretienservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sncft.entretienservice.dtos.EntretienIdRequestDto;
import tn.sncft.entretienservice.dtos.EntretienRequestDto;
import tn.sncft.entretienservice.dtos.EntretienResponseDto;
import tn.sncft.entretienservice.services.EntretienService;

import java.util.List;

@RestController
public class EntretienController {

    @Autowired
    EntretienService entretienService ;

    @PostMapping(path= "/addEntretien")
    EntretienResponseDto saveEntretien(@RequestBody EntretienRequestDto entretienRequestDto){
        return entretienService.aadEntretien(entretienRequestDto);
    }

    @PutMapping(path = "/updateEntretien")
    EntretienResponseDto updateEntretien(@RequestBody EntretienRequestDto entretienRequestDto) throws Exception {
        return entretienService.updateEntretien(entretienRequestDto);
    }

    @GetMapping(path = "/findEntretien")
    public EntretienResponseDto findEntretien(@RequestBody EntretienIdRequestDto entretienIdRequestDto){
        return entretienService.findEntretien(entretienIdRequestDto);
    }

    @GetMapping(path = "/allEntretiens")
    public List<EntretienResponseDto> findAllEntretien(){
        return entretienService.findAllEntretien();
    }

    @DeleteMapping(path = "/deleteEntretien")
    public void deleteEntretien(@RequestBody EntretienIdRequestDto entretienIdRequestDto){
        entretienService.deleteEntretien(entretienIdRequestDto);
    }
}

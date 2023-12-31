package tn.sncft.vehiculeservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sncft.vehiculeservice.dtos.*;
import tn.sncft.vehiculeservice.entities.Vehicule;
import tn.sncft.vehiculeservice.repositories.VehiculeRepository;
import tn.sncft.vehiculeservice.services.VehiculeService;

import java.util.List;

@RestController
public class VehiculeController {

    @Autowired
    VehiculeService vehiculeService ;

    @Autowired
    VehiculeRepository vehiculeRepository ;

    @PostMapping(path = "/addVehicule")
    public VehiculeResponseDto saveVehicule(@RequestBody VehiculeRequestDto vehiculeRequestDto){
        return vehiculeService.aadVehicule(vehiculeRequestDto);
    }

    @PutMapping(path = "/updateVehicule")
    public  VehiculeResponseDto updateVehicule(@RequestBody VehiculeRequestDto vehiculeRequestDto) throws Exception {
        return vehiculeService.updateVehicule(vehiculeRequestDto);
    }

    @DeleteMapping(path = "/deleteVehicule")
    public void deleteVehicule(@RequestBody VehiculeIdRequestDto vehiculeIdRequestDto){
        vehiculeService.deleteVehicule(vehiculeIdRequestDto);
    }

    @GetMapping(path = "/findVehicule")
    public VehiculeResponseDto findVehicule(@RequestBody VehiculeIdRequestDto vehiculeIdRequestDto){
       return vehiculeService.findVehicule(vehiculeIdRequestDto);
    }

    @GetMapping(path = "/findAllVehicule")
    public List<VehiculeResponseDto> findVehicule() {
        return vehiculeService.findAllVehicule();
    }

    @GetMapping(path = "/listeEntretiens")
    public List<EntretientResponseDto> findEntretiens(@RequestBody VehiculeIdRequestDto vehiculeIdRequestDto){
        return vehiculeService.findHistoriqueEntretiens(vehiculeIdRequestDto);
    }

    @GetMapping(path = "/listMissions")
    public List<MissionResponseDto> findMissions(@RequestBody VehiculeIdRequestDto vehiculeIdRequestDto){
        return vehiculeService.findHistoriqueMission(vehiculeIdRequestDto);
    }

    @GetMapping(path = "/findVehicule/{id}")
    Vehicule findVehiculeById(@PathVariable Long id){
        return vehiculeService.findVehiculeById(id);
    }
}

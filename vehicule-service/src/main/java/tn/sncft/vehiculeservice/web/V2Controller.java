package tn.sncft.vehiculeservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tn.sncft.vehiculeservice.dtos.VehiculeResponseDto;
import tn.sncft.vehiculeservice.services.VehiculeService;

import java.util.List;

@Controller
public class V2Controller {

    @Autowired
    VehiculeService vehiculeService ;

    @GetMapping(path = "/index")
    public String vehicules(Model model){
       List<VehiculeResponseDto> vehicules = vehiculeService.findAllVehicule();
       model.addAttribute("listVehicules",vehicules);
       return "vehicules";
    }
}

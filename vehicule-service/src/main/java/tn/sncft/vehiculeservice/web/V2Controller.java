package tn.sncft.vehiculeservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.sncft.vehiculeservice.dtos.EntretientResponseDto;
import tn.sncft.vehiculeservice.dtos.VehiculeResponseDto;
import tn.sncft.vehiculeservice.entities.Vehicule;
import tn.sncft.vehiculeservice.services.VehiculeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class V2Controller {

    @Autowired
    VehiculeService vehiculeService ;

    @GetMapping(path = "/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path = "/addVehicule")
    public String formVehicule(Model model){
        model.addAttribute("vehicule",new VehiculeResponseDto());
        return "addVehicule";
    }

    @PostMapping(path = "/saveVehicule")
    public String saveVehicule(Model model, @Valid Vehicule vehicule, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "addVehicule" ;

        vehiculeService.saveVehicule(vehicule);
        return "redirect:/addVehicule";
    }

    @GetMapping(path = "/index")
    public String vehicules(Model model,
                            @RequestParam(name="keyWord",defaultValue = "")String keyWord){

       List<VehiculeResponseDto> vehicules = vehiculeService.findByContainName(keyWord);
       model.addAttribute("listVehicules",vehicules);
       model.addAttribute("keyWord",keyWord);
       return "vehicules";
    }

    @GetMapping(path = "/displayEntretiens")
    public String displayEntretiens(Model model , Long id){
        List<EntretientResponseDto> responseDtos = vehiculeService.listeEntretiens(id);
        double sum = 0;
        for (EntretientResponseDto response : responseDtos) {
            sum += response.getMontantMaintenance();
        }
        model.addAttribute("entretiens",responseDtos);
        model.addAttribute("sum", sum);

        return "listeEntretiens";
    }

}

package tn.sncft.missionservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tn.sncft.missionservice.dtos.MissionResponseDto;
import tn.sncft.missionservice.entities.Mission;
import tn.sncft.missionservice.services.MissionService;

import javax.validation.Valid;

@Controller
public class V2Controller {

    @Autowired
    MissionService missionService ;
    @GetMapping(path = "/addMission")
    public String formMission(Model model){
        model.addAttribute("mission",new MissionResponseDto());

        return "addMission";
    }

    @PostMapping(path = "/saveMission")
    public String saveMission(Model model, Mission mission){
        missionService.saveMisssion(mission);
        return "redirect:/addMission";
    }

    @GetMapping(path = "/index")
    public String home(){
        return "redirect:http://localhost:8081/index";
    }
}

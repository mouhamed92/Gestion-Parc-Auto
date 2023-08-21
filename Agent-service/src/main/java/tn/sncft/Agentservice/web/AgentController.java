package tn.sncft.Agentservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sncft.Agentservice.dtos.AgentIdRequestDto;
import tn.sncft.Agentservice.dtos.AgentRequestDto;
import tn.sncft.Agentservice.dtos.AgentResponseDto;
import tn.sncft.Agentservice.services.AgentService;

import java.util.List;

@RestController
public class AgentController {
    @Autowired
    AgentService agentService ;
    @PostMapping(path = "/addAgent")
    public AgentResponseDto addAgent(@RequestBody AgentRequestDto agentRequestDto){
        return agentService.addAgent(agentRequestDto);
    }
    @GetMapping(path = "/displayAll")
    public List<AgentResponseDto> findAgents(){
        return agentService.findAllAgent();
    }
    @GetMapping(path = "/findAgent")
    public AgentResponseDto findAgent(@RequestBody AgentIdRequestDto idRequestDto){
        return agentService.findAgent(idRequestDto);
    }

    @GetMapping(path = "/findAgent/{id}")
    public AgentResponseDto findAgent(@PathVariable Long id){
        return agentService.findAgent(id);
    }

}

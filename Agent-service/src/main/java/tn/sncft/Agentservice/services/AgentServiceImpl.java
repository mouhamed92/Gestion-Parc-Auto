package tn.sncft.Agentservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import tn.sncft.Agentservice.dtos.AgentIdRequestDto;
import tn.sncft.Agentservice.dtos.AgentRequestDto;
import tn.sncft.Agentservice.dtos.AgentResponseDto;
import tn.sncft.Agentservice.entities.Agent;
import tn.sncft.Agentservice.repositories.AgentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository ;
    @Autowired
    ModelMapper modelMapper ;
    @Override
    public AgentResponseDto addAgent(AgentRequestDto agentRequestDto) {

        Agent agent ;
        AgentResponseDto responseDto = new AgentResponseDto();

        agent = Agent.builder()
                .nom(agentRequestDto.getNom())
                .prenom(agentRequestDto.getPrenom())
                .matricule(agentRequestDto.getMatricule())
                .email(agentRequestDto.getEmail())
                .categorie(agentRequestDto.getCategorie())
                .build();

        agentRepository.save(agent);

        responseDto = modelMapper.map(agent,AgentResponseDto.class);

        return responseDto ;
    }

    @Override
    public List<AgentResponseDto> findAllAgent() {

        List<Agent> agents = new ArrayList<>();
        List<AgentResponseDto> agentResponseDtos = new ArrayList<>();

         agentRepository.findAll().forEach(agent -> {
             agents.add(agent);
         });

        agents.forEach(agent -> {
            agentResponseDtos.add(modelMapper.map(agent,AgentResponseDto.class));
        });

        return agentResponseDtos ;
    }

    @Override
    public AgentResponseDto findAgent(AgentIdRequestDto idRequestDto) {

        Agent agent ;
        AgentResponseDto agentResponseDto ;

        agent = agentRepository.findById(idRequestDto.getId()).get();
        agentResponseDto = modelMapper.map(agent,AgentResponseDto.class);

        return agentResponseDto;
    }

    @Override
    public AgentResponseDto findAgent(Long id) {

        Agent agent ;
        AgentResponseDto agentResponseDto ;

        agent = agentRepository.findById(id).get();
        agentResponseDto = modelMapper.map(agent,AgentResponseDto.class);

        return agentResponseDto;
    }


}

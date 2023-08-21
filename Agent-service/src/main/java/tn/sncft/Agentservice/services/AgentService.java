package tn.sncft.Agentservice.services;

import tn.sncft.Agentservice.dtos.AgentIdRequestDto;
import tn.sncft.Agentservice.dtos.AgentRequestDto;
import tn.sncft.Agentservice.dtos.AgentResponseDto;

import java.util.List;

public interface AgentService {

    public AgentResponseDto addAgent(AgentRequestDto agentRequestDto);

    public List<AgentResponseDto> findAllAgent();

    public AgentResponseDto findAgent(AgentIdRequestDto idRequestDto);

    public AgentResponseDto findAgent(Long id) ;
}

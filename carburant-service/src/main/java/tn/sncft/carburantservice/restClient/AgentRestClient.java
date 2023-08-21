package tn.sncft.carburantservice.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.sncft.carburantservice.dtos.AgentResponseDto;

@FeignClient(name = "AGENT-SERVICE")
public interface AgentRestClient {

    @GetMapping(path = "/findAgent/{id}")
    public AgentResponseDto findAgent(@PathVariable Long id);
}

package tn.sncft.carburantservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.sncft.carburantservice.dtos.*;
import tn.sncft.carburantservice.entities.Carte;
import tn.sncft.carburantservice.repositories.CarteRepository;
import tn.sncft.carburantservice.restClient.AgentRestClient;

@Service
@Transactional
public class CarteServiceImpl implements CarteService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CarteRepository carteRepository ;
    @Autowired
    AgentRestClient agentRestClient ;
    @Autowired
    CarburantService carburantService ;

    @Override
    public CarteResponseDto createCarte(CarteRequestDto carteRequestDto) {

        Carte carte = new Carte();
        CarteResponseDto carteResponseDto ;

        //Vérifer si l'agent existe
        AgentResponseDto agent = agentRestClient.findAgent(carteRequestDto.getIdAgent());
        if(agent.equals(null)){
            System.out.println("Agent non identifier !");
            return null ;
        }

        //update stocke carburant si égale à zero archiver :

        carte = Carte.builder()
                .numCarte(carteRequestDto.getNumCarte())
                .idAgent(carteRequestDto.getIdAgent())
                .matriculeAgent(agent.getMatricule())
                .qteRecharger(carteRequestDto.getQteRecharger())
                .soldeCarburant(0)
                .dateRecharge(carteRequestDto.getDateRecharge())
                .typeCarburant(carteRequestDto.getTypeCarburant())
                .build();

             carteRepository.save(carte);

             carteResponseDto = modelMapper.map(carte,CarteResponseDto.class);

             return carteResponseDto;
    }

    @Override
    public CarteResponseDto rechargeCarte(RecCarteReqestDto recCarteReqestDto) {

        CarburantResponseDto carburantResponseDto = carburantService.consulterCarburant(recCarteReqestDto.getIdCarburant());
        System.out.println(carburantResponseDto);
        Carte carte ;
        CarteResponseDto carteResponseDto ;

        //Vérifier si le stocke de carburant est suffisant

        if(carburantResponseDto.getStockeCarburant()-recCarteReqestDto.getQteRecharge()<0) {
            System.out.println("stock insuffisant");
            return null;
        }

       carte = carteRepository.findById(recCarteReqestDto.getIdCarte()).get();

        carte.setSoldeCarburant(carte.getSoldeCarburant()+recCarteReqestDto.getQteRecharge());

        carteRepository.save(carte);

        carburantService.updateCarburant(recCarteReqestDto.getQteRecharge(),recCarteReqestDto.getIdCarburant());

        carteResponseDto = modelMapper.map(carte,CarteResponseDto.class);

        return carteResponseDto ;
    }


}

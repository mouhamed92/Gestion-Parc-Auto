package tn.sncft.carburantservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.sncft.carburantservice.dtos.CarburantArchiveResponseDto;
import tn.sncft.carburantservice.dtos.CarburantIdRequestDto;
import tn.sncft.carburantservice.dtos.CarburantRequestDto;
import tn.sncft.carburantservice.dtos.CarburantResponseDto;
import tn.sncft.carburantservice.entities.Carburant;
import tn.sncft.carburantservice.entities.CarburantArchive;
import tn.sncft.carburantservice.repositories.CarburantArchiveRepository;
import tn.sncft.carburantservice.repositories.CarburantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarburantServiceImpl implements CarburantService {

    @Autowired
    ModelMapper modelMapper ;
    @Autowired
    CarburantRepository carburantRepository ;
    @Autowired
    private CarburantArchiveRepository carburantArchiveRepository;

    @Override
    public CarburantResponseDto ajoutCarburant(CarburantRequestDto carburantRequestDto) {

        Carburant carburant = new Carburant();
        CarburantResponseDto carburantResponseDto ;

        carburant = Carburant.builder()
                .qteRecharger(carburantRequestDto.getQteRecharger())
                .stockeCarburant(carburant.getStockeCarburant()+ carburantRequestDto.getQteRecharger())
                .date(carburantRequestDto.getDate())
                .details(carburantRequestDto.getDetails()).build();

        carburantRepository.save(carburant);

        carburantResponseDto = modelMapper.map(carburant,CarburantResponseDto.class);

        return carburantResponseDto;
    }

    @Override
    public CarburantResponseDto consulterCarburant(Long idCarburant) {

        Carburant carburant = new Carburant() ;
        CarburantResponseDto carburantResponseDto ;

        carburant = carburantRepository.findById(idCarburant).get();


             carburantResponseDto = modelMapper.map(carburant,CarburantResponseDto.class);

        return  carburantResponseDto;
    }

    @Override
    public CarburantResponseDto consulterCarburantR(CarburantIdRequestDto carburantIdRequestDto) {

        Carburant carburant = new Carburant() ;
        CarburantResponseDto carburantResponseDto ;

        carburant = carburantRepository.findById(carburantIdRequestDto.getIdCarburant()).get();


        carburantResponseDto = modelMapper.map(carburant,CarburantResponseDto.class);

        return  carburantResponseDto;
    }

    public CarburantResponseDto updateCarburant(int qteCarburant,Long idCarburant){

        CarburantResponseDto carburantResponseDto ;
       Carburant carburant = carburantRepository.findById(idCarburant).get();
       carburant.setStockeCarburant(carburant.getStockeCarburant()-qteCarburant);
       carburantRepository.save(carburant);

       carburantResponseDto = modelMapper.map(carburant,CarburantResponseDto.class);

       return carburantResponseDto ;


    }




    @Override
    public List<CarburantArchiveResponseDto> consulterArchiveCarburant() {

        List<CarburantArchive> carburants = new ArrayList<>();
        List<CarburantArchiveResponseDto> carburantArchiveResponseDtos = new ArrayList<>() ;

        carburantArchiveRepository.findAll().forEach(carburantA -> {
            carburants.add(carburantA);
        });

        carburants.forEach(carburant -> {
            carburantArchiveResponseDtos.add(modelMapper.map(carburant,CarburantArchiveResponseDto.class));
        });

        return carburantArchiveResponseDtos;
    }


}

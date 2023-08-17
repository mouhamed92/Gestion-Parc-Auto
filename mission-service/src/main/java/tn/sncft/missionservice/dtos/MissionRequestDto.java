package tn.sncft.missionservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MissionRequestDto {
    private Long id ;
    private Long idVehicule;
    private Long idChauffeur;
    private LocalDate dateMission;
    private String destination ;
}

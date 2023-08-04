package tn.sncft.entretienservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Entretien {

    @Id @GeneratedValue
    Long id;
    Long idVehicle;
    LocalDate dateMaintenance;
    double montantMaintenance;
    String detailsMaintenance ;
}

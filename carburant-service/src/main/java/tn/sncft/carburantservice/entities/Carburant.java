package tn.sncft.carburantservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Carburant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int qteRecharger;
    private int stockeCarburant;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date ;
    private String details ;
}

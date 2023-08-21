package tn.sncft.carburantservice.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class CarburantArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int qteRecharger;
    private int stockeCarburant;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date ;
    private String details ;
}

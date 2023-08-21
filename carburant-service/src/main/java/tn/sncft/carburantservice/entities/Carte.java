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
import javax.validation.constraints.DecimalMax;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Carte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String numCarte;
    private Long idAgent;
    private String matriculeAgent ;
    private String typeCarburant;
    private int qteRecharger;
    @DecimalMax("200")
    private int soldeCarburant ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRecharge;
}

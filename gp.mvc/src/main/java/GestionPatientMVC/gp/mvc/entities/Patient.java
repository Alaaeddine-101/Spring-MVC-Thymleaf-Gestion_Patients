package GestionPatientMVC.gp.mvc.entities;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity @lombok.Data @AllArgsConstructor
public class Patient {

    @Id @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(min = 4, max = 20)
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    @DecimalMin("30")

    private int score;

    public Patient() {

    }
}

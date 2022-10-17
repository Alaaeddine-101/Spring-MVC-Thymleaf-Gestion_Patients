package GestionPatientMVC.gp.mvc.entities;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity @lombok.Data @AllArgsConstructor @NoArgsConstructor
public class Patient {

    @Id @GeneratedValue
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;

}

package GestionPatientMVC.gp.mvc.repositories;

import GestionPatientMVC.gp.mvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // puisque la methode return une page il faut ajouter le parametre pageable ,c-a-d une methode pagine
    Page<Patient> findByNomContains(String keyword, Pageable pageable);
}

package GestionPatientMVC.gp.mvc.sec.repositories;

import GestionPatientMVC.gp.mvc.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUserName(String username);
}

package GestionPatientMVC.gp.mvc.sec.repositories;

import GestionPatientMVC.gp.mvc.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}

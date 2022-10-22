package GestionPatientMVC.gp.mvc.sec.service;

import GestionPatientMVC.gp.mvc.sec.entities.AppRole;
import GestionPatientMVC.gp.mvc.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String userName, String password, String rePassword);
    AppRole saveNewrole(String roleName, String roleDesc);
    void addRoleToUser(String userName, String roleName);
    void removeRoleFromUser(String userName, String roleName);
    AppUser loadByUserName(String userName);
}
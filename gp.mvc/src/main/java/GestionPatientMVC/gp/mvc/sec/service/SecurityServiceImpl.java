package GestionPatientMVC.gp.mvc.sec.service;

import GestionPatientMVC.gp.mvc.sec.entities.AppRole;
import GestionPatientMVC.gp.mvc.sec.entities.AppUser;
import GestionPatientMVC.gp.mvc.sec.repositories.AppRoleRepository;
import GestionPatientMVC.gp.mvc.sec.repositories.AppUserRepository;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl  implements SecurityService{

    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser saveNewUser(String userName, String password, String repassword) {
        if(!password.equals(repassword)){
            throw new RuntimeException("Password not match!!");
        }
        String hashedPwd = passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUserName(userName);
        appUser.setPassword(hashedPwd);
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewrole(String roleName, String roleDesc) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole != null) throw new RuntimeException("Role "+ roleName +" already exist!!");
        appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setRoleDesc(roleDesc);
        AppRole saveAppRole = appRoleRepository.save(appRole);
        return  saveAppRole;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser appUser = appUserRepository.findByUserName(userName);
        if(appUser == null) throw new RuntimeException("User not found!!");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole == null) throw new RuntimeException("Role not found!!");
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public void removeRoleFromUser(String userName, String roleName) {
        AppUser appUser = appUserRepository.findByUserName(roleName);
        if(appUser == null) throw new RuntimeException("User not found!!");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole == null) throw new RuntimeException("Role not found!!");
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }
}

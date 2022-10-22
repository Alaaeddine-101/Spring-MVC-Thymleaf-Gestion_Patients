package GestionPatientMVC.gp.mvc;

import GestionPatientMVC.gp.mvc.entities.Patient;
import GestionPatientMVC.gp.mvc.repositories.PatientRepository;
import GestionPatientMVC.gp.mvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//@Bean
//	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
//		return args -> {
//			patientRepository.save(
//					new Patient(null, "Ahmed", new Date(), false, 90));
//			patientRepository.save(
//					new Patient(null, "Ayoube", new Date(), true, 100));
//			patientRepository.save(
//					new Patient(null, "Hanaa", new Date(), false, 225));
//			patientRepository.save(
//					new Patient(null, "Kawter", new Date(), true, 130));
//
//			patientRepository.findAll().forEach(p -> {
//				System.out.println(p.getNom());
//			});
//		};
//	}
	@Bean
	CommandLineRunner saveUsers(SecurityService securityService){
		return args -> {
//			securityService.saveNewUser("alaa","1234","1234");
//			securityService.saveNewUser("abdo","1234","1234");
//			securityService.saveNewUser("yazid","1234","1234");
//
//
//			securityService.saveNewrole("USER","");
//			securityService.saveNewrole("ADMIN","");
//
//			securityService.addRoleToUser("alaa","ADMIN");
//			securityService.addRoleToUser("alaa","USER");
//			securityService.addRoleToUser("abdo","USER");
//			securityService.addRoleToUser("yazid","USER");


		};
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}

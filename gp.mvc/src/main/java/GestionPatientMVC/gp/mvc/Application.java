package GestionPatientMVC.gp.mvc;

import GestionPatientMVC.gp.mvc.entities.Patient;
import GestionPatientMVC.gp.mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(
					new Patient(null, "Ahmed", new Date(), false, 20));
			patientRepository.save(
					new Patient(null, "Ayoube", new Date(), true, 10));
			patientRepository.save(
					new Patient(null, "Hanaa", new Date(), false, 25));
			patientRepository.save(
					new Patient(null, "Kawter", new Date(), true, 13));

			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};
	}

}

package be.condorcet.pharmacie4_4;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class GestPatient {

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping("/tous")
    public String affTous(Map<String, Object> model) {
        List<Patient> liste;

        try {
            liste = patientRepository.findAll();
            model.put("patients", liste);

        } catch (Exception e) {
            model.put("error", e.getMessage());
            System.out.println("----------erreur lors de la recherche-------- " + e);
            return "error";
        }
        return "affichagetousPatients";
    }

    @RequestMapping("/selection")
    public String selection(@RequestParam("numPatient") int numPatient, Map<String, Object> model) {
        Optional<Patient> patient;

        try {
            patient = patientRepository.findById(numPatient);

            if (patient.isEmpty()) {
                throw new Exception("patient inconnu");
            }

            patient.ifPresent((patient_) -> {
                model.put("patient", patient_);
            });
        } catch (Exception e) {
            model.put("error", e.getMessage());
            System.out.println("erreur lors de la lecture " + e);
            return "error";
        }
        return "affPatient";  // page html à développer
    }

    @RequestMapping("/selectionName")
    public String selection(@RequestParam("name") String name, Map<String, Object> model) {
        Optional<Patient> patient;

        try {
            patient = patientRepository.findPatientByNom(name);

            if (patient.isEmpty()) {
                throw new Exception("patient inconnu");
            }

            patient.ifPresent((patient_) -> {
                model.put("patient", patient_);
            });
        } catch (Exception e) {
            model.put("error", e.getMessage());
            System.out.println("erreur lors de la lecture " + e);
            return "error";
        }
        return "affPatient";  // page html à développer
    }
}
package be.condorcet.pharmacie4_4;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.repositories.PatientRepository;
import be.condorcet.pharmacie4_4.servicies.PatientServiceImpl;
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
    PatientServiceImpl patientService;

    @RequestMapping("/tous")
    public String affTous(Map<String, Object> model) {
        List<Patient> liste;

        try {
            liste = patientService.all();
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
        Patient patient;

        try {
            patient = patientService.read(numPatient);

            model.put("patient", patient);
        } catch (Exception e) {
            model.put("error", e.getMessage());
            System.out.println("erreur lors de la lecture " + e);
            return "error";
        }
        return "affPatient";  // page html à développer
    }

    @RequestMapping("/selectionName")
    public String selection(@RequestParam("name") String name, Map<String, Object> model) {
        List<Patient> patient;

        try {
            patient = patientService.read(name);

            model.put("patient", patient.get(0));
        } catch (Exception e) {
            model.put("error", e.getMessage());
            System.out.println("erreur lors de la lecture " + e);
            return "error";
        }
        return "affPatient";  // page html à développer
    }
}
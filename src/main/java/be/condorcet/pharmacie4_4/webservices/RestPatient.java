package be.condorcet.pharmacie4_4.webservices;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.servicies.patient.InterfacePatientService;
import be.condorcet.pharmacie4_4.servicies.patient.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/patients")
public class RestPatient {

    @Autowired
    private InterfacePatientService patientService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws Exception {
        patientService.create(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Patient> readById(@PathVariable(value = "id") int id) throws Exception {
        Patient patient = patientService.read(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/nom={nom}", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> readByNom(@PathVariable(value = "nom") String nom) throws Exception {
        List<Patient> patients = patientService.read(nom);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    //readPatientsByPrescriptionsDate
    @RequestMapping(value = "/pres={date_pres}", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> readPatientsByPrescriptionsDate(
            @PathVariable(value = "date_pres") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date_pres) throws Exception {
        List<Patient> patients = ((PatientServiceImpl)patientService).readPatientsByPrescriptionsDate(date_pres);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") int id, @RequestBody Patient newPatient) throws Exception {
        newPatient.setId(id);
        Patient patient = patientService.update(newPatient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePatient(@PathVariable(value = "id") int id) throws Exception {
        Patient patient = patientService.read(id);
        patientService.delete(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> listClient() throws Exception {
        return new ResponseEntity<>(patientService.all(), HttpStatus.OK);
    }
}

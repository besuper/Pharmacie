package be.condorcet.pharmacie4_4.webservices;

import be.condorcet.pharmacie4_4.entities.Prescription;
import be.condorcet.pharmacie4_4.servicies.prescription.InterfacePrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/prescriptions")
public class RestPrescription {

    @Autowired
    private InterfacePrescriptionService prescriptionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) throws Exception {
        prescriptionService.create(prescription);
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Prescription> readById(@PathVariable(value = "id") int id) throws Exception {
        Prescription prescription = prescriptionService.read(id);
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @RequestMapping(value = "/{start}/{end}", method = RequestMethod.GET)
    public ResponseEntity<List<Prescription>> readBetweenDates(
            @PathVariable(value = "start") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate start,
            @PathVariable(value = "end") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate end
    ) throws Exception {
        List<Prescription> prescriptions = prescriptionService.readBetweenDates(start, end);
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Prescription> updatePrescription(@PathVariable(value = "id") int id, @RequestBody Prescription newPrescription) throws Exception {
        newPrescription.setId(id);
        Prescription prescription = prescriptionService.update(newPrescription);
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePrescription(@PathVariable(value = "id") int id) throws Exception {
        Prescription prescription = prescriptionService.read(id);
        prescriptionService.delete(prescription);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Prescription>> listPrescriptions() throws Exception {
        return new ResponseEntity<>(prescriptionService.all(), HttpStatus.OK);
    }
}

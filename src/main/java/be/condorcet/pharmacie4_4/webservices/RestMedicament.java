package be.condorcet.pharmacie4_4.webservices;

import be.condorcet.pharmacie4_4.entities.Medicament;
import be.condorcet.pharmacie4_4.servicies.medicament.InterfaceMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/medicaments")
public class RestMedicament {

    @Autowired
    private InterfaceMedicamentService medicamentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Medicament> createMedicament(@RequestBody Medicament medicament) throws Exception {
        medicamentService.create(medicament);
        return new ResponseEntity<>(medicament, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medicament> readById(@PathVariable(value = "id") int id) throws Exception {
        Medicament medicament = medicamentService.read(id);
        return new ResponseEntity<>(medicament, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Medicament> updateMedicament(@PathVariable(value = "id") int id, @RequestBody Medicament newMedicament) throws Exception {
        newMedicament.setId(id);
        Medicament medicament = medicamentService.update(newMedicament);
        return new ResponseEntity<>(medicament, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMedicament(@PathVariable(value = "id") int id) throws Exception {
        Medicament medicament = medicamentService.read(id);
        medicamentService.delete(medicament);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Medicament>> listMedicament() throws Exception {
        return new ResponseEntity<>(medicamentService.all(), HttpStatus.OK);
    }

}

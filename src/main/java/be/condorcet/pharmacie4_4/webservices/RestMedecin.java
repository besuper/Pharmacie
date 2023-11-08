package be.condorcet.pharmacie4_4.webservices;

import be.condorcet.pharmacie4_4.entities.Medecin;
import be.condorcet.pharmacie4_4.servicies.medecin.InterfaceMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/medecins")
public class RestMedecin {

    @Autowired
    private InterfaceMedecinService medecinService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Medecin> createMedecin(@RequestBody Medecin medecin) throws Exception {
        medecinService.create(medecin);
        return new ResponseEntity<>(medecin, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medecin> readById(@PathVariable(value = "id") int id) throws Exception {
        Medecin medecin = medecinService.read(id);
        return new ResponseEntity<>(medecin, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Medecin> updateMedecin(@PathVariable(value = "id") int id, @RequestBody Medecin newMedecin) throws Exception {
        newMedecin.setId(id);
        Medecin medecin = medecinService.update(newMedecin);
        return new ResponseEntity<>(medecin, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMedecin(@PathVariable(value = "id") int id) throws Exception {
        Medecin medecin = medecinService.read(id);
        medecinService.delete(medecin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Medecin>> listMedecin() throws Exception {
        return new ResponseEntity<>(medecinService.all(), HttpStatus.OK);
    }

}

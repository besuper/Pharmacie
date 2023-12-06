package be.condorcet.pharmacie4_4.webservices;

import be.condorcet.pharmacie4_4.entities.*;
import be.condorcet.pharmacie4_4.servicies.info.InterfaceInfoService;
import be.condorcet.pharmacie4_4.servicies.medicament.InterfaceMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/infos")
public class RestInfo {

    @Autowired
    private InterfaceInfoService infoService;

    /*@Autowired
    private InterfacePrescriptionService prescriptionService;*/

    @Autowired
    private InterfaceMedicamentService medicamentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Info> createInfo(@RequestBody Info info) throws Exception {

        // Return values in fontend
        //Prescription tempPrescription = prescriptionService.read(info.getPrescription().getId());
        Medicament tempMedicament = medicamentService.read(info.getMedicament().getId());

        info.setMedicament(tempMedicament);
        //info.setPrescription(tempPrescription);

        info.setId(new InfoKey(info.getMedicament().getId(), info.getPrescription().getId()));

        infoService.create(info);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @RequestMapping(value = "/{prescriptionId}", method = RequestMethod.GET)
    public ResponseEntity<List<Info>> readInfosByPrescription(@PathVariable(value = "prescriptionId") int prescriptionId) throws Exception {
        Prescription searchPrescription = new Prescription();
        searchPrescription.setId(prescriptionId);

        List<Info> infos = infoService.readPrescriptions(searchPrescription);
        return new ResponseEntity<>(infos, HttpStatus.OK);
    }

}

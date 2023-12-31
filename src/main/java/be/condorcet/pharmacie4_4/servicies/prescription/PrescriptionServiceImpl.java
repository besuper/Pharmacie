package be.condorcet.pharmacie4_4.servicies.prescription;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.entities.Prescription;
import be.condorcet.pharmacie4_4.repositories.PrescriptionRepository;
import be.condorcet.pharmacie4_4.servicies.prescription.InterfacePrescriptionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class PrescriptionServiceImpl implements InterfacePrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription create(Prescription prescription) throws Exception {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription read(Integer id) throws Exception {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);

        return prescription.get();
    }

    @Override
    public Prescription update(Prescription prescription) throws Exception {
        read(prescription.getId());

        return prescriptionRepository.save(prescription);
    }

    @Override
    public void delete(Prescription prescription) throws Exception {
        prescriptionRepository.deleteById(prescription.getId());
    }

    @Override
    public List<Prescription> all() throws Exception {
        return prescriptionRepository.findAll();
    }

    @Override
    public List<Prescription> readBetweenDates(LocalDate start, LocalDate end) throws Exception {
        return prescriptionRepository.findPrescriptionsByDatePrescriptionBetween(start, end);
    }

    @Override
    public List<Prescription> getPrescriptions(Patient patient) throws Exception {
        return prescriptionRepository.findPrescriptionsByPatient(patient);
    }
}

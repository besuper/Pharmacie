package be.condorcet.pharmacie4_4.servicies.patient;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.repositories.PatientRepository;
import be.condorcet.pharmacie4_4.servicies.patient.InterfacePatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class PatientServiceImpl implements InterfacePatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient create(Patient patient) throws Exception {
        return patientRepository.save(patient);
    }

    @Override
    public Patient read(Integer id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);

        return patient.get();
    }

    public List<Patient> readPatientsByPrescriptionsDate(LocalDate date_pres) throws Exception {
        return patientRepository.findPatientsByPrescriptionsDate(date_pres);
    }

    @Override
    public Patient update(Patient patient) throws Exception {
        read(patient.getId());

        return patientRepository.save(patient);
    }

    @Override
    public void delete(Patient patient) throws Exception {
        patientRepository.deleteById(patient.getId());
    }

    @Override
    public List<Patient> all() throws Exception {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> read(String nom) throws Exception {
        return patientRepository.findPatientByNom(nom);
    }
}

package be.condorcet.pharmacie4_4.servicies;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Patient> read(String nom) {
        return patientRepository.findPatientByNom(nom);
    }
}

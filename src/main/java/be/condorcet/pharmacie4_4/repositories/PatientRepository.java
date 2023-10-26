package be.condorcet.pharmacie4_4.repositories;

import be.condorcet.pharmacie4_4.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> findPatientByNom(String nom) throws Exception;

}

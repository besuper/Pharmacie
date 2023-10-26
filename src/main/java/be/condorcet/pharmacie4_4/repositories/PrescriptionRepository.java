package be.condorcet.pharmacie4_4.repositories;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    public List<Prescription> findPrescriptionsByDatePrescriptionBetween(LocalDate start, LocalDate end);

    public List<Prescription> findPrescriptionsByPatient(Patient patient);

}

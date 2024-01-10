package be.condorcet.pharmacie4_4.repositories;

import be.condorcet.pharmacie4_4.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public List<Patient> findPatientByNom(String nom) throws Exception;

    @Query(value = "SELECT pres.patient FROM Prescription pres WHERE pres.datePrescription = :date_pres")
    public List<Patient> findPatientsByPrescriptionsDate(@Param("date_pres") LocalDate date_pres) throws Exception;

}

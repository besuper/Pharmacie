package be.condorcet.pharmacie4_4.repositories;

import be.condorcet.pharmacie4_4.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
}

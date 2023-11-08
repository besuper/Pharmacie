package be.condorcet.pharmacie4_4.repositories;

import be.condorcet.pharmacie4_4.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {
}

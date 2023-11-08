package be.condorcet.pharmacie4_4.repositories;

import be.condorcet.pharmacie4_4.entities.Info;
import be.condorcet.pharmacie4_4.entities.InfoKey;
import be.condorcet.pharmacie4_4.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, InfoKey> {

    List<Info> findInfosByPrescription(Prescription prescription) throws Exception;

}

package be.condorcet.pharmacie4_4.servicies;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.servicies.patient.PatientServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private PatientServiceImpl patientService;

    Patient patient;

    @BeforeEach
    void setUp() {
        try {
            patient = new Patient(null, "TEST", "NomTest", "PrenomTest", LocalDate.now(), new ArrayList<>());
            //patient = new Patient(null, "TEST", "NomTest", "PrenomTest", LocalDate.now());
            patientService.create(patient);

            System.out.println("création du patient : " + patient);
        } catch (Exception e) {
            System.out.println("erreur de création du patient : " + patient + " erreur : " + e);
        }
    }

    @AfterEach
    void tearDown() {
        try {
            patientService.delete(patient);

            System.out.println("effacement du patient : " + patient);
        } catch (Exception e) {
            System.out.println("erreur d'effacement du patient :" + patient + " erreur : " + e);
        }
    }

    @Test
    void create() {
        assertNotEquals(0, patient.getId(), "id patient non incrémenté");
        assertEquals("NomTest", patient.getNom(), "nom patient non enregistré : " + patient.getNom() + " au lieu de NomTest");
        assertEquals("PrenomTest", patient.getPrenom(), "prénom patient non enregistré : " + patient.getPrenom() + " au lieu de PrenomTest");
        assertEquals("TEST", patient.getNss(), "NSS patient non enregistré : " + patient.getNss() + " au lieu de TEST");
    }

    @Test
    void read() {
        try {
            int numPatient = patient.getId();

            Patient patient2 = patientService.read(numPatient);

            assertEquals("NomTest", patient2.getNom(), "noms différents " + "NomTest" + "-" + patient2.getNom());
            assertEquals("PrenomTest", patient2.getPrenom(), "prénoms différents " + "NomTest" + "-" + patient2.getNom());
            assertEquals("TEST", patient2.getNss(), "NSS différents " + "TEST" + "-" + patient2.getNss());
        } catch (Exception e) {
            fail("recherche infructueuse " + e);
        }
    }

    @Test
    void update() {
        try {
            patient.setNom("NomTest2");
            patient.setPrenom("PrenomTest2");
            patient.setNss("TEST2");

            patient = patientService.update(patient);

            assertEquals("NomTest2", patient.getNom(), "noms différents " + "NomTest2-" + patient.getNom());
            assertEquals("PrenomTest2", patient.getPrenom(), "prénoms différents " + "PrenomTest2-" + patient.getPrenom());
            assertEquals("TEST2", patient.getNss(), "nss différents " + "TEST2-" + patient.getNss());
        } catch (Exception e) {
            fail("erreur de mise à jour " + e);
        }
    }

    @Test
    void delete() {
        try {
            patientService.delete(patient);

            Assertions.assertThrows(Exception.class, () -> {
                patientService.read(patient.getId());
            }, "record non effacé");
        } catch (Exception e) {
            fail("erreur d'effacement " + e);
        }
    }

    @Test
    void all() {
        try {
            List<Patient> patients = patientService.all();

            assertNotEquals(0, patients.size(), "la liste ne contient aucun élément");
        } catch (Exception e) {
            fail("erreur de recherche de tous les patients " + e);
        }
    }

    @Test
    void rechercheNom() {
        try{
            List<Patient> patients = patientService.read("NomTest");
            boolean trouve = false;

            for (Patient pat : patients) {
                if (pat.getNom().startsWith("NomTest")) {
                    trouve = true;
                } else {
                    fail("un record ne correspond pas , nom = " + pat.getNom());
                }
            }

            assertTrue(trouve, "record non trouvé dans la liste");
        }catch (Exception e) {
            fail("recherche infructueuse " + e);
        }
    }
}
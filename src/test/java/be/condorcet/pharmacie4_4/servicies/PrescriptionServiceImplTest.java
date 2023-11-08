package be.condorcet.pharmacie4_4.servicies;

import be.condorcet.pharmacie4_4.entities.Medecin;
import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.entities.Prescription;
import be.condorcet.pharmacie4_4.servicies.medecin.MedecinServiceImpl;
import be.condorcet.pharmacie4_4.servicies.patient.PatientServiceImpl;
import be.condorcet.pharmacie4_4.servicies.prescription.PrescriptionServiceImpl;
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
class PrescriptionServiceImplTest {

    @Autowired
    private MedecinServiceImpl medecinService;

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PrescriptionServiceImpl prescriptionService;

    private Prescription prescription;

    private Patient patient;
    private Medecin medecin;

    @BeforeEach
    void setUp() {
        try {
            medecin = new Medecin(null, "MatriculeTest", "NomTest", "PrenomTest", "TelTest", new ArrayList<>());
            medecinService.create(medecin);

            patient = new Patient(null, "TEST", "NomTest", "PrenomTest", LocalDate.now(), new ArrayList<>());
            patientService.create(patient);

            prescription = new Prescription(null, LocalDate.now(), medecin, patient, new ArrayList<>());
            prescriptionService.create(prescription);

            System.out.println("création de la prescription : " + prescription);
        } catch (Exception e) {
            System.out.println("erreur de création de la prescription : " + prescription + " erreur : " + e);
        }
    }

    @AfterEach
    void tearDown() {
        try {
            prescriptionService.delete(prescription);
            patientService.delete(patient);
            medecinService.delete(medecin);

            System.out.println("effacement de la prescription : " + prescription);
        } catch (Exception e) {
            System.out.println("erreur d'effacement de la prescription :" + prescription + " erreur : " + e);
        }
    }

    @Test
    void create() {
        assertNotEquals(0, prescription.getId(), "id prescription non incrémenté");
        assertEquals(LocalDate.now(), prescription.getDatePrescription(), "date prescription non enregistré : " + prescription.getDatePrescription() + " au lieu de " + LocalDate.now());
    }

    @Test
    void read() {
        try {
            int numPrescription = prescription.getId();

            Prescription prescription2 = prescriptionService.read(numPrescription);

            assertEquals(LocalDate.now(), prescription2.getDatePrescription(), "date prescription différent : " + prescription2.getDatePrescription() + " au lieu de " + LocalDate.now());
        } catch (Exception e) {
            fail("recherche infructueuse " + e);
        }
    }

    @Test
    void update() {
        try {
            prescription.setDatePrescription(LocalDate.now().plusDays(1));

            prescription = prescriptionService.update(prescription);

            LocalDate nowPlusOne = LocalDate.now().plusDays(1);

            assertEquals(nowPlusOne, prescription.getDatePrescription(), "date prescription différent : " + prescription.getDatePrescription() + " au lieu de " + nowPlusOne);
        } catch (Exception e) {
            fail("erreur de mise à jour " + e);
        }
    }

    @Test
    void delete() {
        try {
            prescriptionService.delete(prescription);

            Assertions.assertThrows(Exception.class, () -> {
                prescriptionService.read(prescription.getId());
            }, "record non effacé");
        } catch (Exception e) {
            fail("erreur d'effacement " + e);
        }
    }

    @Test
    void all() {
        try {
            List<Prescription> prescriptions = prescriptionService.all();

            assertNotEquals(0, prescriptions.size(), "la liste ne contient aucun élément");
        } catch (Exception e) {
            fail("erreur de recherche de toute les prescriptions " + e);
        }
    }

    @Test
    void readBetweenDates() {
        try {
            LocalDate start = LocalDate.now();
            LocalDate end = start.plusDays(1);

            List<Prescription> prescriptions = prescriptionService.readBetweenDates(start, end);

            assertNotEquals(0, prescriptions.size(), "la liste ne contient aucun élément");
        } catch (Exception e) {
            fail("erreur de recherche de prescriptions par date " + e);
        }
    }

    @Test
    void getPrescriptionsPatient() {
        try {
            List<Prescription> prescriptions = prescriptionService.getPrescriptions(patient);

            assertNotEquals(0, prescriptions.size(), "la liste ne contient aucun élément");
        } catch (Exception e) {
            fail("erreur de recherche des prescriptions du patient " + e);
        }
    }
}
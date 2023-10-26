package be.condorcet.pharmacie4_4.servicies;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.entities.Prescription;

import java.time.LocalDate;
import java.util.List;

public interface InterfacePrescriptionService extends InterfaceService<Prescription> {

    public List<Prescription> readBetweenDates(LocalDate start, LocalDate end);

    public List<Prescription> getPrescriptions(Patient patient);

}

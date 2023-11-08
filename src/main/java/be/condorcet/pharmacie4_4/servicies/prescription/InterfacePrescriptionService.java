package be.condorcet.pharmacie4_4.servicies.prescription;

import be.condorcet.pharmacie4_4.entities.Patient;
import be.condorcet.pharmacie4_4.entities.Prescription;
import be.condorcet.pharmacie4_4.servicies.InterfaceService;

import java.time.LocalDate;
import java.util.List;

public interface InterfacePrescriptionService extends InterfaceService<Prescription> {

    public List<Prescription> readBetweenDates(LocalDate start, LocalDate end) throws Exception;

    public List<Prescription> getPrescriptions(Patient patient) throws Exception;

}

package be.condorcet.pharmacie4_4.servicies;

import be.condorcet.pharmacie4_4.entities.Patient;

import java.util.List;

public interface InterfacePatientService extends InterfaceService<Patient> {

    public List<Patient> read(String nom);

}
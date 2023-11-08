package be.condorcet.pharmacie4_4.servicies.info;

import be.condorcet.pharmacie4_4.entities.Info;
import be.condorcet.pharmacie4_4.entities.InfoKey;
import be.condorcet.pharmacie4_4.entities.Prescription;
import be.condorcet.pharmacie4_4.servicies.InterfaceService;

import java.util.List;

public interface InterfaceInfoService extends InterfaceService<Info> {

    public Info read(InfoKey id) throws Exception;

    public List<Info> readPrescriptions(Prescription prescription) throws Exception;

}
package be.condorcet.pharmacie4_4.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class InfosKey implements Serializable {

    @Column(name = "id_medicament")
    private Integer medicamentId;

    @Column(name = "id_prescription")
    private Integer prescriptionId;

}

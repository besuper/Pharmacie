package be.condorcet.pharmacie4_4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
@AllArgsConstructor
public class InfoKey implements Serializable {

    @Column(name = "id_medicament")
    private Integer medicamentId;

    @Column(name = "id_prescription")
    private Integer prescriptionId;

}

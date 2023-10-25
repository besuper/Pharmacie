package be.condorcet.pharmacie4_4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "APIPRESCRIPTION", schema = "ORA5", catalog = "ORCL.CONDORCET.BE")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_generator")
    @SequenceGenerator(name = "prescription_generator", sequenceName = "APIPRESCRIPTION_SEQ", allocationSize = 1)
    @Column(name = "id_prescription")
    private Integer id;

    @NonNull
    @Column(name = "DATEPRESCRIPTION")
    private LocalDate datePrescription;

    @ManyToOne @JoinColumn(name = "ID_MEDECIN")
    @NonNull
    private Medecin medecin;

    @ManyToOne @JoinColumn(name = "ID_PATIENT")
    @NonNull
    private Patient patient;

    @JsonIgnore
    @OneToMany(mappedBy="prescription")/* @JoinColumn(name = "ID_PRESCRIPTION")*/
    @ToString.Exclude
    private List<Infos> infos = new ArrayList<>();
}

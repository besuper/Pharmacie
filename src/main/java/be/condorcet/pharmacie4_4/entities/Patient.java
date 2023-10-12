package be.condorcet.pharmacie4_4.entities;

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
@Table(name = "APIPatient", schema = "ORA5", catalog = "ORCL.CONDORCET.BE")
public class Patient {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_generator")
    @SequenceGenerator(name = "patient_generator", sequenceName = "APIPATIENT_SEQ", allocationSize = 1)
    @Column(name = "id_patient")
    private Integer id;

    @NonNull
    private String nss;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull @Column(name = "DATENAISSANCE")
    private LocalDate dateNaissance;

    @OneToMany @JoinColumn(name = "ID_PATIENT")
    private List<Prescription> prescription = new ArrayList<>();
}

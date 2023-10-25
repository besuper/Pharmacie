package be.condorcet.pharmacie4_4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "APIMEDECIN", schema = "ORA5", catalog = "ORCL.CONDORCET.BE")
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medecin_generator")
    @SequenceGenerator(name = "medecin_generator", sequenceName = "APIMEDECIN_SEQ1", allocationSize = 1)
    @Column(name = "ID_MEDECIN")
    private Integer id;

    @NonNull
    private String matricule;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String tel;

    @OneToMany @JoinColumn(name = "ID_MEDECIN")
    @ToString.Exclude
    private List<Prescription> prescription = new ArrayList<>();

}

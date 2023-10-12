package be.condorcet.pharmacie4_4.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "APIMEDICAMENT", schema = "ORA5", catalog = "ORCL.CONDORCET.BE")
public class Medicament {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicament_generator")
    @SequenceGenerator(name = "medicament_generator", sequenceName = "APIMEDICAMENT_SEQ", allocationSize = 1)
    @Column(name = "id_medicament")
    private Integer id;

    @NonNull
    private String code;

    @NonNull
    private String nom;

    @NonNull
    private String description;

    @NonNull
    @Column(name = "PRIXUNITAIRE")
    private double prixUnitaire;

}

package be.condorcet.pharmacie4_4.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "APIINFOS", schema = "ORA5", catalog = "ORCL.CONDORCET.BE")
public class Infos {

    @EmbeddedId
    @NonNull
    private InfosKey id;

    @ManyToOne
    @NonNull
    @MapsId("medicamentId")
    @JoinColumn(name = "ID_MEDICAMENT")
    private Medicament medicament;

    @ManyToOne
    @NonNull
    @MapsId("prescriptionId")
    @JoinColumn(name = "ID_PRESCRIPTION")
    private Prescription prescription;

    private int quantite;
}

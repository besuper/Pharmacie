package be.condorcet.pharmacie4_4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@IdClass(Infos.class)
@Table(name = "APIINFOS", schema = "ORA5", catalog = "ORCL.CONDORCET.BE")
public class Infos implements Serializable {

    @NonNull
    private int quantite;

    @Id @ManyToOne @JoinColumn(name = "ID_MEDICAMENT")
    private Medicament medicament;

    @Id @ManyToOne @JoinColumn(name = "ID_PRESCRIPTION")
    private Prescription prescription;
}

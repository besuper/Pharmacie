package be.condorcet.pharmacie4_4.servicies.medicament;

import be.condorcet.pharmacie4_4.entities.Medicament;
import be.condorcet.pharmacie4_4.repositories.MedicamentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class MedicamentServiceImpl implements InterfaceMedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public Medicament create(Medicament medicament) throws Exception {
        return medicamentRepository.save(medicament);
    }

    @Override
    public Medicament read(Integer id) throws Exception {
        Optional<Medicament> medicament = medicamentRepository.findById(id);

        return medicament.get();
    }

    @Override
    public Medicament update(Medicament medicament) throws Exception {
        read(medicament.getId());

        return medicamentRepository.save(medicament);
    }

    @Override
    public void delete(Medicament medicament) throws Exception {
        medicamentRepository.deleteById(medicament.getId());
    }

    @Override
    public List<Medicament> all() throws Exception {
        return medicamentRepository.findAll();
    }
}

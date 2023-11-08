package be.condorcet.pharmacie4_4.servicies.medecin;

import be.condorcet.pharmacie4_4.entities.Medecin;
import be.condorcet.pharmacie4_4.repositories.MedecinRepository;
import be.condorcet.pharmacie4_4.servicies.medecin.InterfaceMedecinService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class MedecinServiceImpl implements InterfaceMedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Medecin create(Medecin medecin) throws Exception {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin read(Integer id) throws Exception {
        Optional<Medecin> medecin = medecinRepository.findById(id);

        return medecin.get();
    }

    @Override
    public Medecin update(Medecin medecin) throws Exception {
        read(medecin.getId());

        return medecinRepository.save(medecin);
    }

    @Override
    public void delete(Medecin medecin) throws Exception {
        medecinRepository.deleteById(medecin.getId());
    }

    @Override
    public List<Medecin> all() throws Exception {
        return medecinRepository.findAll();
    }
}

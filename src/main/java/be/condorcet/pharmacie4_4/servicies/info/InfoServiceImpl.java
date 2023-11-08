package be.condorcet.pharmacie4_4.servicies.info;

import be.condorcet.pharmacie4_4.entities.Info;
import be.condorcet.pharmacie4_4.entities.InfoKey;
import be.condorcet.pharmacie4_4.entities.Prescription;
import be.condorcet.pharmacie4_4.repositories.InfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class InfoServiceImpl implements InterfaceInfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public Info create(Info info) throws Exception {
        return infoRepository.save(info);
    }

    @Override
    public Info read(Integer id) throws Exception {
        throw new Exception("Can't find info with integer ID");
    }

    @Override
    public Info read(InfoKey id) throws Exception {
        Optional<Info> info = infoRepository.findById(id);

        return info.get();
    }

    @Override
    public List<Info> readPrescriptions(Prescription prescription) throws Exception {
        return infoRepository.findInfosByPrescription(prescription);
    }

    @Override
    public Info update(Info info) throws Exception {
        read(info.getId());

        return infoRepository.save(info);
    }

    @Override
    public void delete(Info info) throws Exception {
        infoRepository.deleteById(info.getId());
    }

    @Override
    public List<Info> all() throws Exception {
        return infoRepository.findAll();
    }
}

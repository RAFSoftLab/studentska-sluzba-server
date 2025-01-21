package org.raflab.studsluzba.services;

import org.raflab.studsluzba.model.ObnovaGodineUpisujePredmete;
import org.raflab.studsluzba.model.ObnovaGodineUpisujePredmeteId;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.repositories.ObnovaGodineUpisujePredmeteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ObnovaGodineUpisujePredmeteService {

    @Autowired
    ObnovaGodineUpisujePredmeteRepository repository;

    @Transactional
    public void savePredmeti(Long obnovaGodineId, List<Predmet> predmeti) {
        for (Predmet predmet : predmeti) {
            ObnovaGodineUpisujePredmete record = new ObnovaGodineUpisujePredmete();
            ObnovaGodineUpisujePredmeteId upisGodinePredmetiId = new ObnovaGodineUpisujePredmeteId();
            upisGodinePredmetiId.setObnovaGodineId(obnovaGodineId);
            upisGodinePredmetiId.setUpisujePredmetiId(predmet.getId());
            record.setId(upisGodinePredmetiId);
            repository.save(record);
        }
    }
}

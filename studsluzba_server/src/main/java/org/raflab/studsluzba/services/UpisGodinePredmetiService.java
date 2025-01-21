package org.raflab.studsluzba.services;

import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.UpisGodinePredmeti;
import org.raflab.studsluzba.model.UpisGodinePredmetiId;
import org.raflab.studsluzba.repositories.UpisGodinePredmetiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UpisGodinePredmetiService {

    @Autowired
    UpisGodinePredmetiRepository upisGodinePredmetiRepository;

    @Transactional
    public void savePredmeti(Long upisGodineId, List<Predmet> predmeti) {
        for (Predmet predmet : predmeti) {
            UpisGodinePredmeti record = new UpisGodinePredmeti();
            UpisGodinePredmetiId upisGodinePredmetiId = new UpisGodinePredmetiId();
            upisGodinePredmetiId.setUpisGodineId(upisGodineId);
            upisGodinePredmetiId.setPredmetiId(predmet.getId());
            record.setId(upisGodinePredmetiId);

            upisGodinePredmetiRepository.save(record);
        }
    }
}

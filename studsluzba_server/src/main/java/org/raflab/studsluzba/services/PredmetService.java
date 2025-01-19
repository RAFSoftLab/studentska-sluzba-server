package org.raflab.studsluzba.services;

import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.StudijskiProgram;
import org.raflab.studsluzba.repositories.PredmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredmetService {

    @Autowired
    PredmetRepository predmetRepository;

    public List<Predmet> getPredmetiForUpisGodine(Integer godinaStudija, StudijskiProgram studProgram) {
        return predmetRepository.getPredmetsByGodinaStudijaAndStudProgramAndObavezan(godinaStudija, studProgram, true);
    }

    public List<Predmet> getNepolozeniPredmeti(Long studentIndeksId) {
        return predmetRepository.getNepolozeniPredmeti(studentIndeksId);
    }


}

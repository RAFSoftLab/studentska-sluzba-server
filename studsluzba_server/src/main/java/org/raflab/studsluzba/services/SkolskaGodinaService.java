package org.raflab.studsluzba.services;

import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.repositories.SkolskaGodinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkolskaGodinaService {

    @Autowired
    SkolskaGodinaRepository skolskaGodinaRepository;

    public SkolskaGodina getNewSkolskaGodina() {
        return skolskaGodinaRepository.findTopByOrderByKrajnjaDesc();
    }
}

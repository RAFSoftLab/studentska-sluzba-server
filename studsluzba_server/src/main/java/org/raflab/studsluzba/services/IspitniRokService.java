package org.raflab.studsluzba.services;

import org.raflab.studsluzba.model.IspitniRok;
import org.raflab.studsluzba.repositories.IspitniRokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IspitniRokService {

    @Autowired
    IspitniRokRepository ispitniRokRepository;

    public Iterable<IspitniRok> findAll() {
        return ispitniRokRepository.findAll();
    }

    public IspitniRok save(IspitniRok ispitniRok) {
        return ispitniRokRepository.save(ispitniRok);
    }

    public void deleteById(Long id) {
        ispitniRokRepository.deleteById(id);
    }

    public Iterable<IspitniRok> getForAktivnaSkolsaGodina() {
        return ispitniRokRepository.getForAktivnaSkolskaGodina();
    }

    public IspitniRok getAktivniIspitniRokovi() {
        return ispitniRokRepository.getAktivniIspitniRokovi();
    }
}

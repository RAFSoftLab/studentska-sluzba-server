package org.raflab.studsluzba.services;

import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.model.ObnovaGodine;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.UpisGodine;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TokStudijaService {

    @Autowired
    UpisGodineRepository upisGodineRepo;
    @Autowired
    ObnovaGodineRepository obnovaGodineRepo;
    @Autowired
    UplataRepository uplataRepository;
    @Autowired
    StudentIndeksService studentIndeksService;
    @Autowired
    SkolskaGodinaService skolskaGodinaService;


    public Long addUpis(UpisGodineRequest request) {
        StudentIndeks studentIndeks = studentIndeksService.findByStudentIdAndAktivan(request.getStudentId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        UpisGodine upisGodine = new UpisGodine();
        upisGodine.setStudentIndeks(studentIndeks);
        upisGodine.setDatumUpisa(LocalDate.now());
        upisGodine.setPrenosEspb(request.getPrenosEspb());
        upisGodine.setGodinaKojaSeUpisuje(request.getGodinaKojaSeUpisuje());
        upisGodine.setSkolskaGodina(skolskaGodina);
        upisGodine.setNapomena(request.getNapomena());

		// TODO da li ovde dodati predmete koje slusa? predmete iz godine koju upisuje i predmete koje prenosi?

        return upisGodineRepo.save(upisGodine).getId();
    }

    public Long addObnovaGodine(ObnovaGodineRequest request) {
        StudentIndeks studentIndeks = studentIndeksService.findByStudentIdAndAktivan(request.getStudentId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        ObnovaGodine obnovaGodine = new ObnovaGodine();
        obnovaGodine.setStudentIndeks(studentIndeks);
        obnovaGodine.setDatumObnove(LocalDate.now());
        obnovaGodine.setGodinaKojuObnavlja(request.getGodinaKojuObnavlja());
        obnovaGodine.setSkolskaGodina(skolskaGodina);
        obnovaGodine.setNapomena(request.getNapomena());

        // TODO da li ovde dodati predmete koje slusa? predmete iz godine koju upisuje i predmete koje prenosi?

        return obnovaGodineRepo.save(obnovaGodine).getId();
    }
}

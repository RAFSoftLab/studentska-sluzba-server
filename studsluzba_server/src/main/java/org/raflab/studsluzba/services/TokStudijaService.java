package org.raflab.studsluzba.services;

import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.model.*;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Autowired
    PredmetService predmetService;

    public Long addUpis(UpisGodineRequest request) {
        StudentIndeks studentIndeks = studentIndeksService.findByStudentIdAndAktivan(request.getStudentId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        List<Integer> upisaneGodine = upisGodineRepo.getUpisaneGodineForStudentIndeks(studentIndeks.getId());

        UpisGodine upisGodine = new UpisGodine();
        upisGodine.setStudentIndeks(studentIndeks);
        upisGodine.setDatumUpisa(LocalDate.now());

        if (upisaneGodine.isEmpty()) {  // upis u prvu godinu
            upisGodine.setPrenosEspb(0);
            upisGodine.setGodinaKojaSeUpisuje(1);
        } else {
            upisGodine.setPrenosEspb(upisaneGodine.get(0)*60 - studentIndeks.getOstvarenoEspb());
            upisGodine.setGodinaKojaSeUpisuje(upisaneGodine.get(0) + 1);
        }

        upisGodine.setSkolskaGodina(skolskaGodina);
        upisGodine.setNapomena(request.getNapomena());

        List<Predmet> predmetiForUpisGodine = predmetService.getPredmetiForUpisGodine(1, studentIndeks.getStudijskiProgram());
        List<Predmet> nepolozeniPredmeti = predmetService.getNepolozeniPredmeti(request.getStudentId());

        upisGodine.setPredmeti(Stream.concat(predmetiForUpisGodine.stream(), nepolozeniPredmeti.stream()).collect(Collectors.toList()));

        //TODO - napuniti tabelu slusa predmet
        // TODO da li ovde dodati predmete koje slusa? predmete iz godine koju upisuje i predmete koje prenosi?

        return upisGodineRepo.save(upisGodine).getId();
    }

    public Long addObnovaGodine(ObnovaGodineRequest request) {
        StudentIndeks studentIndeks = studentIndeksService.findByStudentIdAndAktivan(request.getStudentId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        List<Integer> upisaneGodine = upisGodineRepo.getUpisaneGodineForStudentIndeks(studentIndeks.getId());

        ObnovaGodine obnovaGodine = new ObnovaGodine();
        obnovaGodine.setStudentIndeks(studentIndeks);
        obnovaGodine.setDatumObnove(LocalDate.now());
        obnovaGodine.setGodinaKojuObnavlja(upisaneGodine.get(0));
        obnovaGodine.setSkolskaGodina(skolskaGodina);
        obnovaGodine.setNapomena(request.getNapomena());

        List<Predmet> nepolozeniPredmeti = predmetService.getNepolozeniPredmeti(request.getStudentId());

        obnovaGodine.setUpisujePredmete(nepolozeniPredmeti);

        return obnovaGodineRepo.save(obnovaGodine).getId();
    }
}

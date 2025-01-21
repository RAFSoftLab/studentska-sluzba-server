package org.raflab.studsluzba.services;

import org.raflab.studsluzba.controllers.request.ObnovaGodineInitRequest;
import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineInitRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.controllers.response.ObnovaGodineInitResponse;
import org.raflab.studsluzba.controllers.response.ObnovaGodineResponse;
import org.raflab.studsluzba.controllers.response.UpisGodineInitResponse;
import org.raflab.studsluzba.controllers.response.UpisGodineResponse;
import org.raflab.studsluzba.model.*;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.raflab.studsluzba.utils.Converters;
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
    @Autowired
    UpisGodinePredmetiService upisGodinePredmetiService;
    @Autowired
    ObnovaGodineUpisujePredmeteService obnovaGodineUpisujePredmeteService;

    public Long addUpis(UpisGodineRequest request) {
        UpisGodine upisGodine = new UpisGodine();
        upisGodine.setStudentIndeks(request.getStudentIndeks());
        upisGodine.setDatumUpisa(request.getDatumUpisa());
        upisGodine.setPrenosEspb(request.getPrenosiEspb());
        upisGodine.setGodinaKojaSeUpisuje(request.getGodinaKojaSeUpisuje());
        upisGodine.setSkolskaGodina(request.getSkolskaGodina());
        upisGodine.setNapomena(request.getNapomena());
        upisGodine.setPredmeti(request.getPredmeti());

        Long id = upisGodineRepo.save(upisGodine).getId();

        upisGodinePredmetiService.savePredmeti(id, request.getPredmeti());
        return id;
    }

    public Long addObnovaGodine(ObnovaGodineRequest request) {
        ObnovaGodine obnovaGodine = new ObnovaGodine();
        obnovaGodine.setStudentIndeks(request.getStudentIndeks());
        obnovaGodine.setDatumObnove(request.getDatumObnove());
        obnovaGodine.setGodinaKojuObnavlja(request.getGodinaKojuObnavlja());
        obnovaGodine.setSkolskaGodina(request.getSkolskaGodina());
        obnovaGodine.setNapomena(request.getNapomena());
        obnovaGodine.setUpisujePredmete(request.getUpisujePredmete());

        Long id = obnovaGodineRepo.save(obnovaGodine).getId();

        obnovaGodineUpisujePredmeteService.savePredmeti(id, request.getUpisujePredmete());

        return id;
    }

    public UpisGodineInitResponse initUpis(UpisGodineInitRequest request) {
        StudentIndeks studentIndeks = studentIndeksService.findByStudentIdAndAktivan(request.getStudentId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        List<Integer> upisaneGodine = upisGodineRepo.getUpisaneGodineForStudentIndeks(studentIndeks.getId());

        UpisGodineInitResponse upisGodineInitResponse = new UpisGodineInitResponse();
        upisGodineInitResponse.setStudentIndeks(studentIndeks);
        upisGodineInitResponse.setDatumUpisa(LocalDate.now());

        if (upisaneGodine.isEmpty()) {  // upis u prvu godinu
            upisGodineInitResponse.setPrenosiEspb(0);
            upisGodineInitResponse.setGodinaKojaSeUpisuje(1);
        } else {
            upisGodineInitResponse.setPrenosiEspb(
                    upisaneGodine.get(0)*60 - ((studentIndeks.getOstvarenoEspb() == null) ? 0 : studentIndeks.getOstvarenoEspb()));
            upisGodineInitResponse.setGodinaKojaSeUpisuje(upisaneGodine.get(0) + 1);
        }

        upisGodineInitResponse.setSkolskaGodina(skolskaGodina);
        upisGodineInitResponse.setNapomena(request.getNapomena());

        List<Predmet> predmetiForUpisGodine = predmetService.getPredmetiForUpisGodine(
                upisGodineInitResponse.getGodinaKojaSeUpisuje(), studentIndeks.getStudijskiProgram());
        List<Predmet> nepolozeniPredmeti = predmetService.getNepolozeniPredmeti(studentIndeks.getId());

        upisGodineInitResponse.setPredmeti(Stream.concat(predmetiForUpisGodine.stream(), nepolozeniPredmeti.stream())
                .collect(Collectors.toList()));

        return upisGodineInitResponse;
    }

    public ObnovaGodineInitResponse initObnovaGodine(ObnovaGodineInitRequest request) {
        StudentIndeks studentIndeks = studentIndeksService.findByStudentIdAndAktivan(request.getStudentId());
        SkolskaGodina skolskaGodina = skolskaGodinaService.getNewSkolskaGodina();

        List<Integer> upisaneGodine = upisGodineRepo.getUpisaneGodineForStudentIndeks(studentIndeks.getId());

        if (upisaneGodine.isEmpty()) return null;

        ObnovaGodineInitResponse obnovaGodineInitResponse = new ObnovaGodineInitResponse();
        obnovaGodineInitResponse.setStudentIndeks(studentIndeks);
        obnovaGodineInitResponse.setDatumObnove(LocalDate.now());
        obnovaGodineInitResponse.setGodinaKojuObnavlja(upisaneGodine.get(0));
        obnovaGodineInitResponse.setSkolskaGodina(skolskaGodina);
        obnovaGodineInitResponse.setNapomena(request.getNapomena());

        List<Predmet> nepolozeniPredmeti = predmetService.getNepolozeniPredmeti(studentIndeks.getId());

        obnovaGodineInitResponse.setUpisujePredmete(nepolozeniPredmeti);

        return obnovaGodineInitResponse;
    }

    public List<UpisGodineResponse> getUpisGodineByStudentIndeks(Long idStudentIndeks) {
        List<UpisGodine> upisiForIndeks = upisGodineRepo.getUpisiForIndeks(idStudentIndeks);

        return upisiForIndeks.stream().map(Converters::toUpisGodineResponse).collect(Collectors.toList());
    }

    public List<ObnovaGodineResponse> getObnovaGodineByStudentIndeks(Long idStudentIndeks) {
        List<ObnovaGodine> obnoveForIndeks = obnovaGodineRepo.getObnoveForIndeks(idStudentIndeks);

        return obnoveForIndeks.stream().map(Converters::toObnovaGodineResponse).collect(Collectors.toList());
    }
}

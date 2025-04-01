package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.controllers.request.IspitniRokRequest;
import org.raflab.studsluzba.controllers.response.IspitniRokResponse;
import org.raflab.studsluzba.model.IspitniRok;
import org.raflab.studsluzba.services.IspitniRokService;
import org.raflab.studsluzba.utils.Converters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/ispitni-rok")
public class IspitniRokController {

    @Autowired
    IspitniRokService ispitniRokService;

    @GetMapping(path = "/all")
    public List<IspitniRokResponse> getAllIspitniRok() {
        return Converters.toIspitniRokResponseList(ispitniRokService.findAll());
    }

    @PostMapping(path = "/add")
    public Long addIspitniRok(@RequestBody IspitniRokRequest ispitniRok) {
        IspitniRok savedIspitniRok = ispitniRokService.save(Converters.toIspitniRok(ispitniRok));
        return savedIspitniRok.getId();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteIspitniRok(@PathVariable Long id) {
        ispitniRokService.deleteById(id);   //TODO - ne radi
    }

    @GetMapping(path = "/aktivna-godina/all")
    public List<IspitniRokResponse> getAllIspitniRokForAktivnaSkolskaGodina() {
        return Converters.toIspitniRokResponseList(ispitniRokService.getForAktivnaSkolsaGodina());
    }

    @GetMapping(path = "/aktivni")
    public IspitniRokResponse getAktivniIspitniRokovi() {
        return Converters.toIspitniRokResponse(ispitniRokService.getAktivniIspitniRokovi());
    }
}

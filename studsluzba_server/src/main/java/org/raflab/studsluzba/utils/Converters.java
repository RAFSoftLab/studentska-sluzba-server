package org.raflab.studsluzba.utils;

import org.raflab.studsluzba.controllers.request.IspitniRokRequest;
import org.raflab.studsluzba.controllers.request.NastavnikRequest;
import org.raflab.studsluzba.controllers.response.IspitniRokResponse;
import org.raflab.studsluzba.controllers.response.NastavnikResponse;
import org.raflab.studsluzba.model.IspitniRok;
import org.raflab.studsluzba.model.Nastavnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Converters {

    public static Nastavnik toNastavnik(NastavnikRequest nastavnikRequest) {
        Nastavnik nastavnik = new Nastavnik();
        nastavnik.setIme(nastavnikRequest.getIme());
        nastavnik.setPrezime(nastavnikRequest.getPrezime());
        nastavnik.setSrednjeIme(nastavnikRequest.getSrednjeIme());
        nastavnik.setEmail(nastavnikRequest.getEmail());
        nastavnik.setBrojTelefona(nastavnikRequest.getBrojTelefona());
        nastavnik.setAdresa(nastavnikRequest.getAdresa());
        nastavnik.setZvanja(nastavnikRequest.getZvanja());
        nastavnik.setDatumRodjenja(nastavnikRequest.getDatumRodjenja());
        nastavnik.setPol(nastavnikRequest.getPol());
        nastavnik.setJmbg(nastavnikRequest.getJmbg());
        return nastavnik;
    }

    public static NastavnikResponse toNastavnikResponse(Nastavnik nastavnik) {
        NastavnikResponse response = new NastavnikResponse();
        response.setId(nastavnik.getId());
        response.setIme(nastavnik.getIme());
        response.setPrezime(nastavnik.getPrezime());
        response.setSrednjeIme(nastavnik.getSrednjeIme());
        response.setEmail(nastavnik.getEmail());
        response.setBrojTelefona(nastavnik.getBrojTelefona());
        response.setAdresa(nastavnik.getAdresa());
        response.setZvanja(nastavnik.getZvanja());
        response.setDatumRodjenja(nastavnik.getDatumRodjenja());
        response.setPol(nastavnik.getPol());
        response.setJmbg(nastavnik.getJmbg());
        return response;
    }

    public static List<NastavnikResponse> toNastavnikResponseList(Iterable<Nastavnik> nastavnikIterable) {
        List<NastavnikResponse> nastavnikResponses = new ArrayList<>();

        nastavnikIterable.forEach((nastavnik) -> {
            nastavnikResponses.add(toNastavnikResponse(nastavnik));
        });
        return nastavnikResponses;
    }

    public static List<IspitniRokResponse> toIspitniRokResponseList(Iterable<IspitniRok> ispitniRokIterable) {
        List<IspitniRokResponse> ispitniRokResponses = new ArrayList<>();

        ispitniRokIterable.forEach((ispitniRok) -> {
            ispitniRokResponses.add(toIspitniRokResponse(ispitniRok));
        });
        return ispitniRokResponses;
    }

    public static IspitniRok toIspitniRok(IspitniRokRequest request) {
        IspitniRok ispitniRok = new IspitniRok();
        ispitniRok.setNaziv(request.getNaziv());
        ispitniRok.setDatumPocetka(request.getDatumPocetka());
        ispitniRok.setDatumZavrsetka(request.getDatumZavrsetka());
        ispitniRok.setDatumPocetkaPrijave(request.getDatumPocetkaPrijave());
        ispitniRok.setDatumZavrsetkaPrijave(request.getDatumZavrsetkaPrijave());
        ispitniRok.setSkolskaGodina(request.getSkolskaGodina());

        return ispitniRok;
    }

    public static IspitniRokResponse toIspitniRokResponse(IspitniRok ispitniRok) {
        IspitniRokResponse ispitniRokResponse = new IspitniRokResponse();
        ispitniRokResponse.setId(ispitniRok.getId());
        ispitniRokResponse.setNaziv(ispitniRok.getNaziv());
        ispitniRokResponse.setDatumPocetka(ispitniRok.getDatumPocetka());
        ispitniRokResponse.setDatumZavrsetka(ispitniRok.getDatumZavrsetka());
        ispitniRokResponse.setDatumPocetkaPrijave(ispitniRok.getDatumPocetkaPrijave());
        ispitniRokResponse.setDatumZavrsetkaPrijave(ispitniRok.getDatumZavrsetkaPrijave());
        ispitniRokResponse.setSkolskaGodina(ispitniRok.getSkolskaGodina());

        return ispitniRokResponse;
    }
}

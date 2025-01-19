package org.raflab.studsluzba.utils;

import org.raflab.studsluzba.controllers.request.*;
import org.raflab.studsluzba.controllers.response.IspitniRokResponse;
import org.raflab.studsluzba.controllers.response.NastavnikResponse;
import org.raflab.studsluzba.controllers.response.ObnovaGodineResponse;
import org.raflab.studsluzba.controllers.response.UpisGodineResponse;
import org.raflab.studsluzba.model.*;

import java.util.ArrayList;
import java.util.List;

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

    public static StudentPodaci toStudentPodaci(StudentPodaciRequest request) {
        StudentPodaci studentPodaci = new StudentPodaci();
        studentPodaci.setIme(request.getIme());
        studentPodaci.setPrezime(request.getPrezime());
        studentPodaci.setSrednjeIme(request.getSrednjeIme());
        studentPodaci.setJmbg(request.getJmbg());
        studentPodaci.setDatumRodjenja(request.getDatumRodjenja());
        studentPodaci.setMestoRodjenja(request.getMestoRodjenja());
        studentPodaci.setMestoPrebivalista(request.getMestoPrebivalista());
        studentPodaci.setDrzavaRodjenja(request.getDrzavaRodjenja());
        studentPodaci.setDrzavljanstvo(request.getDrzavljanstvo());
        studentPodaci.setNacionalnost(request.getNacionalnost());
        studentPodaci.setPol(request.getPol());
        studentPodaci.setAdresa(request.getAdresa());
        studentPodaci.setBrojTelefonaMobilni(request.getBrojTelefonaMobilni());
        studentPodaci.setBrojTelefonaFiksni(request.getBrojTelefonaFiksni());
        studentPodaci.setEmail(request.getEmail());
        studentPodaci.setBrojLicneKarte(request.getBrojLicneKarte());
        studentPodaci.setLicnuKartuIzdao(request.getLicnuKartuIzdao());
        studentPodaci.setMestoStanovanja(request.getMestoStanovanja());
        studentPodaci.setAdresaStanovanja(request.getAdresaStanovanja());
        studentPodaci.setPrviUpis(request.getPrviUpis());
        return studentPodaci;
    }

    public static StudentIndeks toStudentIndeks(StudentIndeksRequest studentIndeksRequest) {
        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setGodina(studentIndeksRequest.getGodina());
        studentIndeks.setStudProgramOznaka(studentIndeksRequest.getStudProgramOznaka());
        studentIndeks.setNacinFinansiranja(studentIndeksRequest.getNacinFinansiranja());
        studentIndeks.setAktivan(studentIndeksRequest.isAktivan());
        studentIndeks.setVaziOd(studentIndeksRequest.getVaziOd());
        return studentIndeks;
    }

    public static ObnovaGodineResponse toObnovaGodineResponse(ObnovaGodine obnovaGodine) {
        ObnovaGodineResponse response = new ObnovaGodineResponse();
        response.setId(obnovaGodine.getId());
        response.setDatumObnove(obnovaGodine.getDatumObnove());
        response.setUpisujePredmete(obnovaGodine.getUpisujePredmete());
        response.setNapomena(obnovaGodine.getNapomena());
        response.setSkolskaGodina(obnovaGodine.getSkolskaGodina());
        return response;
    }

    public static UpisGodineResponse toUpisGodineResponse(UpisGodine upisGodine) {
        UpisGodineResponse response = new UpisGodineResponse();
        response.setId(upisGodine.getId());
        response.setDatumUpisa(upisGodine.getDatumUpisa());
        response.setPrenosiEspb(upisGodine.getPrenosEspb());
        response.setGodinaKojaSeUpisuje(upisGodine.getGodinaKojaSeUpisuje());
        response.setPredmeti(upisGodine.getPredmeti());
        response.setSkolskaGodina(upisGodine.getSkolskaGodina());
        response.setNapomena(upisGodine.getNapomena());
        return response;
    }
}

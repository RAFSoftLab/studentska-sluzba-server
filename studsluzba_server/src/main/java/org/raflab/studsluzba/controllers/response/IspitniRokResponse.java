package org.raflab.studsluzba.controllers.response;

import lombok.Data;
import org.raflab.studsluzba.model.SkolskaGodina;

import java.time.LocalDate;

@Data
public class IspitniRokResponse {

    private Long id;
    private String naziv;  // januarski, februarski
    private LocalDate datumPocetka;
    private LocalDate datumZavrsetka;
    private LocalDate datumPocetkaPrijave;   // ako se prebacimo na prijavu svih ispita u odredjenom periodu
    private LocalDate datumZavrsetkaPrijave;
    private SkolskaGodina skolskaGodina;
}

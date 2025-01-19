package org.raflab.studsluzba.controllers.response;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.StudentIndeks;

import java.time.LocalDate;
import java.util.List;

@Data
public class UpisGodineInitResponse {

    private StudentIndeks studentIndeks;
    private LocalDate datumUpisa;
    private Integer prenosiEspb; // podrazumevano 0
    private Integer godinaKojaSeUpisuje;
    private List<Predmet> predmeti;
    private SkolskaGodina skolskaGodina;

    private String napomena;
}

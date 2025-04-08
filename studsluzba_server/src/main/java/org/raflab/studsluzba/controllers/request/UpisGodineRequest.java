package org.raflab.studsluzba.controllers.request;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.StudentIndeks;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class UpisGodineRequest {

    @NotNull
    private StudentIndeks studentIndeks;
    @NotNull
    private SkolskaGodina skolskaGodina;
    @NotNull
    private Integer godinaKojaSeUpisuje;
    private List<Predmet> predmeti;
    @NotNull
    private LocalDate datumUpisa;
    private Integer prenosEspb;
    private String napomena;
}

package org.raflab.studsluzba.controllers.request;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.StudentIndeks;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class ObnovaGodineRequest {

    @NotNull
    private StudentIndeks studentIndeks;
    @NotNull
    private SkolskaGodina skolskaGodina;
    @NotNull
    private Integer godinaKojuObnavlja;
    @NotNull
    private List<Predmet> nepolozeniPredmeti;
    @NotNull
    private LocalDate datumObnove;
    private String napomena;
}

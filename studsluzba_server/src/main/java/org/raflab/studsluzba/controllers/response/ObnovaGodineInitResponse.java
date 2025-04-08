package org.raflab.studsluzba.controllers.response;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.StudentIndeks;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Data
public class ObnovaGodineInitResponse {

    private StudentIndeks studentIndeks;

    private Integer godinaKojuObnavlja;

    @ManyToMany
    private List<Predmet> upisujePredmete;

    private LocalDate datumObnove;

    private String napomena;

    @ManyToOne
    private SkolskaGodina skolskaGodina;
}

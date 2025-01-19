package org.raflab.studsluzba.controllers.response;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;

import java.time.LocalDate;
import java.util.List;

@Data
public class ObnovaGodineResponse {

    private Long id;
    private Integer godinaKojuObnavlja;
    private List<Predmet> upisujePredmete;
    private LocalDate datumObnove;
    private String napomena;
    private SkolskaGodina skolskaGodina;
}
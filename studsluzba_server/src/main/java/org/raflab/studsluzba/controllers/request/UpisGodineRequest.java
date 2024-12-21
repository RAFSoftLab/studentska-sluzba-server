package org.raflab.studsluzba.controllers.request;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.model.StudentIndeks;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
public class UpisGodineRequest {

    private Long studentId;
    private Integer prenosEspb; // podrazumevano 0
    private Integer godinaKojaSeUpisuje;
    @ManyToMany
    private List<Predmet> predmeti;

    private String napomena;
}

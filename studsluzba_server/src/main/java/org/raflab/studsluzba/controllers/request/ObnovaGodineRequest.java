package org.raflab.studsluzba.controllers.request;

import lombok.Data;
import org.raflab.studsluzba.model.Predmet;

import javax.persistence.*;
import java.util.List;

@Data
public class ObnovaGodineRequest {

    private Long studentId;

    private Integer godinaKojuObnavlja;

    @ManyToMany
    private List<Predmet> upisujePredmete;

    private String napomena;
}

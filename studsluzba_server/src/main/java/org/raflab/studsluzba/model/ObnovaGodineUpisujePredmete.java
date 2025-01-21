package org.raflab.studsluzba.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "obnova_godine_upisuje_predmete")
public class ObnovaGodineUpisujePredmete {

    @EmbeddedId
    private ObnovaGodineUpisujePredmeteId id;
}

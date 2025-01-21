package org.raflab.studsluzba.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class ObnovaGodineUpisujePredmeteId implements Serializable {

    @Column(name = "obnova_godine_id", nullable = false)
    private Long obnovaGodineId;
    @Column(name = "upisuje_predmete_id", nullable = false)
    private Long upisujePredmetiId;
}

package org.raflab.studsluzba.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class UpisGodinePredmetiId implements Serializable {

    @Column(name = "upis_godine_id", nullable = false)
    private Long upisGodineId;
    @Column(name = "predmeti_id", nullable = false)
    private Long predmetiId;
}


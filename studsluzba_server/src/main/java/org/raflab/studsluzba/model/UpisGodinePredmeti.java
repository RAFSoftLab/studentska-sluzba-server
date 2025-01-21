package org.raflab.studsluzba.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "upis_godine_predmeti")
public class UpisGodinePredmeti {
    @EmbeddedId
    private UpisGodinePredmetiId id;
}

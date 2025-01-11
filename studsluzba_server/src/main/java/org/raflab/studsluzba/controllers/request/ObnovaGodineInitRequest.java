package org.raflab.studsluzba.controllers.request;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class ObnovaGodineInitRequest {

    @NotNull
    private Long studentId;

    private String napomena;
}

package org.raflab.studsluzba.controllers.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentIndeksRequest {

    private int godina; //ako npr student mastera upisuje neki program, a godina presla u sledecu???
    private String studProgramOznaka;
    private String nacinFinansiranja;
    private boolean aktivan;
    private LocalDate vaziOd;   //TODO - da li da setujm trenutni datum
    private Long studentId;
}
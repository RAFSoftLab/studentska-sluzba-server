package org.raflab.studsluzba.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.raflab.studsluzba.controllers.request.ObnovaGodineInitRequest;
import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineInitRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.controllers.response.ObnovaGodineInitResponse;
import org.raflab.studsluzba.controllers.response.ObnovaGodineResponse;
import org.raflab.studsluzba.controllers.response.UpisGodineInitResponse;
import org.raflab.studsluzba.controllers.response.UpisGodineResponse;
import org.raflab.studsluzba.model.*;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TokStudijaServiceTest {

    @Mock
    private UpisGodineRepository upisGodineRepo;

    @Mock
    private ObnovaGodineRepository obnovaGodineRepo;

    @Mock
    private UplataRepository uplataRepository;

    @Mock
    private StudentIndeksService studentIndeksService;

    @Mock
    private SkolskaGodinaService skolskaGodinaService;

    @Mock
    private PredmetService predmetService;

    @InjectMocks
    private TokStudijaService tokStudijaService;

    @Test
    void testAddUpis() {
        // Arrange
        UpisGodineRequest request = new UpisGodineRequest();
        request.setStudentIndeks(new StudentIndeks());
        request.setDatumUpisa(LocalDate.now());
        request.setPrenosiEspb(10);
        request.setGodinaKojaSeUpisuje(2);
        request.setSkolskaGodina(new SkolskaGodina());
        request.setNapomena("Test upis");
        request.setPredmeti(Collections.singletonList(new Predmet()));

        UpisGodine savedUpisGodine = new UpisGodine();
        savedUpisGodine.setId(100L);

        when(upisGodineRepo.save(any(UpisGodine.class))).thenReturn(savedUpisGodine);

        // Act
        Long result = tokStudijaService.addUpis(request);

        // Assert
        assertEquals(100L, result);
        verify(upisGodineRepo, times(1)).save(any(UpisGodine.class));
    }

    @Test
    void testAddObnovaGodine() {
        // Arrange
        ObnovaGodineRequest request = new ObnovaGodineRequest();
        request.setStudentIndeks(new StudentIndeks());
        request.setDatumObnove(LocalDate.now());
        request.setGodinaKojuObnavlja(2);
        request.setSkolskaGodina(new SkolskaGodina());
        request.setNapomena("Test obnova");
        request.setUpisujePredmete(Collections.singletonList(new Predmet()));

        ObnovaGodine savedObnovaGodine = new ObnovaGodine();
        savedObnovaGodine.setId(200L);

        when(obnovaGodineRepo.save(any(ObnovaGodine.class))).thenReturn(savedObnovaGodine);

        // Act
        Long result = tokStudijaService.addObnovaGodine(request);

        // Assert
        assertEquals(200L, result);
        verify(obnovaGodineRepo, times(1)).save(any(ObnovaGodine.class));
    }

    @Test
    void testInitUpis() {
        UpisGodineInitRequest request = new UpisGodineInitRequest();
        request.setStudentId(1L);
        request.setNapomena("Test inicijalizacija upisa");

        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(1L);
        studentIndeks.setOstvarenoEspb(30);
        studentIndeks.setStudijskiProgram(new StudijskiProgram());

        SkolskaGodina skolskaGodina = new SkolskaGodina();

        when(studentIndeksService.findByStudentIdAndAktivan(1L)).thenReturn(studentIndeks);
        when(skolskaGodinaService.getNewSkolskaGodina()).thenReturn(skolskaGodina);
        when(upisGodineRepo.getUpisaneGodineForStudentIndeks(1L)).thenReturn(Collections.singletonList(1));

        List<Predmet> predmetiForUpisGodine = Arrays.asList(new Predmet(), new Predmet());
        List<Predmet> nepolozeniPredmeti = Collections.singletonList(new Predmet());

        when(predmetService.getPredmetiForUpisGodine(2, studentIndeks.getStudijskiProgram())).thenReturn(predmetiForUpisGodine);
        when(predmetService.getNepolozeniPredmeti(1L)).thenReturn(nepolozeniPredmeti);

        // Act
        UpisGodineInitResponse result = tokStudijaService.initUpis(request);

        assertEquals(2, result.getGodinaKojaSeUpisuje());
        assertEquals("Test inicijalizacija upisa", result.getNapomena());
        assertEquals(3, result.getPredmeti().size());
        assertEquals(30, result.getPrenosiEspb());
    }

    @Test
    void testInitObnovaGodine() {
        // Arrange
        ObnovaGodineInitRequest request = new ObnovaGodineInitRequest();
        request.setStudentId(1L);
        request.setNapomena("Test inicijalizacija obnove");

        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(1L);

        SkolskaGodina skolskaGodina = new SkolskaGodina();

        when(studentIndeksService.findByStudentIdAndAktivan(1L)).thenReturn(studentIndeks);
        when(skolskaGodinaService.getNewSkolskaGodina()).thenReturn(skolskaGodina);
        when(upisGodineRepo.getUpisaneGodineForStudentIndeks(1L)).thenReturn(Collections.singletonList(2));

        List<Predmet> nepolozeniPredmeti = Collections.singletonList(new Predmet());
        when(predmetService.getNepolozeniPredmeti(1L)).thenReturn(nepolozeniPredmeti);

        // Act
        ObnovaGodineInitResponse result = tokStudijaService.initObnovaGodine(request);

        // Assert
        assertEquals(2, result.getGodinaKojuObnavlja());
        assertEquals("Test inicijalizacija obnove", result.getNapomena());
        assertEquals(1, result.getUpisujePredmete().size());
    }

    @Test
    void testGetUpisGodineByStudentIndeks() {
        // Arrange
        Long studentIndeksId = 1L;

        UpisGodine upis1 = new UpisGodine();
        upis1.setId(101L);
        UpisGodine upis2 = new UpisGodine();
        upis2.setId(102L);

        when(upisGodineRepo.getUpisiForIndeks(studentIndeksId))
                .thenReturn(Arrays.asList(upis1, upis2));

        // Act
        List<UpisGodineResponse> result = tokStudijaService.getUpisGodineByStudentIndeks(studentIndeksId);

        // Assert
        assertEquals(2, result.size());
        verify(upisGodineRepo, times(1)).getUpisiForIndeks(studentIndeksId);
    }

    @Test
    void testGetObnovaGodineByStudentIndeks() {
        // Arrange
        Long studentIndeksId = 1L;

        ObnovaGodine obnova1 = new ObnovaGodine();
        obnova1.setId(201L);
        ObnovaGodine obnova2 = new ObnovaGodine();
        obnova2.setId(202L);

        when(obnovaGodineRepo.getObnoveForIndeks(studentIndeksId))
                .thenReturn(Arrays.asList(obnova1, obnova2));

        // Act
        List<ObnovaGodineResponse> result = tokStudijaService.getObnovaGodineByStudentIndeks(studentIndeksId);

        // Assert
        assertEquals(2, result.size());
        verify(obnovaGodineRepo, times(1)).getObnoveForIndeks(studentIndeksId);
    }

    @Test
    void testInitUpisWhenNoUpisaneGodine() {
        // Arrange
        UpisGodineInitRequest request = new UpisGodineInitRequest();
        request.setStudentId(1L);
        request.setNapomena("Test inicijalizacija upisa");

        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(1L);
        studentIndeks.setOstvarenoEspb(0);
        studentIndeks.setStudijskiProgram(new StudijskiProgram());

        SkolskaGodina skolskaGodina = new SkolskaGodina();

        when(studentIndeksService.findByStudentIdAndAktivan(1L)).thenReturn(studentIndeks);
        when(skolskaGodinaService.getNewSkolskaGodina()).thenReturn(skolskaGodina);
        when(upisGodineRepo.getUpisaneGodineForStudentIndeks(1L)).thenReturn(Collections.emptyList());

        List<Predmet> predmetiForUpisGodine = Collections.singletonList(new Predmet());

        when(predmetService.getPredmetiForUpisGodine(1, studentIndeks.getStudijskiProgram()))
                .thenReturn(predmetiForUpisGodine);

        // Act
        UpisGodineInitResponse result = tokStudijaService.initUpis(request);

        // Assert
        assertEquals(1, result.getGodinaKojaSeUpisuje());
        assertEquals(0, result.getPrenosiEspb());
        assertEquals("Test inicijalizacija upisa", result.getNapomena());
        assertEquals(1, result.getPredmeti().size());
    }

    @Test
    void testInitObnovaGodineWhenNoUpisaneGodine() {
        // Arrange
        ObnovaGodineInitRequest request = new ObnovaGodineInitRequest();
        request.setStudentId(1L);
        request.setNapomena("Test inicijalizacija obnove");

        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(1L);

        when(studentIndeksService.findByStudentIdAndAktivan(1L)).thenReturn(studentIndeks);
        when(upisGodineRepo.getUpisaneGodineForStudentIndeks(1L)).thenReturn(Collections.emptyList());

        // Act
        ObnovaGodineInitResponse result = tokStudijaService.initObnovaGodine(request);

        // Assert
        assertEquals(null, result);
        verify(upisGodineRepo, times(1)).getUpisaneGodineForStudentIndeks(1L);
    }
}

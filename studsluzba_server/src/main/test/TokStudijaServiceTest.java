import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.model.*;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.raflab.studsluzba.services.PredmetService;
import org.raflab.studsluzba.services.SkolskaGodinaService;
import org.raflab.studsluzba.services.StudentIndeksService;
import org.raflab.studsluzba.services.TokStudijaService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddUpis() {
        UpisGodineRequest request = new UpisGodineRequest();
        request.setStudentId(1L);
        request.setNapomena("Napomena za upis");

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

        when(predmetService.getPredmetiForUpisGodine(1, studentIndeks.getStudijskiProgram())).thenReturn(predmetiForUpisGodine);
        when(predmetService.getNepolozeniPredmeti(1L)).thenReturn(nepolozeniPredmeti);

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
        ObnovaGodineRequest request = new ObnovaGodineRequest();
        request.setStudentId(1L);
        request.setNapomena("Napomena za obnovu");

        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(1L);

        SkolskaGodina skolskaGodina = new SkolskaGodina();

        when(studentIndeksService.findByStudentIdAndAktivan(1L)).thenReturn(studentIndeks);
        when(skolskaGodinaService.getNewSkolskaGodina()).thenReturn(skolskaGodina);
        when(upisGodineRepo.getUpisaneGodineForStudentIndeks(1L)).thenReturn(Collections.singletonList(2));

        List<Predmet> nepolozeniPredmeti = Collections.singletonList(new Predmet());
        when(predmetService.getNepolozeniPredmeti(1L)).thenReturn(nepolozeniPredmeti);

        ObnovaGodine savedObnovaGodine = new ObnovaGodine();
        savedObnovaGodine.setId(200L);

        when(obnovaGodineRepo.save(any(ObnovaGodine.class))).thenReturn(savedObnovaGodine);

        // Act
        Long result = tokStudijaService.addObnovaGodine(request);

        // Assert
        assertEquals(200L, result);
        verify(obnovaGodineRepo, times(1)).save(any(ObnovaGodine.class));
    }
}

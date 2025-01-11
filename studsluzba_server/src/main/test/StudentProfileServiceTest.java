import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.raflab.studsluzba.model.*;
import org.raflab.studsluzba.model.dtos.IspitPrijavaDTO;
import org.raflab.studsluzba.model.dtos.StudentProfileDTO;
import org.raflab.studsluzba.model.dtos.StudentWebProfileDTO;
import org.raflab.studsluzba.repositories.*;
import org.raflab.studsluzba.services.StudentProfileService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentProfileServiceTest {

    @Mock
    private PolozenPredmetRepository polozeniPredmetRepo;

    @Mock
    private StudentIndeksRepository studentIndeksRepo;

    @Mock
    private StudentPodaciRepository studentPodaciRepo;

    @Mock
    private UpisGodineRepository upisGodineRepo;

    @Mock
    private ObnovaGodineRepository obnovaGodineRepo;

    @Mock
    private UplataRepository uplataRepo;

    @Mock
    private PrijavaIspitaRepository prijavaIspitaRepo;

    @Mock
    private SlusaPredmetRepository slusaPredmetRepo;

    @Mock
    private PredmetRepository predmetRepo;

    @Mock
    private OsvojeniPoeniPredispitneRepository osvojeniPoeniPredispitneRepo;

    @Mock
    private IspitRepository ispitRepo;

    @InjectMocks
    private StudentProfileService studentProfileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetStudentProfile() {
        // Arrange
        Long indeksId = 1L;
        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(indeksId);

        when(studentIndeksRepo.findById(indeksId)).thenReturn(java.util.Optional.of(studentIndeks));
        when(polozeniPredmetRepo.getPolozeniPredmetForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(upisGodineRepo.getUpisiForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(obnovaGodineRepo.getObnoveForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(uplataRepo.getUplateForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(prijavaIspitaRepo.getPrijaveIspitaForIndeksAktivnaGodina(indeksId)).thenReturn(Collections.emptyList());
        when(slusaPredmetRepo.getSlusaPredmetForIndeksAktivnaGodina(indeksId)).thenReturn(Collections.emptyList());
        when(predmetRepo.getNepolozeniPredmeti(indeksId)).thenReturn(Collections.emptyList());

        // Act
        StudentProfileDTO result = studentProfileService.getStudentProfile(indeksId);

        // Assert
        assertNotNull(result);
        assertEquals(studentIndeks, result.getIndeks());
        assertTrue(result.getPolozeniPredmeti().isEmpty());
        assertTrue(result.getUpisiGodine().isEmpty());
        assertTrue(result.getObnoveGodine().isEmpty());
        assertTrue(result.getUplate().isEmpty());
        assertTrue(result.getPrijaveIspita().isEmpty());
        assertTrue(result.getSlusaPredmete().isEmpty());
        assertTrue(result.getNepolozeniPredmeti().isEmpty());
    }

    @Test
    void testGetStudentWebProfile() {
        // Arrange
        Long indeksId = 1L;
        Long studPodaciId = 2L;

        StudentIndeks studentIndeks = new StudentIndeks();
        studentIndeks.setId(indeksId);
        StudentPodaci student = new StudentPodaci();
        student.setId(studPodaciId);
        studentIndeks.setStudent(student);

        when(studentIndeksRepo.findById(indeksId)).thenReturn(java.util.Optional.of(studentIndeks));
        when(studentPodaciRepo.getAktivanIndeks(studPodaciId)).thenReturn(studentIndeks);
        when(polozeniPredmetRepo.getPolozeniPredmetForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(upisGodineRepo.getUpisiForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(obnovaGodineRepo.getObnoveForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(uplataRepo.getUplateForIndeks(indeksId)).thenReturn(Collections.emptyList());
        when(slusaPredmetRepo.getSlusaPredmetForIndeksAktivnaGodina(indeksId)).thenReturn(Collections.emptyList());
        when(osvojeniPoeniPredispitneRepo.getPoeniPredispitneZaIndeksAktivnu(indeksId)).thenReturn(Collections.emptyList());

        // Act
        StudentWebProfileDTO result = studentProfileService.getStudentWebProfile(indeksId);

        // Assert
        assertNotNull(result);
        assertEquals(studentIndeks, result.getAktivanIndeks());
        assertTrue(result.getPolozeniPredmeti().isEmpty());
        assertTrue(result.getUpisiGodine().isEmpty());
        assertTrue(result.getObnoveGodine().isEmpty());
        assertTrue(result.getUplate().isEmpty());
        assertTrue(result.getSlusaPredmete().isEmpty());
        assertTrue(result.getOsvojeniPoeniPredispitne().isEmpty());
    }

    @Test
    void testGetDustupniIspiti() {
        // Arrange
        Long idStudIndeks = 1L;
        Long idIspitniRok = 2L;

        Ispit ispit = new Ispit();
        ispit.setId(1L);
        ispit.setDatumOdrzavanja(LocalDate.of(2025,1,15));
        ispit.setVremeOdrzavanja(LocalTime.of(10,0));
        ispit.setMestoOdrzavanja("Sala 101");

        when(ispitRepo.getMoguciIspitiZaIndeksIRok(idStudIndeks, idIspitniRok)).thenReturn(Arrays.asList(ispit));
        when(prijavaIspitaRepo.getPrijavaForIndeksIspit(idStudIndeks, ispit.getId())).thenReturn(null);

        // Act
        List<IspitPrijavaDTO> result = studentProfileService.getDustupniIspiti(idStudIndeks, idIspitniRok);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        IspitPrijavaDTO dto = result.get(0);
        assertEquals(ispit.getId(), dto.getIdIspit());
        assertFalse(dto.isPrijavljen());
    }
}

package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.StudijskiProgram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PredmetRepository extends CrudRepository<Predmet, Long> {
	
	
	// za proslednjenog studenta vraca predmete koje je slusao, a nije polozio
	
	@Query("select distinct sp.drziPredmet.predmet from SlusaPredmet sp where sp.studentIndeks.id = :indeksId and "
			+ "sp.drziPredmet.predmet not in (select pp.predmet from PolozenPredmet pp where pp.studentIndeks.id = :indeksId)")
	List<Predmet> getNepolozeniPredmeti(Long indeksId);
	
	
	
	@Query("select p from Predmet p where p.studProgram.godinaAkreditacije = :godinaAkreditacije")
	List<Predmet> getPredmetForGodinaAkreditacije(Integer godinaAkreditacije);

	List<Predmet> getPredmetsByGodinaStudijaAndStudProgramAndObavezan(
			Integer godinaStudija, StudijskiProgram studProgram, boolean obavezan);

}

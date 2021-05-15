package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.DrziPredmet;
import org.raflab.studsluzba.model.OsvojeniPoeniPredispitne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OsvojeniPoeniPredispitneRepository extends CrudRepository<OsvojeniPoeniPredispitne, Long> {
	
	
	@Query("select op from OsvojeniPoeniPredispitne op where op.studentIndeks.id = :indeksId "
			+ "and op.predispitnaObaveza.drziPredmet.skolskaGodina.aktivna = 1")
	List<OsvojeniPoeniPredispitne> getPoeniPredispitneZaIndeksAktivnu(Long indeksId);
	
	@Query("select op from OsvojeniPoeniPredispitne op where op. predispitnaObaveza.id = :predispitneId")
	List<OsvojeniPoeniPredispitne> getOsvojeniPoeniZaPredispitne(Long predispitneId); 
	
	@Query("select op from OsvojeniPoeniPredispitne op where op. predispitnaObaveza.drziPredmet.skolskaGodina.aktivna=1 "
			+ "and predispitnaObaveza.drziPredmet.nastavnik.id = :nastavnikId and predispitnaObaveza.drziPredmet.predmet.id = :predmetId")
	List<OsvojeniPoeniPredispitne> getOsvojeniPoeniZaNastavnikPredmetAktivna(Long nastavnikId, Long predmetId); 
	
	
	@Query("select op from OsvojeniPoeniPredispitne op where op.predispitnaObaveza.id = :predispitnaId and op.studentIndeks.id = :studentIndeksId")
	OsvojeniPoeniPredispitne getOsvojeniPoeniStudentIndeksPrdispitna(Long studentIndeksId, Long predispitnaId);
	
	@Query("select sum(op.poeni) from OsvojeniPoeniPredispitne op where op.studentIndeks.id = :indeksId and "
			+ "op.predispitnaObaveza.drziPredmet = :dp")
	Float getSumaPredispitneForIndeksDrziPredmet(Long indeksId, DrziPredmet dp); 
	

}

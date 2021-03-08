package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.PrijavaIspita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PrijavaIspitaRepository extends CrudRepository<PrijavaIspita, Long> {
	
	
	@Query("select pi from PrijavaIspita pi where pi.studentIndeks.id = :indeksId and pi.ispit.ispitniRok.skolskaGodina.aktivna = 1")
	List<PrijavaIspita> getPrijaveIspitaForIndeksAktivnaGodina(Long indeksId);

}

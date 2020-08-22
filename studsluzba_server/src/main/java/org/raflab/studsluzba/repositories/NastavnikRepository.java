package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.Nastavnik;
import org.raflab.studsluzba.model.StudentPodaci;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//@Repository
//public interface NastavnikRepository extends CrudRepository<Nastavnik, Long> {
//
//	@Query("select n from Nastavnik n where "
//			+ "(:ime is null or lower(n.ime) like :ime and "
//			+ "(:prezime is null or lower(n.prezime) like :prezime")
//	List<Nastavnik> findNastavnik(String ime, String prezime);
//	
//}

@Repository
public interface NastavnikRepository extends CrudRepository<Nastavnik, Long> {	//	nasljedjene implementacije poput findById i findByAll
	
	@Query("select sp from Nastavnik sp where "
			+ "(:ime is null or lower(sp.ime) like :ime) and "
			+ "(:prezime is null or lower(sp.prezime) like :prezime)")			
	List<Nastavnik> findNastavnik(String ime, String prezime);
	
}


package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.StudentIndeks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIndeksRepository extends CrudRepository<StudentIndeks, Long> {
	
	
	@Query("select indeks from StudentIndeks indeks where indeks.studProgram like ?1 and indeks.godina = ?2 "
			+ "and indeks.broj = ?3 ")
    StudentIndeks findStudentIndeks(String studProgram, int godina, int broj);
	
	
	//TODO dodati da se gledaju samo aktivni indeksi
	@Query("select indeks from StudentIndeks indeks where "
			+ "(:ime is null or lower(indeks.student.ime) like :ime) and "
			+ "(:prezime is null or lower(indeks.student.prezime) like :prezime) and "
			+ "(:studProgram is null or lower(indeks.studProgram) like :studProgram) and"
			+ "(:godina is null or indeks.godina = :godina) and "
			+ "(:broj is null or indeks.broj = :broj)")
	List<StudentIndeks> findStudentIndeks(String ime, String prezime, String studProgram, Integer godina, Integer broj);
	
	
	
	
	}

package org.raflab.studsluzba.repositories;

import org.raflab.studsluzba.model.StudijskiProgram;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudijskiProgramRepository extends CrudRepository<StudijskiProgram, Long> {

}

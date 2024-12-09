package org.raflab.studsluzba.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.raflab.studsluzba.controllers.request.StudentIndeksRequest;
import org.raflab.studsluzba.controllers.request.StudentPodaciRequest;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.StudentPodaci;
import org.raflab.studsluzba.model.StudijskiProgram;
import org.raflab.studsluzba.model.dtos.StudentDTO;
import org.raflab.studsluzba.model.dtos.StudentProfileDTO;
import org.raflab.studsluzba.model.dtos.StudentWebProfileDTO;
import org.raflab.studsluzba.repositories.StudentIndeksRepository;
import org.raflab.studsluzba.repositories.StudentPodaciRepository;
import org.raflab.studsluzba.repositories.StudijskiProgramRepository;
import org.raflab.studsluzba.services.StudentIndeksService;
import org.raflab.studsluzba.services.StudentProfileService;
import org.raflab.studsluzba.utils.Converters;
import org.raflab.studsluzba.utils.EntityMappers;
import org.raflab.studsluzba.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/student")
public class StudentController {

	@Autowired
	StudentPodaciRepository studentPodaciRepository;
	
	@Autowired
	StudentIndeksRepository studentIndeksRepository;
	
	@Autowired
	StudentProfileService studentProfileService;

	@Autowired
	StudentIndeksService studentIndeksService;

	@Autowired
	StudijskiProgramRepository studijskiProgramRepository;

    @PostMapping(path="/add") 
   	public Long addNewStudentPodaci(@RequestBody StudentPodaciRequest studentPodaci) {
    	
   	    StudentPodaci sp = studentPodaciRepository.save(Converters.toStudentPodaci(studentPodaci));
   	    
   	    return sp.getId();
 	}

	@GetMapping(path="/all")
	public Iterable<StudentPodaci> getAllStudentPodaci() {
		return studentPodaciRepository.findAll();
	}

	@GetMapping(path="/podaci/{id}")
	public StudentPodaci getStudentPodaci(@PathVariable Long id){
		Optional<StudentPodaci> rez = studentPodaciRepository.findById(id);
		if(rez.isEmpty()) return null;
		return rez.get();
	}
    
    @PostMapping(path="/saveindeks") 
   	public Long saveIndeks(@RequestBody StudentIndeksRequest request) {
		StudentIndeks studentIndeks = Converters.toStudentIndeks(request);

		int nextBroj = studentIndeksService.findBroj(request.getGodina(), request.getStudProgramOznaka());
		studentIndeks.setBroj(nextBroj);

		Optional<StudentPodaci> studentPodaci = studentPodaciRepository.findById(request.getStudentId());
		if(studentPodaci.isEmpty()) return null;		//TODO - throw error if not exist
		studentIndeks.setStudent(studentPodaci.get());

		List<StudijskiProgram> studijskiProgrami = studijskiProgramRepository.findByOznaka(request.getStudProgramOznaka());
		if (studijskiProgrami.isEmpty()) {
			new RuntimeException("No StudijskiProgram found with oznaka: " + request.getStudProgramOznaka());
		}
		studentIndeks.setStudijskiProgram(studijskiProgrami.get(0));

		try {
			StudentIndeks savedStudentIndeks = studentIndeksRepository.save(studentIndeks);
			return savedStudentIndeks.getId();
		} catch (DataIntegrityViolationException e) {
			// TODO
			throw new RuntimeException("Duplicate entry for broj, godina, and studProgramOznaka", e);
		} catch (Exception e) {
			throw new RuntimeException("Error while saving the StudentIndeks.", e);
		}
 	}
    
    @GetMapping(path="/indeks/{id}")
    public StudentIndeks getStudentIndeks(@PathVariable Long id){    	    	
    	Optional<StudentIndeks> rez = studentIndeksRepository.findById(id);
    	if(rez.isEmpty()) return null;
    	else {
    		StudentIndeks retVal = rez.get();    		
    		return retVal;
    	}
    	    	
    }
    
    @GetMapping(path="/indeksi/{idStudentPodaci}")
    public List<StudentIndeks> getIndeksiForStudentPodaciId(@PathVariable Long idStudentPodaci){
    	return studentIndeksRepository.findStudentIndeksiForStudentPodaciId(idStudentPodaci);
    	
    }
    
    @GetMapping(path="/fastsearch")  // salje se string oblika rn1923 - smer godina broj
    public StudentIndeks fastSearch(@RequestParam String indeksShort) {
      String[] parsedData = ParseUtils.parseIndeks(indeksShort);
      if(parsedData!=null) {
    	  StudentIndeks si = studentIndeksRepository.findStudentIndeks(parsedData[0], 2000+Integer.parseInt(parsedData[1]),Integer.parseInt(parsedData[2]));	
    	  return si;
      }else return null;
    }
    
    @GetMapping(path="/emailsearch")  // salje se email studenta
    public StudentIndeks emailSearch(@RequestParam String studEmail) {
      String[] parsedData = ParseUtils.parseEmail(studEmail);
      if(parsedData!=null) {
    	  StudentIndeks si = studentIndeksRepository.findStudentIndeks(parsedData[0], 2000+Integer.parseInt(parsedData[1]),Integer.parseInt(parsedData[2]));	
    	  return si;
      }else return null;
    }
    
    @GetMapping(path="/search")  // pretraga po imenu, prezimenu i elementima indeksa
    public List<StudentDTO> search(@RequestParam (required = false) String ime,
    										  @RequestParam (required = false) String prezime,
    										  @RequestParam (required = false) String studProgram,
    										  @RequestParam (required = false) Integer godina,
    										  @RequestParam (required = false) Integer broj) {    	
    	List<StudentDTO> retVal = new ArrayList<StudentDTO>();	
    	if(studProgram==null && godina == null && broj==null) { // pretrazivanje studenata bez indeksa
    		List<StudentPodaci> spList = studentPodaciRepository.findStudent(ime, prezime);
    		retVal = spList.stream().map(EntityMappers::fromStudentPodaciToDTO).collect(Collectors.toList());
    	}
    	List<StudentIndeks> siList = studentIndeksRepository.findStudentIndeks(ime, prezime, studProgram, godina, broj);
    	List<StudentDTO> addedElem = siList.stream().map(EntityMappers::fromStudentIndeksToDTO).collect(Collectors.toList());
    	retVal.addAll(addedElem);
    	return retVal;
    }
    
    @GetMapping(path="/profile/{studentIndeksId}")  
    public StudentProfileDTO getStudentProfile(@PathVariable  Long studentIndeksId) {
    	return studentProfileService.getStudentProfile(studentIndeksId);   	
    }
    
    @GetMapping(path="/webprofile/{studentIndeksId}")  
    public StudentWebProfileDTO getStudentWebProfile(@PathVariable  Long studentIndeksId) {
    	return studentProfileService.getStudentWebProfile(studentIndeksId);   	
    }
    
    @GetMapping(path="/webprofile/email")  
    public StudentWebProfileDTO getStudentWebProfileForEmail(@RequestParam String studEmail) {
    	 String[] parsedData = ParseUtils.parseEmail(studEmail);
         if(parsedData!=null) {
       	  StudentIndeks si = studentIndeksRepository.findStudentIndeks(parsedData[0], 2000+Integer.parseInt(parsedData[1]),Integer.parseInt(parsedData[2]));
       	  if(si!=null)
       		  return studentProfileService.getStudentWebProfile(si.getId());   	
         }
         return null;
    }
   
    
}

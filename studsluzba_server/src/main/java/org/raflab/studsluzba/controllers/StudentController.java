package org.raflab.studsluzba.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.StudentPodaci;
import org.raflab.studsluzba.model.dtos.StudentDTO;
import org.raflab.studsluzba.repositories.StudentIndeksRepository;
import org.raflab.studsluzba.repositories.StudentPodaciRepository;
import org.raflab.studsluzba.utils.EntityMappers;
import org.raflab.studsluzba.utils.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(path="/student")
public class StudentController {
	
	
	@Autowired
	StudentPodaciRepository studentPodaciRepository;
	
	@Autowired
	StudentIndeksRepository studIndeksRepository;
	
    
    @PostMapping(path="/add") 
   	public @ResponseBody String addNewStudentPodaci (@RequestBody StudentPodaci studentPodaci) {   
    	System.out.println(studentPodaci.getDatumRodjenja());
   	    studentPodaciRepository.save(studentPodaci);
   	    return "Student sačuvan";
   	 }
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<StudentPodaci> getAllStudentPodaci() {      
      return studentPodaciRepository.findAll();
    }
    
    @GetMapping(path="/fastsearch")  // salje se string oblika rn1923 - smer godina broj
    public @ResponseBody StudentIndeks fastSearch(@RequestParam String indeksShort) {
      String[] parsedData = ParseUtils.parseIndeks(indeksShort);
      if(parsedData!=null) {
    	  StudentIndeks si = studIndeksRepository.findStudentIndeks(parsedData[0], 2000+Integer.parseInt(parsedData[1]),Integer.parseInt(parsedData[2]));	
    	  return si;
      }else return null;
    }
    
    @GetMapping(path="/search")  // pretraga po imenu, prezimenu i delovima indeksa
    public @ResponseBody List<StudentDTO> search(@RequestParam (required = false) String ime,
    										  @RequestParam (required = false) String prezime,
    										  @RequestParam (required = false) String studProgram,
    										  @RequestParam (required = false) Integer godina,
    										  @RequestParam (required = false) Integer broj) {
    List<StudentDTO> retVal = new ArrayList<StudentDTO>();	
    if(studProgram==null && godina == null && broj==null) { // pretrazivanje studenata bez indeksa
    	List<StudentPodaci> spList = studentPodaciRepository.findStudent(ime, prezime);
    	retVal = spList.stream().map(EntityMappers::fromStudentPodaciToDTO).collect(Collectors.toList());
    }
    List<StudentIndeks> siList = studIndeksRepository.findStudentIndeks(ime, prezime, studProgram, godina, broj);
    List<StudentDTO> addedElem = siList.stream().map(EntityMappers::fromStudentIndeksToDTO).collect(Collectors.toList());
    retVal.addAll(addedElem);
    return retVal;
    }
   

}

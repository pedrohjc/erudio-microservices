package com.pedrohjc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pedrohjc.model.Person;
import com.pedrohjc.repository.PersonRepository;

@RestController
@RequestMapping("/base")
public class MathController {
	
	@Autowired
	private PersonRepository repository;

    @RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
    public int sum(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception{
        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new Exception("Wrong input");
        }
        int sum  = Integer.parseInt(n1) + Integer.parseInt(n2);
        return sum;
    }

    private boolean isNumeric(String num) {
        if(num == null) return false;
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    
    @RequestMapping("")
    public List<Person> findAllPerson(){
		return repository.findAll();
    }
    
    @PostMapping("/")
    public void add(@RequestBody Person person) {
    	Person p = new Person();
    	p.setFirstName(person.getFirstName());
    	p.setLastName(person.getLastName());
    	repository.save(p);
    }
    
    @GetMapping("/{id}")
    public Optional<Person> find(@PathVariable(value = "id")Long id) {
		var p = repository.findById(id);
    	return p;
    }

}

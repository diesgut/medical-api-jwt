package com.diesgut.medical.apijwt.controller.speciality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diesgut.medical.model.Speciality;

@RestController
@RequestMapping("/specialities")
public class SpecialityRestController {
	
	@Autowired
	private ISpecialityService service;

	@GetMapping
	public ResponseEntity<List<Speciality>> specialities() {
		List<Speciality> list = service.allSpecialities();
		return new ResponseEntity<List<Speciality>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Speciality> save(@RequestBody Speciality speciality) {
		System.out.println("save");
		service.save(speciality);
		ResponseEntity<Speciality> response = new ResponseEntity<Speciality>(speciality, HttpStatus.OK);
		return response;
	}

	@PutMapping
	public ResponseEntity<Speciality> update(@RequestBody Speciality speciality) {
		System.out.println("update");
		service.update(speciality);
		ResponseEntity<Speciality> response = new ResponseEntity<Speciality>(speciality, HttpStatus.OK);
		return response;
	}

	@GetMapping("{id}")
	public ResponseEntity<Speciality> specialityById(@PathVariable(name = "id") Long idSpeciality, Model model) {
		Speciality speciality = service.findSpeciality(idSpeciality);
		ResponseEntity<Speciality> response = new ResponseEntity<Speciality>(speciality, HttpStatus.OK);
		return response;
	}
}

package com.diesgut.medical.apijwt.controller.patient;

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

import com.diesgut.medical.model.Patient;

@RestController
@RequestMapping("/patients")
public class PatientRestController {

	@Autowired
	private IPatientService service;

	@GetMapping
	public ResponseEntity<List<Patient>> patients() {
		List<Patient> list = service.allPatients();
//		if (list.isEmpty()) {
//			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Patient> save(@RequestBody Patient patient) {
		System.out.println("save");
		service.save(patient);
		ResponseEntity<Patient> response = new ResponseEntity<Patient>(patient, HttpStatus.OK);
		return response;
	}

	@PutMapping
	public ResponseEntity<Patient> update(@RequestBody Patient Patient) {
		System.out.println("update");
		service.update(Patient);
		ResponseEntity<Patient> response = new ResponseEntity<Patient>(Patient, HttpStatus.OK);
		return response;
	}

	@GetMapping("{id}")
	public ResponseEntity<Patient> patientById(@PathVariable(name = "id") Long idPatient, Model model) {
		Patient Patient = service.findPatient(idPatient);
		ResponseEntity<Patient> response = new ResponseEntity<Patient>(Patient, HttpStatus.OK);
		return response;
	}

}

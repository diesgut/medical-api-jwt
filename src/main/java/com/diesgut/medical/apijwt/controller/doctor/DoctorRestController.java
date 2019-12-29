package com.diesgut.medical.apijwt.controller.doctor;

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

import com.diesgut.medical.model.Doctor;

@RestController
@RequestMapping("/doctors")
public class DoctorRestController {

	@Autowired
	private IDoctorService service;

	@GetMapping
	public ResponseEntity<List<Doctor>> doctors() {
		List<Doctor> list = service.allDoctors();
//		list.forEach(x -> x.getSpeciality().setDoctors(null));
		if (list.isEmpty()) {
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
		doctor.getSpeciality().setDoctors(null);
		System.out.println("save");
		service.save(doctor);
		ResponseEntity<Doctor> response = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		return response;
	}

	@PutMapping
	public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {
//		doctor.getSpeciality().setDoctors(null);
		System.out.println("update");
		service.update(doctor);
		ResponseEntity<Doctor> response = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		return response;
	}

	@GetMapping("{id}")
	public ResponseEntity<Doctor> doctor(@PathVariable(name = "id") Long idDoctor, Model model) {
		Doctor doctor = service.findDoctor(idDoctor);
//		if (doctor != null) {
//			doctor.getSpeciality().setDoctors(null);
//		}
		ResponseEntity<Doctor> response = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		return response;
	}

}

package com.diesgut.medical.apijwt.controller.patient;

import java.util.List;

import com.diesgut.medical.model.Patient;

interface IPatientService {

	List<Patient> allPatients();

	void save(Patient patient);

	void update(Patient patient);

	Patient findPatient(Long idPatient);

}

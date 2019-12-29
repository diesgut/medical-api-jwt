package com.diesgut.medical.apijwt.controller.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diesgut.medical.apijwt.dao.IDoctorDao;
import com.diesgut.medical.model.Doctor;

@Service
@Transactional(readOnly = true)
public class DoctorServiceImp implements IDoctorService {

	@Autowired
	IDoctorDao iDoctorDao;

	@Override
	public void save(Doctor doctor) {
		iDoctorDao.save(doctor);
	}

	@Override
	public void update(Doctor doctor) {
		iDoctorDao.update(doctor);
	}

	@Override
	@Transactional
	public void delete(Doctor doctor) {
		iDoctorDao.delete(doctor.getId());
	}

	@Override
	public List<Doctor> allDoctors() {
		return iDoctorDao.all();
	}

	@Override
	public Doctor findDoctor(Long idDoctor) {
		return iDoctorDao.find(idDoctor);
	}

	
}

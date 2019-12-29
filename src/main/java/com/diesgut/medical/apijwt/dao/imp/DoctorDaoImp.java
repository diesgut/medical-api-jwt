package com.diesgut.medical.apijwt.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diesgut.medical.apijwt.dao.EasyDAO;
import com.diesgut.medical.apijwt.dao.IDoctorDao;
import com.diesgut.medical.model.Doctor;
import com.diesgut.medical.model.Speciality;

@Repository
public class DoctorDaoImp extends AbstractEasyDao<Doctor> implements IDoctorDao, EasyDAO<Doctor> {

	public DoctorDaoImp() {
		super();
		setClazz(Doctor.class);
	}

	@Override
	public List<Doctor> allBySpeciality(Speciality speciality) {
		String strQuery = "from Doctor doc  where doc.speciality.id=:SPEC";
		Query query = em.createQuery(strQuery);
		query.setParameter("SPEC", speciality.getId());
		return (List<Doctor>) query.getResultList();
	}
}

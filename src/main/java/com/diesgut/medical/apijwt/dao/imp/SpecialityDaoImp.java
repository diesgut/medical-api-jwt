package com.diesgut.medical.apijwt.dao.imp;

import org.springframework.stereotype.Repository;

import com.diesgut.medical.apijwt.dao.EasyDAO;
import com.diesgut.medical.apijwt.dao.ISpecialityDao;
import com.diesgut.medical.model.Speciality;

@Repository
public class SpecialityDaoImp extends AbstractEasyDao<Speciality> implements ISpecialityDao, EasyDAO<Speciality> {

	public SpecialityDaoImp() {
		super();
		setClazz(Speciality.class);
	}
}

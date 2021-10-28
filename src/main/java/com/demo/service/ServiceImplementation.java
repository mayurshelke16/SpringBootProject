package com.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.Admindao;
import com.demo.model.Admin;

@Service
public class ServiceImplementation implements serviceInterface {

	@Autowired
	private Admindao admindao;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin adminsave = admindao.save(admin);
		return adminsave;
	}

	@Override
	public List<Admin> getdata() {

		return admindao.findAll();
		 //return admindao.findAll();
	}

	@Override
	public Admin getAdminId(int id) {
		// TODO Auto-generated method stub
		return admindao.findById(id).get();
	}

	@Override
	public void deleteId(int id) {
		admindao.deleteById(id);

	}

	@Override
	public List<Admin> searchUser(String name) {
		
		return admindao.findByName(name);
		}

	@Override
	public List<Admin> sortdob() {
		
		return admindao.findAllByOrderByDOBAsc();
				
	}

	@Override
	public Admin update(Admin admin) {
		Admin adminsave = admindao.save(admin);
		return adminsave;
	}

}

package com.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dao.Admindao;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Admin;

@Service
public class ServiceImplementation implements serviceInterface {

	@Autowired
	private Admindao admindao;

	@Override
	public Admin addAdmin(Admin admin) {
		
		if(admin.getName().isEmpty() || admin.getName().length()==0) {
			throw new ResourceNotFoundException("Admin name not Empty: "+ admin.getName());
		}else
			if(admin.getSurname().isEmpty() || admin.getSurname().length()==0)
			{
				throw new ResourceNotFoundException("admin Surname is not Empty: "+admin.getSurname());
			}else
				if(admin.getAddress().isEmpty() || admin.getAddress().length()==0)
				{
					throw new ResourceNotFoundException("admin Address is not Empty: "+admin.getAddress());
				}else
					if(admin.getPincode().isEmpty() || admin.getPincode().length()<=4)
					{
						throw new ResourceNotFoundException("admin pincode is not Empty: "+admin.getPincode());
					}else
						if(admin.getAge()==0 || admin.getAge()<=17)
						{
							throw new ResourceNotFoundException("admin Age is not Empty: "+admin.getAge());
						}else
							if(admin.getEmail().isEmpty() || admin.getEmail().length()<=5)
							{
								throw new ResourceNotFoundException("admin Email is not Empty or gretarthan lenth 6: "+admin.getEmail());
							}
		
		Admin adminsave = admindao.save(admin);
		return adminsave;
	}

	@Override
	public List<Admin> getdata() {
		return admindao.findAll();
	}

	@Override
	public Admin getAdminId(int id) {
		return admindao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id :" + id));
	}

	@Override
	public Admin deleteId(int id) {
             Admin existadmin=	admindao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found with id :" + id));
           
              admindao.delete(existadmin);
			return existadmin;
             
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

package com.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.Admindao;
import com.demo.model.Admin;
import com.demo.service.serviceInterface;

@Controller
public class AdminController {

	
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private serviceInterface serveInterface;
	
	@PostMapping("/adminadd")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin)
	{
		log.info("Request to add admin");
		Admin adminsave=serveInterface.addAdmin(admin);
		return new ResponseEntity<Admin>(adminsave,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<Admin>> getdatils()
	{
		List<Admin> admindtetail=serveInterface.getdata();
		return new ResponseEntity<List<Admin>>(admindtetail,HttpStatus.OK);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getadminID(@PathVariable int id)
	{
		Admin listofadmin=serveInterface.getAdminId(id);
		return new ResponseEntity<Admin>(listofadmin,HttpStatus.OK);
	
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteIDSoft(@PathVariable("id") int id)
	{
		serveInterface.deleteId(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
   public ResponseEntity<Void> deleteIDHard(@PathVariable("id") int id)
   {
	   serveInterface.deleteId(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	   
   }
	
	@PutMapping("/update")
	public ResponseEntity<Admin> updatdetails(@RequestBody Admin admin)
	{
		Admin adminsaveData=serveInterface.update(admin);
		return new ResponseEntity<Admin>(adminsaveData,HttpStatus.CREATED);
	}
	@GetMapping("/{name}")
	public ResponseEntity<List<Admin>> getdetails(@PathVariable String name)
	{
		List<Admin> admindtetail=serveInterface.searchUser(name);
		return new ResponseEntity<List<Admin>>(admindtetail,HttpStatus.OK);
		
	}
	
	@GetMapping("/sortdob")
	public ResponseEntity<List<Admin>> sortByDOB()
	{
		List<Admin> sortdata= serveInterface.sortdob();
	
		return new ResponseEntity<List<Admin>>(sortdata,HttpStatus.OK);	
	}
	
	
	
}

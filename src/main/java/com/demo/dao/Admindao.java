package com.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.model.Admin;
@Repository
public interface Admindao extends JpaRepository<Admin, Integer>{

	//@Query(value = "select * from admin where name like '%j'",nativeQuery = true)

	/*
	 * @Query(value = "select * from admin", nativeQuery = true) List<Admin>
	 * findAdmin();
	 */


	//@Query(value ="select * from admin where surname='name'",nativeQuery = true)
	List<Admin> getByname(String name);



	List<Admin> findByName(String name);
	
	List<Admin> findAllByOrderByDOBAsc();
	
	Optional<Admin>  findByEmail(String email);
}

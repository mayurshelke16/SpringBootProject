package com.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.model.Admin;

public interface serviceInterface {

   public Admin addAdmin(Admin admin);

public  List<Admin> getdata();

public Admin getAdminId(int id);

public Admin deleteId(int id);

public List<Admin> searchUser(String name);

public List<Admin> sortdob();

public Admin update(Admin admin);


}

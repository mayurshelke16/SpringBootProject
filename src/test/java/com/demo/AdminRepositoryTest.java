package com.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dao.Admindao;
import com.demo.model.Admin;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdminRepositoryTest {

	
	@Autowired
	private Admindao admindao;
	
	// JUnit test for save admin
	@Test
	public void saveAdminTest()
	{
		Admin admin= Admin.builder().name("mayur").surname("shelke").address("Pune").pincode("410506").gender("male").email("mayurshelke55@gmail.com").age(10).DOB("1990-01-02").DOJ("2000-01-02").build();
		
		
		admindao.save(admin);
		Assertions.assertThat(admin.getId()).isGreaterThan(0);
		
			
		
	}
	@Test
	public void getAdmintest()
	{
		
		Admin admin = admindao.findById(14).get();
		
		Assertions.assertThat(admin.getId()).isEqualTo(14);
		
	}
	
	
	@Test
	public void getListOfAdmintest()
	{
		
		List<Admin> admin = admindao.findAll();
		
		Assertions.assertThat(admin.size()).isGreaterThan(0);
		
	}

	
	@Test
	public void updateAdmintest()
	{
		
		Admin admin = admindao.findById(14).get();
		admin.setEmail("mayurshelke550@gmail.com");
	    Admin adminupdate=	admindao.save(admin);
		Assertions.assertThat(adminupdate.getEmail()).isEqualTo("mayurshelke550@gmail.com");
		
	}
	
	@Test
	public void deleteAdminTest()
	{
		Admin admin =admindao.findById(16).get();
		admindao.delete(admin);
		
		Admin admin1=null;
		
		Optional<Admin> optional = admindao.findByEmail("mayurshelke550@gmail.com");
		
		if(optional.isPresent())
		{
			admin1=optional.get();
		}
		
		Assertions.assertThat(admin1).isNull();
	}
	
}

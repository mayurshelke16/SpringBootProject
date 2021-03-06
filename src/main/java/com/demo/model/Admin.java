package com.demo.model;



import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Entity
@SQLDelete(sql = "UPDATE admin SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Valid
public class Admin {
     
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	@Size(min=2, max=30)
	private String name;
	
	@javax.validation.constraints.NotNull
	private String surname;
	
	@NotNull
	private String address;
	
	@NotEmpty
	private String gender;
	@NotNull
	@Min(18)
	private int age;
	
	@NotNull
	@Email(message = "Please enter a valid e-mail address")
    private String email;

	@NotNull
	private String pincode;
	
	@NotNull
	private String  DOB;
	
	@NotNull
	private String DOJ;
	
	@NotNull
	private boolean deleted = Boolean.FALSE;
	}
//	@Override
	/*public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", age=" + age
				+ ", email=" + email + "]";
	}

*/	
	


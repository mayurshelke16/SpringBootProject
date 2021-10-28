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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.sun.istack.NotNull;

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
	@Pattern(regexp = "(?=.*[A-Z])[\\p{Punct}A-Z0-9 ]{1,32}", message = "Error")
	private String name;
	
	@NotEmpty
	private String surname;
	
	@NotNull
	private String address;
	
	@NotEmpty
	private String gender;
	@Min(18)
	private int age;
	
	@Email(message = "Please enter a valid e-mail address")
    private String email;

	private String pincode;
	@NotNull
	private String  DOB;
	
	@NotNull
	private String DOJ;
	private boolean deleted = Boolean.FALSE;
	}
//	@Override
	/*public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", age=" + age
				+ ", email=" + email + "]";
	}

*/	
	


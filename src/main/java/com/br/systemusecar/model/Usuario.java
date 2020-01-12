package com.br.systemusecar.model;
/*
 * Criado por Ikeblem 11/01/2020
 * */

import java.sql.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * Nome do usuário
	 * */
	@NotNull
	private String firstName;
	
	/*
	 * Sobrenome do usuário
	 */
	private String lastName;  
	
	/*
	 * E-mail do usuário
	 */
	private String  email; 
	
	/*
	 * Data de nascimento do usuário
	 */
	private Date birthday;  
	
	/*
	 * Login do usuário
	 */
	@NotNull
	private String  login; 
	
	/*
	 * Senha do usuário
	 */
	@NotNull
	private String password;  

	/*
	 * Telefone do usuário
	 */
	private String phone;
	
	/*
	 * ,Lista de carros do usuário
	 */
	private List<Carro> cars;

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param birthday
	 * @param login
	 * @param password
	 * @param phone
	 */
	public Usuario(Long Id, String firstName, String lastName, String email, Date birthday, String login, String password,
			String phone, List cars) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.login = login;
		this.password = password;
		this.phone = phone;
		this.cars = cars;
	}  
	
	public Long getId() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}
	
	public Usuario() {
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}  
	
	public List getcars() {
		return cars;
	}

	public void setcars(List cars) {
		this.cars = cars;
	}  

	
}

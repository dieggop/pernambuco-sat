package com.br.systemusecar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Carro {
	/*
	 * Codigo sequencial da tabela.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * Ano de fabricação do carro
	 */
	@NotNull
	private int year;  
	
	/*
	 * Placa do carro 
     */
	@NotNull
	private String licensePlate;
	
	/*
	 * Modelo do carro
	 */
	@NotNull
	private String modelo;  
	
	/*
	 * Cor predominante do carro
	 */
	@NotNull
	private  String color;

	
	
	public Carro(int year, String licensePlate, String modelo, String color) {
		super();
		this.year = year;
		this.licensePlate = licensePlate;
		this.modelo = modelo;
		this.color = color;
	}
	
	public Carro() {
	
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}

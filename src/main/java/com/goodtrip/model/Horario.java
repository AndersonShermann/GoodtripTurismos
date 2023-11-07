package com.goodtrip.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Horario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String horaSaida;

	//Construtor
	public Horario() {

	}
	
	public Horario(Integer id, String horaSaida) {
		super();
		this.id = id;
		this.horaSaida = horaSaida;
	}

	
	
	//Acessores
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", horaSaida=" + horaSaida + "]";
	}
	
	
	
}

package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="COMPANIASSEGUROS", schema = "SEGUNI")
public class CompaniasSeguros implements Serializable{

	private static final long serialVersionUID = -5812381992640470533L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANIA_IDS")
	@SequenceGenerator(name = "COMPANIA_IDS", allocationSize = 1, schema = "SEGUNI")
	private Integer id;

	@Column(name="NUMEROPOLIZA")
	private Integer numeroPoliza;
	
	@Column(name="NOMBRECOMPANIA")
	private String nombreCompania;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
}

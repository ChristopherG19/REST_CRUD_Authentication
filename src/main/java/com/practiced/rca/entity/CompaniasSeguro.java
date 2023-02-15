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
@Table(name="COMPANIASSEGUROS")
public class CompaniasSeguro implements Serializable{

	private static final long serialVersionUID = -5812381992640470533L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANIA_IDS")
	@SequenceGenerator(name = "COMPANIA_IDS", allocationSize = 1)
	private long id;

	@Column(name="NUMEROPOLIZA")
	private Integer numeroPoliza;
	
	@Column(name="NOMBRECOMPANIA")
	private String nombreCompania;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

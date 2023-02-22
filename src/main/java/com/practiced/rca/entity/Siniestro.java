package com.practiced.rca.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SINIESTROS", schema = "SEGUNI")
public class Siniestro implements Serializable{

	private static final long serialVersionUID = 8078516714270213610L;

	@Id
	@Column(name="ID_SINIESTRO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SINIESTROS_IDS")
	@SequenceGenerator(name = "SINIESTROS_IDS",sequenceName="sec_siniestros", allocationSize = 1, schema = "SEGUNI")
	private Integer idSiniestro;
	
	@Column(name="FECHA_SINIESTRO")
	private Date fechaSiniestro;
	
	@Column(name="CAUSAS")
	private String causas;
	
	@Column(name="ACEPTADO")
	private char aceptado;
	
	@Column(name="INDEMNIZACION")
	private double indemnizacion;
	
	@Column(name="NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="DNI_PERITO")
	private Perito perito;

	public Integer getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public String getCausas() {
		return causas;
	}

	public void setCausas(String causas) {
		this.causas = causas;
	}

	public char getAceptado() {
		return aceptado;
	}

	public void setAceptado(char aceptado) {
		this.aceptado = aceptado;
	}

	public double getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Perito getPerito() {
		return perito;
	}

	public void setPerito(Perito perito) {
		this.perito = perito;
	}
}

package com.practiced.rca.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SINIESTROS")
public class Siniestro implements Serializable{

	private static final long serialVersionUID = 8078516714270213610L;

	@Id
	@Column(name="IDSINIESTRO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SINIESTROS_IDS")
	@SequenceGenerator(name = "SINIESTROS_IDS", allocationSize = 1)
	private long idSiniestro;
	
	@Column(name="FECHASINIESTRO")
	private Date fechaSiniestro;
	
	@Column(name="CAUSAS")
	private String causas;
	
	@Column(name="ACEPTADO")
	private String aceptado;
	
	@Column(name="INDEMNIZACION")
	private Integer indemnizacion;
	
	@Column(name="NUMEROPOLIZA")
	private Integer numeroPoliza;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name="DPIPERITO")
	private Perito perito;

	public Perito getPerito() {
		return perito;
	}

	public void setPerito(Perito perito) {
		this.perito = perito;
	}

	public long getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(long idSiniestro) {
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

	public String getAceptado() {
		return aceptado;
	}

	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}

	public Integer getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(Integer indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
}

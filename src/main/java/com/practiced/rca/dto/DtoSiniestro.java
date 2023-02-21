package com.practiced.rca.dto;

import java.util.Date;

import com.practiced.rca.entity.Perito;

public class DtoSiniestro {
	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private char aceptado;
	private double indemnizacion;
	private Integer numeroPoliza;
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

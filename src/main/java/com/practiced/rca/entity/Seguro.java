package com.practiced.rca.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SEGUROS")
public class Seguro implements Serializable{

	private static final long serialVersionUID = 179616312973709072L;

	@Id
	@Column(name="NUMEROPOLIZA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGUROS_IDS")
	@SequenceGenerator(name = "SEGUROS_IDS", allocationSize = 1)
	private long numeroPoliza;
	
	@Column(name="RAMO")
	private String ramo;
	
	@Column(name="FECHAINICIO")
	private Date fechaInicio;
	
	@Column(name="FECHAVENCIMIENTO")
	private Date fechaVencimiento;
	
	@Column(name="CONDICIONESPARTICULARES")
	private String condicionesParticulares;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@Column(name="DPI")
	private String dpi;
	
	 @ManyToMany(mappedBy = "seguros")
	 private Set<Compania> companias;

	public long getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(long numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionesParticulares() {
		return condicionesParticulares;
	}

	public void setCondicionesParticulares(String condicionesParticulares) {
		this.condicionesParticulares = condicionesParticulares;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}
}

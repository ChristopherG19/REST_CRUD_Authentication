package com.practiced.rca.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SEGUROS", schema = "SEGUNI2")
@Data
public class Seguro implements Serializable{

	private static final long serialVersionUID = 179616312973709072L;

	@Id
	@Column(name="NUMEROPOLIZA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGUROS_IDS")
	@SequenceGenerator(name = "SEGUROS_IDS", allocationSize = 1, schema = "SEGUNI")
	private Integer numeroPoliza;
	
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUMEROPOLIZA")
	private List<Siniestro> siniestros;
	
}

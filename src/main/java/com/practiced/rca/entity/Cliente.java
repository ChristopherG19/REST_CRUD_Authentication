package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CLIENTES", schema = "SEGUNI2")
@Data
public class Cliente implements Serializable{

	private static final long serialVersionUID = -3630605027551015154L;

	@Id
	@Column(name="DPI")
	private String dpi;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDOP")
	private String apellidoP;

	@Column(name="APELLIDOM")
	private String apellidoM;
	
	@Column(name="CLASEVIA")
	private String claseVia;
	
	@Column(name="NOMBREVIA")
	private String nombreVia;
	
	@Column(name="NUMEROVIA")
	private Integer numeroVia;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;

}

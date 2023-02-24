package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PERITOS", schema = "SEGUNI")
@Data
public class Perito implements Serializable{
	
	private static final long serialVersionUID = -8911871826469653441L;

	@Id
	@Column(name="DPIPERITO")
	private String dpiPerito;
	
	@Column(name="NOMBREPERITO")
	private String nombrePerito;
	
	@Column(name="APELLIDOP")
	private String apellidoP;

	@Column(name="APELLIDOM")
	private String apellidoM;
	
	@Column(name="TELEFONOCONTACTO")
	private String telefonoContacto;
	
	@Column(name="TELEFONOOFICINA")
	private String telefonoOficina;
	
	@Column(name="CLASEVIA")
	private String claseVia;
	
	@Column(name="NOMBREVIA")
	private String nombreVia;
	
	@Column(name="NUMEROVIA")
	private Integer numeroVia;
	
	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;
	
	@Column(name="CIUDAD")
	private String ciudad;

}

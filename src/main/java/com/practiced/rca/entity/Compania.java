package com.practiced.rca.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="COMPANIAS", schema = "SEGUNI2")
@Data
public class Compania implements Serializable{

	private static final long serialVersionUID = -5961990947108792377L;

	@Id
	@Column(name="NOMBRECOMPANIA")
	private String nombreCompania;
	
	@Column(name="CLASEVIA")
	private String claseVia;
	
	@Column(name="NUMEROVIA")
	private Integer numeroVia;
	
	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;
	
	@Column(name="TELEFONOCONTRATACION")
	private String telefonoContratacion;
	
	@Column(name="TELEFONOSINIESTROS")
	private String telefonoSiniestros;
	
	@Column(name="NOTAS")
	private String notas;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
            name = "COMPANIASSEGUROS",
            joinColumns = {@JoinColumn(name = "NOMBRECOMPANIA")},
            inverseJoinColumns = {@JoinColumn(name = "NUMEROPOLIZA")},
            schema = "SEGUNI"
    )
	private List<Seguro> seguros;

}

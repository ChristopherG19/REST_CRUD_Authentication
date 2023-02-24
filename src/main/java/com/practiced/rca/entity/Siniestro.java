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
import lombok.Data;

@Entity
@Table(name="SINIESTROS", schema = "SEGUNI")
@Data
public class Siniestro implements Serializable{

	private static final long serialVersionUID = 8078516714270213610L;

	@Id
	@Column(name="IDSINIESTRO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SINIESTROS_IDS")
	@SequenceGenerator(name = "SINIESTROS_IDS", allocationSize = 1, schema = "SEGUNI")
	private Integer idSiniestro;
	
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
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="DPIPERITO")
	private Perito perito;

}

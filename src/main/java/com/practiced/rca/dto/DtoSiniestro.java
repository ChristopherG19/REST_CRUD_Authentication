package com.practiced.rca.dto;

import java.util.Date;

import com.practiced.rca.entity.Perito;

import lombok.Data;

@Data
public class DtoSiniestro {
	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private String aceptado;
	private Integer indemnizacion;
	private Integer numeroPoliza;
	private Perito perito;
	
}

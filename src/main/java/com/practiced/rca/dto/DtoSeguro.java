package com.practiced.rca.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DtoSeguro {
	private Integer numeroPoliza;
	private String ramo;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private String condicionesParticulares;
	private String observaciones;
	private String dpi;
}

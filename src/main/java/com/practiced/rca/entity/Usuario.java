package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USUARIOS", schema = "SEGUNI")
@Data
public class Usuario implements Serializable{

	private static final long serialVersionUID = 7922975616686886149L;

	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DPI")
	private String dpi;

}

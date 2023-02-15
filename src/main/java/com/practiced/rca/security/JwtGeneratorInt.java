package com.practiced.rca.security;

import java.io.UnsupportedEncodingException;

import com.practiced.rca.entity.Cliente;

public interface JwtGeneratorInt {
	public String generateToken(Cliente cliente) throws UnsupportedEncodingException;
}

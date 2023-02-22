package com.practiced.rca.security;

import java.io.UnsupportedEncodingException;

import com.practiced.rca.entity.Usuario;

public interface JwtGeneratorInt {
	public String generateToken(Usuario usuario) throws UnsupportedEncodingException;
}

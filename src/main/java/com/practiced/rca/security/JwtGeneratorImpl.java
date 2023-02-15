package com.practiced.rca.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.practiced.rca.entity.Cliente;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@PropertySource("classpath:application.properties")
public class JwtGeneratorImpl implements JwtGeneratorInt{

	@Value("${jwt.secret}")
	private String secret;
	
	@Override
	public String generateToken(Cliente cliente) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(cliente.getDpi())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (60*1000)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
}

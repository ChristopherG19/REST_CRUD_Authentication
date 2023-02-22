package com.practiced.rca.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practiced.rca.entity.Usuario;
import com.practiced.rca.repository.UsuarioRepository;
import com.practiced.rca.security.JwtGeneratorImpl;
import com.practiced.rca.wsint.NoAuthServiceInt;

@Component
public class NoAuthService implements NoAuthServiceInt{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtGeneratorImpl jG;
	
	@Override
	public String getUserByUsernameAndPassword(Usuario usuario) {
		Usuario user = usuarioRepository.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		
		try {
			if (usuario.getUsername() == null || user.getPassword() == null) {
				return "Usuario o contraseña inválida";
			}
			String token = jG.generateToken(user);
			return "Token: "+ token;
			
		} catch (Exception e) {
			return "Usuario o contraseña inválida";
		}
		
	}

}

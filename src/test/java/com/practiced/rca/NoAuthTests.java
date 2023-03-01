package com.practiced.rca;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practiced.rca.entity.Usuario;
import com.practiced.rca.repository.UsuarioRepository;

@SpringBootTest
class NoAuthTests {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	void testGetUsersByPasswordAndUser() {
		Usuario user = usuarioRepository.findByUsernameAndPassword("test", "test");
		assertNotNull(user, "El usuario no existe");
	}
	
}

package com.practiced.rca.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiced.rca.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	public Usuario findByUsernameAndPassword(String username, String password);
}

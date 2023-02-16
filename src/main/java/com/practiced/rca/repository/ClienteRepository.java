package com.practiced.rca.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiced.rca.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{
	public Page<Cliente> findAll(Pageable pageable);
	public List<Cliente> findByCiudadContaining(String city);
	public List<Cliente> findByObservacionesNotLike(String word);
	public List<Cliente> findByCodigoPostalStartingWith(String codPostal);
}

package com.practiced.rca.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiced.rca.entity.Compania;

@Repository("companiaRepository")
public interface CompaniaRepository extends JpaRepository<Compania, Serializable>{
	public Page<Compania> findAll(Pageable pageable);
	public Compania findByNombreCompaniaLike(String name);
	public List<Compania> findByNotasIsNotNull();
	public List<Compania> findByTelefonoSiniestrosStartingWith(String ext);
}

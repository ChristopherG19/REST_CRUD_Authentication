package com.practiced.rca.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiced.rca.entity.Siniestro;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Serializable>{
	public Page<Siniestro> findAll(Pageable pageable);
	public List<Siniestro> findByAceptadoLike(String state);
	public List<Siniestro> findByFechaSiniestroAfter(Date date);
	public List<Siniestro> findByIndemnizacionLessThan(int indem);
}

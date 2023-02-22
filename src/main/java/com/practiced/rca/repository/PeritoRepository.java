package com.practiced.rca.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiced.rca.entity.Perito;

@Repository("peritoRepository")
public interface PeritoRepository extends JpaRepository<Perito, Serializable>{
	public Page<Perito> findAll(Pageable pageable);
	public Perito findByDpiPeritoLike(String dpi);
	public List<Perito> findByNumeroViaGreaterThan(int numeroVia);
	public List<Perito> findByApellidoPAndApellidoM(String apeP, String apeM);
}

package com.practiced.rca.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiced.rca.entity.Seguro;

@Repository("seguroRepository")
public interface SeguroRepository  extends JpaRepository<Seguro, Serializable>{
	public Page<Seguro> findAll(Pageable pageable);
}

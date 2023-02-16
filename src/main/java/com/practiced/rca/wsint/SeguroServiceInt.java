package com.practiced.rca.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiced.rca.dto.DtoSeguro;
import com.practiced.rca.entity.Seguro;

@RestController
@RequestMapping("/api/auth/seguros")
@CrossOrigin
public interface SeguroServiceInt {

	@GetMapping("/find/{page}/{offset}")
	public List<DtoSeguro> findAllSeguros(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/guardar")
	public Seguro guardar(@RequestBody DtoSeguro seguro);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteSeguro(@PathVariable("id") int numeroPoliza);
	
}

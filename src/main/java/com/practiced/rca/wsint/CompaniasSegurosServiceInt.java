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

import com.practiced.rca.dto.DtoCompaniasSeguros;
import com.practiced.rca.entity.CompaniasSeguros;

@RestController
@RequestMapping("/api/auth/companiasS")
@CrossOrigin
public interface CompaniasSegurosServiceInt {

	@GetMapping("/find/{page}/{offset}")
	public List<DtoCompaniasSeguros> findAllCompaniasSeguros(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/guardar")
	public CompaniasSeguros guardar(@RequestBody DtoCompaniasSeguros companiaS);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteCompaniaS(@PathVariable("id") int id);
}

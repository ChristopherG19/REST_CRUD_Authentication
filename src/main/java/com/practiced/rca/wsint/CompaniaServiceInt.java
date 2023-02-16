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

import com.practiced.rca.dto.DtoCompania;
import com.practiced.rca.entity.Compania;

@RestController
@RequestMapping("/api/auth/companias")
@CrossOrigin
public interface CompaniaServiceInt {

	@GetMapping("/notas")
	public List<Compania> searchByNotas();
	
	@GetMapping("/telS/{ext}")
	public List<Compania> searchByTelefonoSini(@PathVariable("ext") String ext);
	
	@GetMapping("/find/{page}/{offset}")
	public List<DtoCompania> findAllCompanias(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/guardar")
	public Compania guardar(@RequestBody DtoCompania compania);
	
	@DeleteMapping("/eliminar/{name}")
	public void deleteCompania(@PathVariable("name") String name);
}

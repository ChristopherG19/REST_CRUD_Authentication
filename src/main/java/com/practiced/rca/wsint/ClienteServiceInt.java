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

import com.practiced.rca.dto.DtoCliente;
import com.practiced.rca.entity.Cliente;

@RestController
@RequestMapping("/api/auth/clientes")
@CrossOrigin
public interface ClienteServiceInt {

	@GetMapping("/ciudad/{ciudad}")
	public List<Cliente> searchByCiudad(@PathVariable("ciudad") String ciudad);
	
	@GetMapping("/obs/{word}")
	public List<Cliente> searchByObservaciones(@PathVariable("word") String word);
	
	@GetMapping("/codeP/{codPostal}")
	public List<Cliente> searchByCodPostal(@PathVariable("codPostal") String codPostal);
	
	@GetMapping("/find/{page}/{offset}")
	public List<DtoCliente> findAllUsers(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/guardar")
	public Cliente guardar(@RequestBody DtoCliente cliente);
	
	@DeleteMapping("/eliminar/{dpi}")
	public void deleteCliente(@PathVariable("dpi") String dpi);
}

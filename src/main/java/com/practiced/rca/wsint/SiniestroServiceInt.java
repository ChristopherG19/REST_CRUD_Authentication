package com.practiced.rca.wsint;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiced.rca.dto.DtoSiniestro;
import com.practiced.rca.entity.Siniestro;

@RestController
@RequestMapping("/api/auth/siniestros")
@CrossOrigin
public interface SiniestroServiceInt {

	@GetMapping("/state/{state}")
	public List<Siniestro> searchByState(@PathVariable("state") String state);
	
	@GetMapping("/date/{date}")
	public List<Siniestro> searchByDate(@PathVariable("date") String date) throws ParseException;
	
	@GetMapping("/indem/{indem}")
	public List<Siniestro> searchByIndemnizacion(@PathVariable("indem") int indem);
	
	@GetMapping("/find/{page}/{offset}")
	public List<DtoSiniestro> findAllSiniestros(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/guardar")
	public Siniestro guardar(@RequestBody DtoSiniestro siniestro);
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteSiniestro(@PathVariable("id") int id);
}

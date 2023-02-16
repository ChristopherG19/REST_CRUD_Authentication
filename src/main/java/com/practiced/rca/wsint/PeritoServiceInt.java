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

import com.practiced.rca.dto.DtoPerito;
import com.practiced.rca.entity.Perito;

@RestController
@RequestMapping("/api/auth/peritos")
@CrossOrigin
public interface PeritoServiceInt {

	@GetMapping("/numV/{numeroVia}")
	public List<Perito> searchByNumeroVia(@PathVariable("numeroVia") int numeroVia);
	
	@GetMapping("/apellidos/{apeP}/{apeM}")
	public List<Perito> searchByApellidos(@PathVariable("apeP") String apeP, @PathVariable("apeM") String apeM);
	
	@GetMapping("/find/{page}/{offset}")
	public List<DtoPerito> findAllPeritos(@PathVariable("page") int page, @PathVariable("offset") int offset);

	@PostMapping("/guardar")
	public Perito guardar(@RequestBody DtoPerito perito);
	
	@DeleteMapping("/eliminar/{dpi}")
	public void deletePerito(@PathVariable("dpi") String dpi);
	
}

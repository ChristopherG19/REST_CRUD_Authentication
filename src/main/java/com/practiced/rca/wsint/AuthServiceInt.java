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

import com.practiced.rca.dto.DtoCliente;
import com.practiced.rca.dto.DtoCompania;
import com.practiced.rca.dto.DtoCompaniasSeguros;
import com.practiced.rca.dto.DtoPerito;
import com.practiced.rca.dto.DtoSeguro;
import com.practiced.rca.dto.DtoSiniestro;
import com.practiced.rca.entity.Cliente;
import com.practiced.rca.entity.Compania;
import com.practiced.rca.entity.CompaniasSeguros;
import com.practiced.rca.entity.Perito;
import com.practiced.rca.entity.Seguro;
import com.practiced.rca.entity.Siniestro;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public interface AuthServiceInt {

	@GetMapping("/clientes/find/{page}/{offset}")
	public List<DtoCliente> findAllUsers(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@GetMapping("/clientes/ciudad/{ciudad}")
	public List<Cliente> searchByCiudad(@PathVariable("ciudad") String ciudad);
	
	@GetMapping("/clientes/obs/{word}")
	public List<Cliente> searchByObservaciones(@PathVariable("word") String word);
	
	@GetMapping("/clientes/codeP/{codPostal}")
	public List<Cliente> searchByCodPostal(@PathVariable("codPostal") String codPostal);
	
	@PostMapping("/clientes/guardar")
	public Cliente guardar(@RequestBody DtoCliente cliente);
	
	@DeleteMapping("/clientes/eliminar/{dpi}")
	public void deleteCliente(@PathVariable("dpi") String dpi);
	
	@GetMapping("/seguros/find/{page}/{offset}")
	public List<DtoSeguro> findAllSeguros(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/seguros/guardar")
	public Seguro guardar(@RequestBody DtoSeguro seguro);
	
	@DeleteMapping("/seguros/eliminar/{id}")
	public void deleteSeguro(@PathVariable("id") int numeroPoliza);
	
	@GetMapping("/companias/notas")
	public List<Compania> searchByNotas();
	
	@GetMapping("/companias/telS/{ext}")
	public List<Compania> searchByTelefonoSini(@PathVariable("ext") String ext);
	
	@GetMapping("/companias/find/{page}/{offset}")
	public List<DtoCompania> findAllCompanias(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/companias/guardar")
	public Compania guardar(@RequestBody DtoCompania compania);
	
	@DeleteMapping("/companias/eliminar/{name}")
	public void deleteCompania(@PathVariable("name") String name);

	@GetMapping("/companiasS/find/{page}/{offset}")
	public List<DtoCompaniasSeguros> findAllCompaniasSeguros(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/companiasS/guardar")
	public CompaniasSeguros guardar(@RequestBody DtoCompaniasSeguros companiaS);
	
	@DeleteMapping("/companiasS/eliminar/{id}")
	public void deleteCompaniaS(@PathVariable("id") int id);	
	
	@GetMapping("/siniestros/state/{state}")
	public List<Siniestro> searchByState(@PathVariable("state") String state);
	
	@GetMapping("/siniestros/date/{date}")
	public List<Siniestro> searchByDate(@PathVariable("date") String date) throws ParseException;
	
	@GetMapping("/siniestros/indem/{indem}")
	public List<Siniestro> searchByIndemnizacion(@PathVariable("indem") int indem);
	
	@GetMapping("/siniestros/find/{page}/{offset}")
	public List<DtoSiniestro> findAllSiniestros(@PathVariable("page") int page, @PathVariable("offset") int offset);
	
	@PostMapping("/siniestros/guardar")
	public Siniestro guardar(@RequestBody DtoSiniestro siniestro);
	
	@DeleteMapping("/siniestros/eliminar/{id}")
	public void deleteSiniestro(@PathVariable("id") int id);


	@GetMapping("/peritos/numV/{numeroVia}")
	public List<Perito> searchByNumeroVia(@PathVariable("numeroVia") int numeroVia);
	
	@GetMapping("/peritos/apellidos/{apeP}/{apeM}")
	public List<Perito> searchByApellidos(@PathVariable("apeP") String apeP, @PathVariable("apeM") String apeM);
	
	@GetMapping("/peritos/find/{page}/{offset}")
	public List<DtoPerito> findAllPeritos(@PathVariable("page") int page, @PathVariable("offset") int offset);

	@PostMapping("/peritos/guardar")
	public Perito guardar(@RequestBody DtoPerito perito);
	
	@DeleteMapping("/peritos/eliminar/{dpi}")
	public void deletePerito(@PathVariable("dpi") String dpi);
}

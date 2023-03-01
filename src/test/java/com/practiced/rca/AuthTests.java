package com.practiced.rca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.practiced.rca.entity.Cliente;
import com.practiced.rca.entity.Compania;
import com.practiced.rca.entity.CompaniasSeguros;
import com.practiced.rca.entity.Perito;
import com.practiced.rca.entity.Seguro;
import com.practiced.rca.entity.Siniestro;
import com.practiced.rca.repository.ClienteRepository;
import com.practiced.rca.repository.CompaniaRepository;
import com.practiced.rca.repository.CompaniasSegurosRepository;
import com.practiced.rca.repository.PeritoRepository;
import com.practiced.rca.repository.SeguroRepository;
import com.practiced.rca.repository.SiniestroRepository;

@SpringBootTest
class AuthTests {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	@Autowired
	CompaniasSegurosRepository companiasSegurosRepository;
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	SiniestroRepository siniestroRepository;

	@Test
	void TestFindAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		assertNotNull(clientes, "No existen los clientes");
	}
	
	@Test
	void TestPagineoFindClientes() {
		Pageable paging = PageRequest.of(0, 10);
		
		Page<Cliente> clientes = clienteRepository.findAll(paging);
		assertEquals(10, clientes.getSize());
	}
	
	@Test
	void TestGuardarClientes() {
		Cliente cliente = new Cliente();
		cliente.setDpi("36393639101");
		cliente.setNombre("prueba");
		cliente.setApellidoP("uni");
		cliente.setApellidoM("taria");
		cliente.setClaseVia("Prueba");
		cliente.setNombreVia("unitaria");
		cliente.setNumeroVia(512);
		cliente.setCiudad("ciudad");
		cliente.setCodigoPostal("123");
		cliente.setTelefono("123456");
		cliente.setObservaciones("sin obs");
		
		clienteRepository.save(cliente);
		assertNotNull(cliente, "Persona no guardada");
		clienteRepository.delete(cliente);
	}
	
	@Test
	void TestEliminarClientes() {
		Cliente cliente = new Cliente();
		cliente.setDpi("36393639101");
		cliente.setNombre("prueba");
		cliente.setApellidoP("uni");
		cliente.setApellidoM("taria");
		cliente.setClaseVia("Prueba");
		cliente.setNombreVia("unitaria");
		cliente.setNumeroVia(512);
		cliente.setCiudad("ciudad");
		cliente.setCodigoPostal("123");
		cliente.setTelefono("123456");
		cliente.setObservaciones("sin obs");
		
		clienteRepository.save(cliente);
		clienteRepository.delete(cliente);
		assertNotNull(cliente, "Persona no eliminada");
	}
	
	@Test
	void TestFindClientesByCity() {
		List<Cliente> clientes = clienteRepository.findByCiudadContaining("Newton");
		assertNotNull(clientes, "No existen los clientes");
	}
	
	@Test
	void TestFindClientesByObservaciones() {
		List<Cliente> clientes = clienteRepository.findByObservacionesNotLike("Ninguna");
		assertThat(clientes.size(), greaterThanOrEqualTo(10));
	}
	
	@Test
	void TestFindClientesByCodPostal() {
		List<Cliente> clientes = clienteRepository.findByCodigoPostalStartingWith("180");
		assertThat(clientes.size(), equalTo(0));
	}
	
	@Test
	void TestFindAllCompanias() {
		List<Compania> companias = companiaRepository.findAll();
		assertNotNull(companias, "No existen las companias");
	}
	
	@Test
	void TestPagineoFindCompanias() {
		Pageable paging = PageRequest.of(0, 7);
		
		Page<Compania> companias = companiaRepository.findAll(paging);
		assertEquals(7, companias.getSize());
	}
	
	@Test
	void TestGuardarCompania() {
		Compania compania = new Compania();
		compania.setNombreCompania("Prueba");
		compania.setClaseVia("Unitaria");
		compania.setNumeroVia(123);
		compania.setCodigoPostal("pr");
		compania.setTelefonoContratacion("123456");
		compania.setTelefonoSiniestros("987654");
		compania.setNotas("Nada");
		
		companiaRepository.save(compania);
		assertNotNull(compania, "Compania no guardada");
		companiaRepository.delete(compania);
	}
	
	@Test
	void TestEliminarCompania() {
		Compania compania = new Compania();
		compania.setNombreCompania("Prueba");
		compania.setClaseVia("Unitaria");
		compania.setNumeroVia(123);
		compania.setCodigoPostal("pr");
		compania.setTelefonoContratacion("123456");
		compania.setTelefonoSiniestros("987654");
		compania.setNotas("Nada");
		
		companiaRepository.save(compania);
		companiaRepository.delete(compania);
		Compania companiaEliminada = companiaRepository.findByNombreCompaniaLike(compania.getNombreCompania());
		assertNull(companiaEliminada, "Compania no eliminada");
	}
	
	@Test
	void TestFindCompaniasByNotas() {
		List<Compania> companias = companiaRepository.findByNotasIsNotNull();
		assertThat(companias.size(), equalTo(1));
	}
	
	@Test
	void TestFindCompaniasByTelefonoSiniestro() {
		List<Compania> companias = companiaRepository.findByTelefonoSiniestrosStartingWith("03");
		assertNotNull(companias, "Companias no encontradas");
	}
	
	@Test
	void TestFindAllCompaniasSeguros() {
		List<CompaniasSeguros> companiasSeguros = companiasSegurosRepository.findAll();
		assertNotNull(companiasSeguros, "No existen las companias y seguros");
	}
	
	@Test
	void TestPagineoFindCompaniasSeguros() {
		Pageable paging = PageRequest.of(0, 3);
		
		Page<CompaniasSeguros> companiasSeguros = companiasSegurosRepository.findAll(paging);
		assertEquals(3, companiasSeguros.getSize());
	}
	
	@Test
	void TestGuardarCompaniaSeguros() {
		CompaniasSeguros companiaSeguros = new CompaniasSeguros();
		companiaSeguros.setNombreCompania("Abata");
		companiaSeguros.setNumeroPoliza(1);
		
		companiasSegurosRepository.save(companiaSeguros);
		assertNotNull(companiaSeguros, "CompaniaSeguros no guardada");
		companiasSegurosRepository.delete(companiaSeguros);
	}
	
	@Test
	void TestEliminarCompaniaSeguros() {
		CompaniasSeguros companiaSeguros = new CompaniasSeguros();
		companiaSeguros.setNombreCompania("Abata");
		companiaSeguros.setNumeroPoliza(1);
		
		companiasSegurosRepository.save(companiaSeguros);
		companiasSegurosRepository.delete(companiaSeguros);
		assertNotNull(companiaSeguros, "CompaniaSeguros no eliminada");
	}
	
	@Test
	void TestFindAllPeritos() {
		List<Perito> peritos = peritoRepository.findAll();
		assertNotNull(peritos, "No existen los peritos");
	}
	
	@Test
	void TestPagineoFindPeritos() {
		Pageable paging = PageRequest.of(0, 6);
		
		Page<Perito> peritos = peritoRepository.findAll(paging);
		assertEquals(6, peritos.getSize());
	}
	
	@Test
	void TestGuardarPerito() {
		Perito perito = new Perito();
		perito.setDpiPerito("36393639101");
		perito.setNombrePerito("prueba");
		perito.setApellidoP("uni");
		perito.setApellidoM("taria");
		perito.setTelefonoContacto("123456");
		perito.setTelefonoOficina("12345678");
		perito.setClaseVia("Prueba");
		perito.setNombreVia("unitaria");
		perito.setNumeroVia(512);
		perito.setCodigoPostal("123");
		perito.setCiudad("ciudad");
		
		peritoRepository.save(perito);
		assertNotNull(perito, "Perito no guardado");
		peritoRepository.delete(perito);
	}
	
	@Test
	void TestEliminarPerito() {
		Perito perito = new Perito();
		perito.setDpiPerito("36393639101");
		perito.setNombrePerito("prueba");
		perito.setApellidoP("uni");
		perito.setApellidoM("taria");
		perito.setTelefonoContacto("123456");
		perito.setTelefonoOficina("12345678");
		perito.setClaseVia("Prueba");
		perito.setNombreVia("unitaria");
		perito.setNumeroVia(512);
		perito.setCodigoPostal("123");
		perito.setCiudad("ciudad");
		
		peritoRepository.save(perito);
		peritoRepository.delete(perito);
		Perito peritoEliminado = peritoRepository.findByDpiPeritoLike(perito.getDpiPerito());
		assertNull(peritoEliminado, "Perito no eliminado");
	}
	
	@Test
	void TestFindAllPeritosByNumeroVia() {
		List<Perito> peritos = peritoRepository.findByNumeroViaGreaterThan(50000);
		assertNotNull(peritos, "Peritos no encontrados");
	}
	
	@Test
	void TestFindAllPeritosByApellidos() {
		List<Perito> peritos = peritoRepository.findByApellidoPAndApellidoM("Prueba", "Unitaria");
		assertTrue(peritos.isEmpty());
	}
	
	@Test
	void TestFindAllSeguros() {
		List<Seguro> seguros = seguroRepository.findAll();
		assertNotNull(seguros, "No existen los peritos");
	}
	
	@Test
	void TestPagineoFindSeguros() {
		Pageable paging = PageRequest.of(0, 1);
		
		Page<Seguro> seguros = seguroRepository.findAll(paging);
		assertEquals(1, seguros.getSize());
	}
	
	@Test
	void TestGuardarSeguro() {
		Seguro seguro = new Seguro();
		seguro.setRamo("prueba");
		seguro.setFechaInicio(new Date());
		seguro.setFechaVencimiento(new Date());
		seguro.setCondicionesParticulares("No");
		seguro.setObservaciones("No");
		seguro.setDpi("4732828507");

		seguroRepository.save(seguro);
		assertNotNull(seguro, "Seguro no guardado");
		seguroRepository.delete(seguro);
	}
	
	@Test
	void TestEliminarSeguro() {
		Seguro seguro = new Seguro();
		seguro.setRamo("prueba");
		seguro.setFechaInicio(new Date());
		seguro.setFechaVencimiento(new Date());
		seguro.setCondicionesParticulares("No");
		seguro.setObservaciones("No");
		seguro.setDpi("4732828507");

		seguroRepository.save(seguro);
		seguroRepository.delete(seguro);
		assertNotNull(seguro, "Seguro no eliminado");
	}
	
	@Test
	void TestFindAllSiniestros() {
		List<Siniestro> siniestros = siniestroRepository.findAll();
		assertNotNull(siniestros, "No existen los siniestros");
	}
	
	@Test
	void TestPagineoFindSiniestros() {
		Pageable paging = PageRequest.of(0, 2);
		
		Page<Siniestro> siniestros = siniestroRepository.findAll(paging);
		assertEquals(2, siniestros.getSize());
	}
	
	@Test
	void TestGuardarSiniestro() {
		Siniestro siniestro = new Siniestro();
		siniestro.setFechaSiniestro(new Date());
		siniestro.setCausas("nono");
		siniestro.setAceptado("Y");
		siniestro.setIndemnizacion(123456);
		siniestro.setNumeroPoliza(1);

		siniestroRepository.save(siniestro);
		assertNotNull(siniestro, "Siniestro no guardado");
		siniestroRepository.delete(siniestro);
	}
	
	@Test
	void TestEliminarSiniestro() {
		Siniestro siniestro = new Siniestro();
		siniestro.setFechaSiniestro(new Date());
		siniestro.setCausas("nono");
		siniestro.setAceptado("Y");
		siniestro.setIndemnizacion(123456);
		siniestro.setNumeroPoliza(1);

		siniestroRepository.save(siniestro);
		siniestroRepository.delete(siniestro);
		assertNotNull(siniestro, "Siniestro no eliminado");
	}
	
	@Test
	void TestFindAllSiniestrosByState() {
		List<Siniestro> siniestros = siniestroRepository.findByAceptadoLike("Y");
		assertNotNull(siniestros, "No existen los siniestros");
	}
	
	@Test
	void TestFindAllSiniestrosByDate() {
		List<Siniestro> siniestros = siniestroRepository.findByFechaSiniestroAfter(new Date());
		assertTrue(siniestros.isEmpty());
	}
	
	@Test
	void TestFindAllSiniestrosByIndemnizacion() {
		List<Siniestro> siniestros = siniestroRepository.findByIndemnizacionLessThan(1000000);
		assertNotNull(siniestros, "No existen los siniestros");
	}
}

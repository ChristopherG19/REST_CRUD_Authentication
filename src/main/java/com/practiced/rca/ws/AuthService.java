package com.practiced.rca.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
import com.practiced.rca.repository.ClienteRepository;
import com.practiced.rca.repository.CompaniaRepository;
import com.practiced.rca.repository.CompaniasSegurosRepository;
import com.practiced.rca.repository.PeritoRepository;
import com.practiced.rca.repository.SeguroRepository;
import com.practiced.rca.repository.SiniestroRepository;
import com.practiced.rca.wsint.AuthServiceInt;

@Component
public class AuthService implements AuthServiceInt{

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
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<DtoCliente> findAllUsers(int page, int offset) {

		Pageable paging = PageRequest.of(page, offset);
		
		Page<Cliente> clientes = clienteRepository.findAll(paging);
	
		return clientes.stream().map(cliente -> {
			DtoCliente dtoCliente = new DtoCliente();
			dtoCliente.setDpi(cliente.getDniCl());
			dtoCliente.setNombre(cliente.getNombreCl());
			dtoCliente.setApellidoP(cliente.getApellido1());
			dtoCliente.setApellidoM(cliente.getApellido2());
			dtoCliente.setClaseVia(cliente.getClaseVia());
			dtoCliente.setNombreVia(cliente.getNombreVia());
			dtoCliente.setNumeroVia(cliente.getNumeroVia());
			dtoCliente.setCiudad(cliente.getCiudad());
			dtoCliente.setCodigoPostal(cliente.getCodPostal());
			dtoCliente.setTelefono(cliente.getTelefono());
			dtoCliente.setObservaciones(cliente.getObservaciones());
			return dtoCliente;
		}).toList();
	}
	
	@Override
	public Cliente guardar(DtoCliente cliente) {
		Cliente nuevoCliente = modelMapper.map(cliente, Cliente.class);
		return clienteRepository.save(nuevoCliente);
	}
	
	@Override
	public void deleteCliente(String dpi) {
		Optional<Cliente> cliente = clienteRepository.findById(dpi);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	@Override
	public List<Cliente> searchByCiudad(String city) {
		return clienteRepository.findByCiudadContaining(city);
	}

	@Override
	public List<Cliente> searchByObservaciones(String word) {
		return clienteRepository.findByObservacionesNotLike(word);
	}

	@Override
	public List<Cliente> searchByCodPostal(String codPostal) {
		return clienteRepository.findByCodPostalStartingWith(codPostal);
	}
	
	
	@Override
	public List<DtoCompania> findAllCompanias(int page, int offset) {
		
		Pageable paging = PageRequest.of(page, offset);
		
		Page<Compania> companias = companiaRepository.findAll(paging);
	
		return companias.stream().map(compania -> {
			DtoCompania dtoCompania = new DtoCompania();
			dtoCompania.setNombreCompania(compania.getNombreCompania());
			dtoCompania.setClaseVia(compania.getClaseVia());
			dtoCompania.setNombreVia(compania.getNombreVia());
			dtoCompania.setNumeroVia(compania.getNumeroVia());
			dtoCompania.setCodigoPostal(compania.getCodPostal());
			dtoCompania.setTelefonoContratacion(compania.getTelefonoContratacion());
			dtoCompania.setTelefonoSiniestros(compania.getTelefonoSiniestros());
			dtoCompania.setNotas(compania.getNotas());
			return dtoCompania;
		}).toList();
	}
	
	@Override
	public Compania guardar(DtoCompania compania) {
		Compania nuevaCompania = modelMapper.map(compania, Compania.class);
		return companiaRepository.save(nuevaCompania);
	}	
	
	@Override
	public void deleteCompania(String name) {
		Compania compania = companiaRepository.findByNombreCompaniaLike(name);
		if (compania != null) {
			companiaRepository.delete(compania);
		}
	}
	
	@Override
	public List<Compania> searchByNotas() {
		return companiaRepository.findByNotasIsNotNull();
	}

	@Override
	public List<Compania> searchByTelefonoSini(String ext) {
		return companiaRepository.findByTelefonoSiniestrosStartingWith(ext);
	}
	
	
	@Override
	public List<DtoCompaniasSeguros> findAllCompaniasSeguros(int page, int offset) {
		
		Pageable paging = PageRequest.of(page, offset);
		
		Page<CompaniasSeguros> companiasS = companiasSegurosRepository.findAll(paging);
	
		return companiasS.stream().map(companiaS -> {
			DtoCompaniasSeguros dtoCompaniaS = new DtoCompaniasSeguros();
			dtoCompaniaS.setId(companiaS.getId());
			dtoCompaniaS.setNumeroPoliza(companiaS.getNumeroPoliza());
			dtoCompaniaS.setNombreCompania(companiaS.getNombreCompania());
			return dtoCompaniaS;
		}).toList();
	}
	
	@Override
	public CompaniasSeguros guardar(DtoCompaniasSeguros companiaS) {
		CompaniasSeguros nuevaCompaniaS = modelMapper.map(companiaS, CompaniasSeguros.class);
		return companiasSegurosRepository.save(nuevaCompaniaS);
	}
	
	@Override
	public void deleteCompaniaS(int id) {
		Optional<CompaniasSeguros> companiaS = companiasSegurosRepository.findById(id);
		if (companiaS.isPresent()) {
			companiasSegurosRepository.delete(companiaS.get());
		}
	}
	
	
	@Override
	public List<DtoPerito> findAllPeritos(int page, int offset) {
		Pageable paging = PageRequest.of(page, offset);
		
		Page<Perito> peritos = peritoRepository.findAll(paging);
	
		return peritos.stream().map(perito -> {
			DtoPerito dtoPerito = new DtoPerito();
			dtoPerito.setDpiPerito(perito.getDniPerito());
			dtoPerito.setNombrePerito(perito.getNombrePerito());
			dtoPerito.setApellidoP(perito.getApellidoPerito1());
			dtoPerito.setApellidoM(perito.getApellidoPerito2());
			dtoPerito.setTelefonoContacto(perito.getTelefonoContacto());
			dtoPerito.setTelefonoOficina(perito.getTelefonoOficina());
			dtoPerito.setClaseVia(perito.getClaseVia());
			dtoPerito.setNombreVia(perito.getNombreVia());
			dtoPerito.setNumeroVia(perito.getNumeroVia());
			dtoPerito.setCodigoPostal(perito.getCodPostal());
			dtoPerito.setCiudad(perito.getCiudad());
			return dtoPerito;
		}).toList();
	}

	@Override
	public Perito guardar(DtoPerito perito) {
		Perito nuevoPerito = modelMapper.map(perito, Perito.class);
		return peritoRepository.save(nuevoPerito);
	}
	
	@Override
	public void deletePerito(String dpi) {
		Perito perito = peritoRepository.findByDniPeritoLike(dpi);
		if (perito != null) {
			peritoRepository.delete(perito);
		}
	}

	@Override
	public List<Perito> searchByNumeroVia(int numeroVia) {
		return peritoRepository.findByNumeroViaGreaterThan(numeroVia);
	}
	
	@Override
	public List<Perito> searchByApellidos(String apeP, String apeM) {
		return peritoRepository.findByApellidoPerito1AndApellidoPerito2(apeP, apeM);
	}
	
	
	@Override
	public List<DtoSeguro> findAllSeguros(int page, int offset) {
		Pageable paging = PageRequest.of(page, offset);
		
		Page<Seguro> seguros = seguroRepository.findAll(paging);
	
		return seguros.stream().map(seguro -> {
			DtoSeguro dtoSeguro = new DtoSeguro();
			dtoSeguro.setNumeroPoliza(seguro.getNumeroPoliza());
			dtoSeguro.setRamo(seguro.getRamo());
			dtoSeguro.setFechaInicio(seguro.getFechaInicio());
			dtoSeguro.setFechaVencimiento(seguro.getFechaVencimiento());
			dtoSeguro.setCondicionesParticulares(seguro.getCondicionesParticulares());
			dtoSeguro.setObservaciones(seguro.getObservaciones());
			dtoSeguro.setDpi(seguro.getDpi());
			return dtoSeguro;
		}).toList();
	}
	
	@Override
	public Seguro guardar(DtoSeguro seguro) {
		Seguro nuevoSeguro = modelMapper.map(seguro, Seguro.class);
		return seguroRepository.save(nuevoSeguro);
	}
	
	@Override
	public void deleteSeguro(int numeroPoliza) {
		Optional<Seguro> seguro = seguroRepository.findById(numeroPoliza);
		if (seguro.isPresent()) {
			seguroRepository.delete(seguro.get());
		}
	}
	
	
	@Override
	public List<DtoSiniestro> findAllSiniestros(int page, int offset) {
		Pageable paging = PageRequest.of(page, offset);
		
		Page<Siniestro> siniestros = siniestroRepository.findAll(paging);
	
		return siniestros.stream().map(siniestro -> {
			DtoSiniestro dtoSiniestro = new DtoSiniestro();
			dtoSiniestro.setIdSiniestro(siniestro.getIdSiniestro());
			dtoSiniestro.setFechaSiniestro(siniestro.getFechaSiniestro());
			dtoSiniestro.setCausas(siniestro.getCausas());
			dtoSiniestro.setAceptado(siniestro.getAceptado());
			dtoSiniestro.setIndemnizacion(siniestro.getIndemnizacion());
			dtoSiniestro.setNumeroPoliza(siniestro.getNumeroPoliza());
			dtoSiniestro.setPerito(siniestro.getPerito());
			return dtoSiniestro;
		}).toList();
	}
	
	@Override
	public Siniestro guardar(DtoSiniestro siniestro) {
		Perito perito = peritoRepository.findByDniPeritoLike(siniestro.getPerito().getDniPerito());
		Siniestro nuevoSiniestro = modelMapper.map(siniestro, Siniestro.class);
		nuevoSiniestro.setPerito(perito);
		return siniestroRepository.save(nuevoSiniestro);
	}

	@Override
	public void deleteSiniestro(int id) {
		Optional<Siniestro> siniestro = siniestroRepository.findById(id);
		if (siniestro.isPresent()) {
			siniestroRepository.delete(siniestro.get());
		}
	}
	
	@Override
	public List<Siniestro> searchByState(String state) {
		return siniestroRepository.findByAceptadoLike(state);
	}

	@Override
	public List<Siniestro> searchByDate(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date ndate = dateFormat.parse(date);
		
		return siniestroRepository.findByFechaSiniestroAfter(ndate);
	}

	@Override
	public List<Siniestro> searchByIndemnizacion(int indem) {
		return siniestroRepository.findByIndemnizacionLessThan(indem);
	}
}

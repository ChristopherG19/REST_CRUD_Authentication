package com.practiced.rca.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.practiced.rca.dto.DtoCliente;
import com.practiced.rca.entity.Cliente;
import com.practiced.rca.repository.ClienteRepository;
import com.practiced.rca.wsint.ClienteServiceInt;

@Component
public class ClienteService implements ClienteServiceInt{

	@Autowired
	ClienteRepository clienteRepository;
	
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
	
	
	
}

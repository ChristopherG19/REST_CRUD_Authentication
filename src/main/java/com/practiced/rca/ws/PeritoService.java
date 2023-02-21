package com.practiced.rca.ws;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.practiced.rca.dto.DtoPerito;
import com.practiced.rca.entity.Perito;
import com.practiced.rca.repository.PeritoRepository;
import com.practiced.rca.wsint.PeritoServiceInt;

public class PeritoService implements PeritoServiceInt{

	@Autowired
	PeritoRepository peritoRepository;

	private ModelMapper modelMapper = new ModelMapper();
	
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
}

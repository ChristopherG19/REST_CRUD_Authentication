package com.practiced.rca.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.practiced.rca.dto.DtoSeguro;
import com.practiced.rca.entity.Seguro;
import com.practiced.rca.repository.SeguroRepository;
import com.practiced.rca.wsint.SeguroServiceInt;

public class SeguroService implements SeguroServiceInt{

	@Autowired
	SeguroRepository seguroRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
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
	
}

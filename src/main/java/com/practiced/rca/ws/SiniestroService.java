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

import com.practiced.rca.dto.DtoSiniestro;
import com.practiced.rca.entity.Perito;
import com.practiced.rca.entity.Siniestro;
import com.practiced.rca.repository.PeritoRepository;
import com.practiced.rca.repository.SiniestroRepository;
import com.practiced.rca.wsint.SiniestroServiceInt;

public class SiniestroService implements SiniestroServiceInt{

	@Autowired
	SiniestroRepository siniestroRepository;
	
	@Autowired
	PeritoRepository peritoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
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
		Perito perito = peritoRepository.findByDpiPeritoLike(siniestro.getPerito().getDpiPerito());
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

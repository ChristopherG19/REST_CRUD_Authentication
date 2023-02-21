package com.practiced.rca.ws;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.practiced.rca.dto.DtoCompania;
import com.practiced.rca.entity.Compania;
import com.practiced.rca.repository.CompaniaRepository;
import com.practiced.rca.wsint.CompaniaServiceInt;

public class CompaniaService implements CompaniaServiceInt{

	@Autowired
	CompaniaRepository companiaRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
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
	
}

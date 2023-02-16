package com.practiced.rca.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.practiced.rca.dto.DtoCompaniasSeguros;
import com.practiced.rca.entity.CompaniasSeguros;
import com.practiced.rca.repository.CompaniasSegurosRepository;
import com.practiced.rca.wsint.CompaniasSegurosServiceInt;

public class CompaniasSegurosService implements CompaniasSegurosServiceInt{

	@Autowired
	CompaniasSegurosRepository companiasSegurosRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
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
	
}

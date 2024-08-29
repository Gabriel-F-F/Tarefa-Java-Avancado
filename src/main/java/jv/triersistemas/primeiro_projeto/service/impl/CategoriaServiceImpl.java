package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<CategoriaDto> getCategorias() {
		List<CategoriaEntity> getCategorias = categoriaRepository.findAll();
		return getCategorias.stream().map(CategoriaDto::new).toList();
	}
	
	@Override
	public Optional<CategoriaDto> getCategoriaPorId(Long id) {
		Optional<CategoriaEntity> getCategoriaPorId = categoriaRepository.findById(id);
		return getCategoriaPorId.stream().map(CategoriaDto::new).findFirst();
	}
	
	@Override
	public Optional<CategoriaDto> getCategoriaPorNome(String nome) {
		Optional<CategoriaEntity> getCategoriaPorNome = categoriaRepository.findByNome(nome);
		return getCategoriaPorNome.stream().map(CategoriaDto::new).findFirst();
	}
	
	@Override
	public CategoriaDto postCategoria(CategoriaDto categoriaRequest) {
		CategoriaEntity categoriaAdicionada = categoriaRepository.save(new CategoriaEntity(categoriaRequest));
		return new CategoriaDto(categoriaAdicionada);
	}
	
	@Override
	public CategoriaDto putCategoria(Long id, CategoriaDto categoriaRequest) {
		Optional<CategoriaEntity> categoriaAtualizada = categoriaRepository.findById(id);
		
		if(categoriaAtualizada.isPresent()) {
			CategoriaEntity categoria = categoriaAtualizada.get();
			categoria.setNome(categoriaRequest.getNome());
			categoria.setDescricao(categoriaRequest.getDescricao());
			categoria.setPrioridade(categoriaRequest.getPrioridade());
			categoriaRepository.save(categoria);
			return new CategoriaDto(categoria);
		}
		return null;
	}
	
	@Override
	public void deleteCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}
}
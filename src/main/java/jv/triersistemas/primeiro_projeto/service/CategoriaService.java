package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;

public interface CategoriaService {

	List<CategoriaDto> getCategorias();
	
	Optional<CategoriaDto> getCategoriaPorId(Long id);
	
	Optional<CategoriaDto> getCategoriaPorNome(String nome);
	
	CategoriaDto postCategoria(CategoriaDto categoriaRequest);
	
	CategoriaDto putCategoria(Long id, CategoriaDto categoriaRequest);
	
	void deleteCategoria(Long id);
}
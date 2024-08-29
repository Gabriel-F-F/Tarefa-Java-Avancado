package jv.triersistemas.primeiro_projeto.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;

public interface TarefaService {
	
	List<TarefaDto> getTarefas();
	
	Optional<TarefaDto> getTarefaPorId(Long id);
	
	TarefaDto putTarefa(Long id, TarefaDto tarefaRequest);

	TarefaDto postTarefa(TarefaDto tarefaRequest, CategoriaEntity id);
	
	void deleteTarefa(Long id);
		
}
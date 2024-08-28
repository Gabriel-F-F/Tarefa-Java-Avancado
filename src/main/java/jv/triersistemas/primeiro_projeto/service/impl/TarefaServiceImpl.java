package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	private static List<TarefaDto> listaTarefa = new ArrayList<>();
	private static Long contador = 1L;

	@Override
	public List<TarefaDto> getTarefa() {
		return listaTarefa;
	}

	@Override
	public Optional<TarefaDto> getTarefaPorId(Long id) {
		return listaTarefa.stream().filter(tarefa -> tarefa.getId().equals(id)).findFirst();
	}

	@Override
	public TarefaDto postTarefa(TarefaDto tarefaRequest) {
		TarefaEntity entidadePersistida = tarefaRepository.save(new TarefaEntity(tarefaRequest));
		return new TarefaDto(entidadePersistida);
		
//		tarefaRequest.setId(contador++);
//		listaTarefa.add(tarefaRequest);
//		return tarefaRequest;
	}

	@Override
	public TarefaDto putTarefa(Long id, TarefaDto tarefaRequest) {
		Optional<TarefaDto> tarefaUpdate = listaTarefa.stream().filter(tarefa -> tarefa.getId().equals(id)).findFirst();

		if (tarefaUpdate.isPresent()) {
			TarefaDto tarefa = tarefaUpdate.get();
			tarefa.setTitulo(tarefaRequest.getTitulo());
			tarefa.setDescricao(tarefaRequest.getDescricao());
			tarefa.setCompleta(tarefaRequest.getCompleta());
			return tarefa;
		}
		return null;
	}

	@Override
	public void deleteTarefa(Long id) {
		listaTarefa.removeIf(tarefa -> tarefa.getId().equals(id));
	}
}
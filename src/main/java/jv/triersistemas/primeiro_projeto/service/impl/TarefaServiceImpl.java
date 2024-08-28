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

	List<TarefaDto> listaTarefa = new ArrayList<>();
	
	@Autowired
	private TarefaRepository tarefaRepository;

	@Override
	public List<TarefaDto> getTarefa() {
		List<TarefaEntity> getTodasTarefa = tarefaRepository.findAll();
		return getTodasTarefa.stream().map(TarefaDto::new).toList();
	}

	@Override
	public Optional<TarefaDto> getTarefaPorId(Long id) {
		Optional<TarefaEntity> getTarefaPorId = tarefaRepository.findById(id);
		return getTarefaPorId.stream().map(TarefaDto::new).findFirst();
	}

	@Override
	public TarefaDto postTarefa(TarefaDto tarefaRequest) {
		TarefaEntity entidadePersistida = tarefaRepository.save(new TarefaEntity(tarefaRequest));
		return new TarefaDto(entidadePersistida);
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
		tarefaRepository.deleteById(id);
	}
}
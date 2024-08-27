package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public List<TarefaDto> getTarefas() {
		return tarefaService.getTarefa();
	}

	@GetMapping("/{id}")
	public Optional<TarefaDto> getTarefaPorId(@PathVariable Long id) {
		return tarefaService.getTarefaPorId(id);
	}

	@PostMapping
	public void postTarefa(@RequestBody TarefaDto tarefaRequest) {
		tarefaService.postTarefa(tarefaRequest);
	}

	@PutMapping("/{id}")
	public TarefaDto putTarefa(@PathVariable Long id, @RequestBody TarefaDto tarefaRequest) {
		return tarefaService.putTarefa(id, tarefaRequest);
	}

	@DeleteMapping("/{id}")
	public void deleteTarefa(@PathVariable Long id) {
		tarefaService.deleteTarefa(id);
	}
}
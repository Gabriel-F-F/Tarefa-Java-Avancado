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

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDto> getCategorias() {
		return categoriaService.getCategorias();
	}
	
	@GetMapping("/id/{id}")
	public Optional<CategoriaDto> getCategoriaPorId(@PathVariable Long id) {
		return categoriaService.getCategoriaPorId(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Optional<CategoriaDto> getCategoriaPorNome(@PathVariable String nome) {
		return categoriaService.getCategoriaPorNome(nome);
	}
	
	@PostMapping
	public void postCategoria(@RequestBody CategoriaDto categoriaRequest) {
		categoriaService.postCategoria(categoriaRequest);
	}
	
	@PutMapping("/{id}")
	public CategoriaDto putCategoria(@PathVariable Long id, @RequestBody CategoriaDto categoriaRequest) {
		return categoriaService.putCategoria(id, categoriaRequest);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		categoriaService.deleteCategoria(id);
	}
}
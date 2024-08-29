package jv.triersistemas.primeiro_projeto.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {

//	List<TarefaEntity> findAllByCategoriaNome(String nome);

//	List<TarefaEntity> fingAllByTituloAndCompletaOrderByIdAsc(String titulo, Boolean completa);
	
}
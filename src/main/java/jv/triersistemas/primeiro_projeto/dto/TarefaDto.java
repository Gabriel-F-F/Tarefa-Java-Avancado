package jv.triersistemas.primeiro_projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaDto {
		private Long id;
		private String titulo;
		private String descricao;
		private Boolean completa;
}
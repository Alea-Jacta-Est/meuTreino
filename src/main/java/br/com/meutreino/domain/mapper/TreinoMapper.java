package br.com.meutreino.domain.mapper;

import br.com.meutreino.domain.Treino;
import br.com.meutreino.domain.dto.TreinoDTO;

public class TreinoMapper {

	
	private TreinoMapper() {
		throw new IllegalStateException("Classe utilitária");
	}

	public static Treino converterTO(TreinoDTO to) {
		Treino treino = new Treino();
		treino.setIdAluno(to.getIdAluno());
		treino.setIdPlanejamento(to.getIdPlanejamento());
		treino.setIdTreino(to.getIdTreino());		
		treino.setDataEnvio(to.getDataEnvio());
		treino.setDataFim(to.getDataFim());
		treino.setDataInicio(to.getDataInicio());
		treino.setTipo(to.getTipo());		
		
		return treino;
	}
	
	public static TreinoDTO converterEntity(Treino treino) {
		TreinoDTO to = new TreinoDTO();
		to.setIdAluno(treino.getIdAluno());
		to.setIdPlanejamento(treino.getIdPlanejamento());
		to.setIdTreino(treino.getIdTreino());
		to.setDataEnvio(treino.getDataEnvio());
		to.setDataFim(treino.getDataFim());
		to.setDataInicio(treino.getDataInicio());
		to.setTipo(treino.getTipo());	
		
		return to;
	}
}

package br.com.meutreino.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.Treino;
import br.com.meutreino.domain.compositeKey.TreinoCompositeKey;

public interface TreinoRepository extends JpaRepository<Treino, TreinoCompositeKey> {
	
	public Optional<Treino> findByIdTreino(Long idTreino);
	
	public List<Treino> findByIdAluno(Long id);
	
	@Transactional
	public void deleteByIdTreinoAndIdAlunoAndIdPlanejamento(Long idTreino, Long idAluno, Long idPlanejamento);
	
}

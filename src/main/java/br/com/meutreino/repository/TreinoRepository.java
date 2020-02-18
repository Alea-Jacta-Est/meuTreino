package br.com.meutreino.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.meutreino.domain.Treino;
import br.com.meutreino.domain.compositeKey.TreinoCompositeKey;

public interface TreinoRepository extends CrudRepository<Treino, TreinoCompositeKey> {

}

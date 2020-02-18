package br.com.meutreino.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.meutreino.domain.TreinoAgenda;
import br.com.meutreino.domain.compositeKey.TreinoAgendaCompositeKey;

public interface TreinoAgendaRepository extends CrudRepository<TreinoAgenda, TreinoAgendaCompositeKey> {

}

package br.com.meutreino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meutreino.domain.TreinoAgenda;
import br.com.meutreino.domain.compositeKey.TreinoAgendaCompositeKey;

public interface TreinoAgendaRepository extends JpaRepository<TreinoAgenda, TreinoAgendaCompositeKey> {

}

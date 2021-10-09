package br.com.lucasfuck.neo4j.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lucasfuck.neo4j.domain.nodes.ProgramacaoFerias;

@Repository
public interface ProgramacaoFeriasRepository extends Neo4jRepository<ProgramacaoFerias, Long> {

	@Query("MATCH (pf:ProgramacaoFerias) where date(pf.dataInicio) <= date({dataFim}) and date(pf.dataFim) >= date({dataInicio}) return pf")
	List<ProgramacaoFerias> findByPeriodo(@Param("dataInicio") LocalDate dataInicial,
			@Param("dataFim") LocalDate dataFinal);

}

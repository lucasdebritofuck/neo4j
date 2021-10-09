package br.com.lucasfuck.neo4j.repositories;

import br.com.lucasfuck.neo4j.domain.nodes.RegraGlobal;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraGlobalRepository extends Neo4jRepository<RegraGlobal, Long> {

	RegraGlobal findByCodigo(String string);

}

package br.com.lucasfuck.neo4j.repositories;

import br.com.lucasfuck.neo4j.domain.nodes.Colaborador;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends Neo4jRepository<Colaborador, Long> {

	Colaborador findByNome(String string);

}

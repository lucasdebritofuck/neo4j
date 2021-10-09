package br.com.lucasfuck.neo4j.repositories;

import br.com.lucasfuck.neo4j.domain.nodes.Equipe;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends Neo4jRepository<Equipe, Long> {

}

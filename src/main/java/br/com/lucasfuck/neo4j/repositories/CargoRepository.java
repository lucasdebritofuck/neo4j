package br.com.lucasfuck.neo4j.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasfuck.neo4j.domain.nodes.Cargo;

@Repository
public interface CargoRepository extends Neo4jRepository<Cargo, Long> {

}

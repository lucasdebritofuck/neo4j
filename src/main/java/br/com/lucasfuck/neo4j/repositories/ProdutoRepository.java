package br.com.lucasfuck.neo4j.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasfuck.neo4j.domain.nodes.Produto;

@Repository
public interface ProdutoRepository extends Neo4jRepository<Produto, Long> {

}

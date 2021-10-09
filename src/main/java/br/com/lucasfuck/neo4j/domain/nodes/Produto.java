package br.com.lucasfuck.neo4j.domain.nodes;

import java.util.List;

import br.com.lucasfuck.neo4j.domain.AbstractNodeEntity;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity("Produto")
public class Produto extends AbstractNodeEntity {

	private String nome;

	@Relationship(type = "ATUA_EM", direction = Relationship.INCOMING)
	private List<Colaborador> colaboradoresAtuantes;

	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

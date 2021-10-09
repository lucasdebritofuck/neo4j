package br.com.lucasfuck.neo4j.domain.nodes;

import br.com.lucasfuck.neo4j.domain.AbstractNodeEntity;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity("Cargo")
public class Cargo extends AbstractNodeEntity {

	private String nome;

	public Cargo() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

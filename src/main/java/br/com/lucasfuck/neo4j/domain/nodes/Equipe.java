package br.com.lucasfuck.neo4j.domain.nodes;

import java.util.ArrayList;
import java.util.List;

import br.com.lucasfuck.neo4j.domain.AbstractNodeEntity;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity("Equipe")
public class Equipe extends AbstractNodeEntity {

	private String nome;

	@Relationship(type = "DESENVOLVIDO_EM", direction = Relationship.INCOMING)
	private List<Produto> produtosDesenvolvidos;

	public Equipe() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void produtosDesenvolvidos(Produto produto) {
		if (produtosDesenvolvidos == null) {
			produtosDesenvolvidos = new ArrayList<>();
		}

		produtosDesenvolvidos.add(produto);
	}

}

package br.com.lucasfuck.neo4j.domain.nodes;

import java.util.ArrayList;
import java.util.List;

import br.com.lucasfuck.neo4j.domain.AbstractRule;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity("RegraGlobal")
public class RegraGlobal extends AbstractRule {

	private String codigo;

	private String nome;

	@Relationship(type = "RESTRINGIDO_POR", direction = Relationship.INCOMING)
	private List<Colaborador> colaboradoresRestringidos;

	public RegraGlobal() {
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void colaboradoresRestringidos(Colaborador colaborador) {
		if (colaboradoresRestringidos == null) {
			colaboradoresRestringidos = new ArrayList<>();
		}

		colaboradoresRestringidos.add(colaborador);
	}
}

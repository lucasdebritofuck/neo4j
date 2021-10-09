package br.com.lucasfuck.neo4j.domain.nodes;

import java.util.ArrayList;
import java.util.List;

import br.com.lucasfuck.neo4j.domain.AbstractNodeEntity;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity("Colaborador")
public class Colaborador extends AbstractNodeEntity {

	private String nome;

	@Relationship(type = "ATUA_EM", direction = Relationship.OUTGOING)
	private List<Produto> produtos;

	@Relationship(type = "ATUA_COMO", direction = Relationship.OUTGOING)
	private List<Cargo> cargos;

	@Relationship(type = "RESTRINGIDO_POR", direction = Relationship.OUTGOING)
	private List<RegraGlobal> regrasGlobais;

	@Relationship(type = "AGENDADA_POR", direction = Relationship.INCOMING)
	private List<ProgramacaoFerias> feriasProgramadas;

	public Colaborador() {
	}

	public void atuaEm(Produto produto) {
		if (produtos == null) {
			produtos = new ArrayList<>();
		}

		produtos.add(produto);
	}

	public void atuaComo(Cargo cargo) {
		if (cargos == null) {
			cargos = new ArrayList<>();
		}

		cargos.add(cargo);
	}

	public void restringidoPorRegraGlobal(RegraGlobal regraGlobal) {
		if (regrasGlobais == null) {
			regrasGlobais = new ArrayList<>();
		}

		regrasGlobais.add(regraGlobal);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

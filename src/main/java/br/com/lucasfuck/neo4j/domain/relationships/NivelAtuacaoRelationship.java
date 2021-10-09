package br.com.lucasfuck.neo4j.domain.relationships;

import br.com.lucasfuck.neo4j.domain.nodes.Cargo;
import br.com.lucasfuck.neo4j.domain.nodes.Colaborador;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ATUA_COMO")
public class NivelAtuacaoRelationship {

	@Id
	@GeneratedValue
	private Long id;

	private Long nivel;

	@StartNode
    Colaborador colaborador;

	@EndNode
    Cargo cargo;

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

}

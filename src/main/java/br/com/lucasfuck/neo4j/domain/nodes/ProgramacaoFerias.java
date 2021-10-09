package br.com.lucasfuck.neo4j.domain.nodes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.lucasfuck.neo4j.domain.AbstractNodeEntity;
import br.com.lucasfuck.neo4j.domain.converters.DateLocalDateConverter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

@NodeEntity("ProgramacaoFerias")
public class ProgramacaoFerias extends AbstractNodeEntity {

	@Convert(DateLocalDateConverter.class)
	private LocalDate dataInicio;

	@Convert(DateLocalDateConverter.class)
	private LocalDate dataFim;

	private Long diasFerias;

	@Relationship(type = "AGENDADA_POR", direction = Relationship.OUTGOING)
	private Colaborador colaborador;

	@Relationship(type = "CONFLITANTE_COM", direction = Relationship.OUTGOING)
	private List<RegraGlobal> regrasGlobais;

	public ProgramacaoFerias() {
	}

	public void conflitanteComRegraGlobal(RegraGlobal regraGlobal) {
		if (getRegrasGlobais() == null) {
			regrasGlobais = new ArrayList<>();
		}

		getRegrasGlobais().add(regraGlobal);
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Long getDiasFerias() {
		return diasFerias;
	}

	public void setDiasFerias(Long diasFerias) {
		this.diasFerias = diasFerias;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public List<RegraGlobal> getRegrasGlobais() {
		return regrasGlobais;
	}

}

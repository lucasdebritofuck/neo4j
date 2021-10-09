package br.com.lucasfuck.neo4j.domain;

import java.time.LocalDate;

import br.com.lucasfuck.neo4j.domain.converters.DateLocalDateConverter;
import org.neo4j.ogm.annotation.typeconversion.Convert;

public class AbstractRule extends AbstractNodeEntity implements Rule {

	@Convert(DateLocalDateConverter.class)
	private LocalDate dataInicial;

	@Convert(DateLocalDateConverter.class)
	private LocalDate dataFinal;

	@Override
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	@Override
	public LocalDate getDataInicial() {
		return dataInicial;
	}

	@Override
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public LocalDate getDataFinal() {
		return dataFinal;
	}

}

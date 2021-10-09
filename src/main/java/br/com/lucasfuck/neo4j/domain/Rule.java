package br.com.lucasfuck.neo4j.domain;

import java.time.LocalDate;

public interface Rule {

	void setDataInicial(LocalDate dataInicial);

	LocalDate getDataInicial();

	void setDataFinal(LocalDate dataFinal);

	LocalDate getDataFinal();

}

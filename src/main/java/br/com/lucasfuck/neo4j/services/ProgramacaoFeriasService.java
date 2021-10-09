package br.com.lucasfuck.neo4j.services;

import br.com.lucasfuck.neo4j.repositories.ProgramacaoFeriasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucasfuck.neo4j.domain.nodes.ProgramacaoFerias;

@Component
public class ProgramacaoFeriasService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProgramacaoFeriasService.class);

	private final ProgramacaoFeriasRepository repository;

	@Autowired
	public ProgramacaoFeriasService(ProgramacaoFeriasRepository repository) {
		this.repository = repository;
	}

	public void programarFerias(ProgramacaoFerias programacaoFerias) {
		LOGGER.info("Programando férias");
		repository.save(programacaoFerias);
	}

}

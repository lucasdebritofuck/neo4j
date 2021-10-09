package br.com.lucasfuck.neo4j.services;

import br.com.lucasfuck.neo4j.domain.nodes.RegraGlobal;
import br.com.lucasfuck.neo4j.repositories.RegraGlobalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegraGlobalService {

	private final static Logger LOGGER = LoggerFactory.getLogger(RegraGlobalService.class);

	private final RegraGlobalRepository repository;

	@Autowired
	public RegraGlobalService(RegraGlobalRepository repository) {
		this.repository = repository;
	}

	public void mergeRegraGlobal(RegraGlobal regraGlobal) {
		LOGGER.info("Insere ou altera nova regra global");
		regraGlobal = repository.findByCodigo(regraGlobal.getCodigo());

		if (regraGlobal == null) {
			regraGlobal = new RegraGlobal();
		}

		regraGlobal.setCodigo(regraGlobal.getCodigo());
		regraGlobal.setNome(regraGlobal.getNome());
		regraGlobal.setDataInicial(regraGlobal.getDataInicial());
		regraGlobal.setDataFinal(regraGlobal.getDataFinal());
		repository.save(regraGlobal);
	}

}

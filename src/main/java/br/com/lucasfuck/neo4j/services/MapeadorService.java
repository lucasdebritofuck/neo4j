package br.com.lucasfuck.neo4j.services;

import java.util.List;

import br.com.lucasfuck.neo4j.domain.nodes.ProgramacaoFerias;
import br.com.lucasfuck.neo4j.domain.nodes.RegraGlobal;
import br.com.lucasfuck.neo4j.repositories.ProgramacaoFeriasRepository;
import br.com.lucasfuck.neo4j.repositories.RegraGlobalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapeadorService {

	private final static Logger LOGGER = LoggerFactory.getLogger(MapeadorService.class);

	private ProgramacaoFeriasRepository programacaoFeriasRepository;

	private RegraGlobalRepository regraGlobalRepository;

	@Autowired
	public MapeadorService(ProgramacaoFeriasRepository programacaoFeriasRepository,
			RegraGlobalRepository regraGlobalRepository) {
		this.programacaoFeriasRepository = programacaoFeriasRepository;
		this.regraGlobalRepository = regraGlobalRepository;
	}

	public MapeadorService() {
	}

	public void mapearRegrasGlobais() {
		LOGGER.info("Mapeando regras globais");
		Iterable<RegraGlobal> regrasGlobais = regraGlobalRepository.findAll();

		for (RegraGlobal regra : regrasGlobais) {
			List<ProgramacaoFerias> programacoesConflitantes = programacaoFeriasRepository
					.findByPeriodo(regra.getDataInicial(), regra.getDataFinal());

			for (ProgramacaoFerias programacaoFeriasConflitante : programacoesConflitantes) {
				programacaoFeriasConflitante.conflitanteComRegraGlobal(regra);
			}

			programacaoFeriasRepository.saveAll(programacoesConflitantes);
		}
	}

}

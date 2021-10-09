package br.com.lucasfuck.neo4j;

import java.time.LocalDate;

import br.com.lucasfuck.neo4j.domain.nodes.Colaborador;
import br.com.lucasfuck.neo4j.domain.nodes.RegraGlobal;
import br.com.lucasfuck.neo4j.repositories.ColaboradorRepository;
import br.com.lucasfuck.neo4j.services.ProgramacaoFeriasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.lucasfuck.neo4j.domain.nodes.ProgramacaoFerias;
import br.com.lucasfuck.neo4j.services.MapeadorService;
import br.com.lucasfuck.neo4j.services.RegraGlobalService;

@SpringBootApplication
public class PocNeo4jApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PocNeo4jApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PocNeo4jApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(ColaboradorRepository colaboradorRepository,
                           ProgramacaoFeriasService programacaoFeriasService,
                           RegraGlobalService regraGlobalService,
                           MapeadorService mapeadorService) {
		return args -> {
			RegraGlobal regraGlobal = new RegraGlobal();
			regraGlobal.setCodigo("TESTE01");
			regraGlobal.setNome("Teste de regra periódica");
			regraGlobal.setDataInicial(LocalDate.of(2020, 12, 1));
			regraGlobal.setDataFinal(LocalDate.of(2021, 02, 28));

			LOGGER.info("Cadastrado nova regra global");

			regraGlobalService.mergeRegraGlobal(regraGlobal);

			LOGGER.info("Busca colaborador");

			Colaborador colabFerias = colaboradorRepository
					.findByNome("Cain Decker");

			ProgramacaoFerias programacaoFerias = new ProgramacaoFerias();
			programacaoFerias.setDataInicio(LocalDate.of(2020, 12, 1));
			programacaoFerias.setDataFim(LocalDate.of(2020, 12, 15));
			programacaoFerias.setDiasFerias((long) programacaoFerias.getDataInicio()
					.until(programacaoFerias.getDataFim()).getDays());
			programacaoFerias.setColaborador(colabFerias);
			programacaoFeriasService.programarFerias(programacaoFerias);

			LOGGER.info("Agendado suas férias");

			mapeadorService.mapearRegrasGlobais();

			LOGGER.info("Feito mapeamento");
		};
	}

}

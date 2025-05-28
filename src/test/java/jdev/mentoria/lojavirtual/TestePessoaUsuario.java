package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import jdev.mentoria.lojavirtual.model.PessoaJuridica;
import jdev.mentoria.lojavirtual.repository.PessoaRepository;
import jdev.mentoria.lojavirtual.service.PessoaUserService;
import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class TestePessoaUsuario extends TestCase {

	@Autowired
	private PessoaUserService pessoaUserService;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Test
	public void testCadPessoaFisica() {

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj("10.308.928/0001-63");
		pessoaJuridica.setNome("Jorge Fernandes de Oliveira");
		pessoaJuridica.setEmail("jfoara@gmail.com");
		pessoaJuridica.setTelefone("(82)999643508");
		pessoaJuridica.setInscEstadual("12543684");
		pessoaJuridica.setInscMunicipal("25413655");
		pessoaJuridica.setNomeFantasia("JFOARA");
		pessoaJuridica.setRazaoSocial("JFO ARA OLIVEIRA");

	pessoaRepository.save(pessoaJuridica);

		/*
		 * PessoaFisica pessoaFisica = new PessoaFisica();
		 * 
		 * pessoaFisica.setCpf("060.446.364-29");
		 * pessoaFisica.setNome("Jorge Fernandes de Oliveira");
		 * pessoaFisica.setEmail("jorgeoliveira.surdo@gmail.com");
		 * pessoaFisica.setTelefone("(82)999643508");
		 * pessoaFisica.setEmpresa(pessoaFisica);
		 * 
		 * pessoaRepository.save(pessoaFisica);
		 */

	}

}
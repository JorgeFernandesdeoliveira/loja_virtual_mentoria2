package jdev.mentoria.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import jdev.mentoria.lojavirtual.model.PessoaFisica;
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
		pessoaJuridica.setCnpj("060446364/0001-40");
		pessoaJuridica.setNome("Jorge Fernandes de Oliveira");
		pessoaJuridica.setEmail("jorgeoliveira.surdo@gmail.com");
		pessoaJuridica.setTelefone("82999643508");
		pessoaJuridica.setInscEstadual("54525555");
		pessoaJuridica.setInscMunicipal("41242149");
		pessoaJuridica.setNomeFantasia("malu");
		pessoaJuridica.setRazaoSocial("malu S/A");

		pessoaRepository.save(pessoaJuridica);

		
		 /*PessoaFisica pessoaFisica = new PessoaFisica();
		 
		 pessoaFisica.setCpf("060.446.364-29");
		 pessoaFisica.setNome("Jorge Fernandes de Oliveira");
		 pessoaFisica.setEmail("jorgeoliveira.surdo@gmail.com");
		 pessoaFisica.setTelefone("(82)999643508");
		  pessoaFisica.setEmpresa(pessoaFisica);
		  
		  pessoaRepository.save(pessoaFisica);*/
		 
	}

	public PessoaUserService getPessoaUserService() {
		return pessoaUserService;
	}

	public void setPessoaUserService(PessoaUserService pessoaUserService) {
		this.pessoaUserService = pessoaUserService;
	}
}

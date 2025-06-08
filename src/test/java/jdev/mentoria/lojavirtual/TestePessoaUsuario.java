package jdev.mentoria.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import jdev.mentoria.lojavirtual.controller.PessoaController;
import jdev.mentoria.lojavirtual.enums.TipoEndereco;
import jdev.mentoria.lojavirtual.model.Endereco;
import jdev.mentoria.lojavirtual.model.PessoaFisica;
import jdev.mentoria.lojavirtual.model.PessoaJuridica;
import jdev.mentoria.lojavirtual.repository.PessoaRepository;
import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class TestePessoaUsuario extends TestCase {

	@Autowired
	private PessoaController pessoaController;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Test
	public void testCadPessoaJuridica() throws ExceptionMentoriaJava {

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj("" + Calendar.getInstance().getTimeInMillis());
		pessoaJuridica.setNome("Jorge Fernandes Teste");
		pessoaJuridica.setEmail("jorgeoliveira.surdo691@gmail.com");
		pessoaJuridica.setTelefone("(82)9996465138");
		pessoaJuridica.setInscEstadual("3925411-8");
		pessoaJuridica.setInscMunicipal("311278544");
		pessoaJuridica.setNomeFantasia("ICJWO");
		pessoaJuridica.setRazaoSocial("Instituto SEGnm Jorge Oliveira");

		Endereco endereco1 = new Endereco();
		endereco1.setCidade("Arapiraca");
		endereco1.setBairro("Jardim de Maria");
		endereco1.setCep("57311-046");
		endereco1.setComplemento("Andar 1");
		endereco1.setEmpresa(pessoaJuridica);
		endereco1.setNumero("44");
		endereco1.setPessoa(pessoaJuridica);
		endereco1.setRuaLogra("Rua Anita Aristides da Silva");
		endereco1.setTipoEndereco(TipoEndereco.COBRANCA);
		endereco1.setUf("AL");

		Endereco endereco2 = new Endereco();
		endereco2.setCidade("Arapiraca");
		endereco2.setBairro("Jardim esperança");
		endereco2.setCep("57311-000");
		endereco2.setComplemento("Casa Azul");
		endereco2.setEmpresa(pessoaJuridica);
		endereco2.setNumero("53");
		endereco2.setPessoa(pessoaJuridica);
		endereco2.setRuaLogra("Rua expedicionário");
		endereco2.setTipoEndereco(TipoEndereco.ENTREGA);
		endereco2.setUf("AL");

		pessoaJuridica.getEnderecos().add(endereco1);
		pessoaJuridica.getEnderecos().add(endereco2);

		pessoaJuridica = pessoaController.salvarPj(pessoaJuridica).getBody();
		
		assertEquals(true, pessoaJuridica.getId() > 0);
		
		for (Endereco endereco : pessoaJuridica.getEnderecos()) {
			assertEquals(true, endereco.getId() > 0);
		}
		
		assertEquals(2, pessoaJuridica.getEnderecos().size());
	}
	
	@Test
	public void testCadPessoaFisica() throws ExceptionMentoriaJava {
		
		PessoaJuridica pessoaJuridica =  pessoaRepository.existeCnpjCadastrado("1647987989047");
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpf("950.786.460-19");
		pessoaFisica.setNome("Alex fernando");
		pessoaFisica.setEmail("alex@gmail.com");
		pessoaFisica.setTelefone("45999795800");
		pessoaFisica.setEmpresa(pessoaJuridica);
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("Jd Dias");
		endereco1.setCep("556556565");
		endereco1.setComplemento("Casa cinza");
		endereco1.setNumero("389");
		endereco1.setPessoa(pessoaFisica);
		endereco1.setRuaLogra("Av. são joao sexto");
		endereco1.setTipoEndereco(TipoEndereco.COBRANCA);
		endereco1.setUf("PR");
		endereco1.setCidade("Curitiba");
		endereco1.setEmpresa(pessoaJuridica);
		
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Jd Maracana");
		endereco2.setCep("7878778");
		endereco2.setComplemento("Andar 4");
		endereco2.setNumero("555");
		endereco2.setPessoa(pessoaFisica);
		endereco2.setRuaLogra("Av. maringá");
		endereco2.setTipoEndereco(TipoEndereco.ENTREGA);
		endereco2.setUf("PR");
		endereco2.setCidade("Curitiba");
		endereco2.setEmpresa(pessoaJuridica);
		
		pessoaFisica.getEnderecos().add(endereco2);
		pessoaFisica.getEnderecos().add(endereco1);


		pessoaFisica = pessoaController.salvarPf(pessoaFisica).getBody();
		
		assertEquals(true, pessoaFisica.getId() > 0 );
		
		for (Endereco endereco : pessoaFisica.getEnderecos()) {
			assertEquals(true, endereco.getId() > 0);
		}
		
		assertEquals(2, pessoaFisica.getEnderecos().size());


	}


}

package br.senac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Teste da classe {@link CadastrarPessoa} apresentando cenários básicos
 * de uso do Mockito, usando o recurso de mocks e a manipulação de retornos,
 * da forma mais simples e com manipulação de erros.
 * @author gabriel.silva
 *
 */
@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
	
	@Mock //Para dizer que api vc está fingindo que está acessando (mockando)
	private ApiDosCorreios apiDosCorreios;
	
	@InjectMocks //Objeto que eu estou injetando neste mock
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void testeCadastrarPessoa() {
		
		//Criar o objeto a ser mockado quando mockamos a API
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Ubá", "Av. Brasil", "Casa", "Centro");
		
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("12345-789")).thenReturn(dadosLocalizacao);
//		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao); o comando anyString() faz funcionar com qualquer coisa, não usar isso atoa
		
		Pessoa clayton = cadastrarPessoa.cadastrarPessoa("Clayton", "123456", LocalDate.of(1976, 5, 4), "12345-789");
		
		DadosLocalizacao enderecoClayton = clayton.getEndereco();
		assertEquals(dadosLocalizacao.getBairro(), enderecoClayton.getBairro());
		assertEquals(dadosLocalizacao.getCidade(), enderecoClayton.getCidade());
		assertEquals(dadosLocalizacao.getUf(), enderecoClayton.getUf());
	}

}

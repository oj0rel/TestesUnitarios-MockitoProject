package br.senac;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ListaTeste {
	
	@Mock
	private List<String> letras;
	
	@Test //essa anotação vem do jupiter
	void adicionarItemNaLista() {
		Mockito.when(letras.get(0)).thenReturn("D");
		
		Assertions.assertEquals("B", letras.get(0));
	}

}

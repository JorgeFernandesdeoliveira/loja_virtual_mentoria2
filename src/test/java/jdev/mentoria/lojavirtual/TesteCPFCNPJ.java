package jdev.mentoria.lojavirtual;

import jdev.mentoria.lojavirtual.util.ValidaCNPJ;
import jdev.mentoria.lojavirtual.util.ValidaCPF;

public class TesteCPFCNPJ {
		
	public static void main(String[] args) {
		boolean isCnpj = ValidaCNPJ.isCNPJ("66.347.536/0001-96");
		
		System.out.println("Cnpj Válido : " + isCnpj);
		
		boolean isCpf = ValidaCPF.isCPF("060.446.364-29");
		
		System.out.println("Cpf válido: " +  isCpf);

	}

}




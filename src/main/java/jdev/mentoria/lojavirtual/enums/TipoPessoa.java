package jdev.mentoria.lojavirtual.enums;

public enum TipoPessoa {

	JURIDICA("juridica"), JURIDICA_FORNECEDOR("Jurídica e Fornecedor"), FISICA("física");

	private String descricao;

	private TipoPessoa(String descrica) {
		this.descricao = descrica;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}

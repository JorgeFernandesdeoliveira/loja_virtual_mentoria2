package jdev.mentoria.lojavirtual.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")

public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKeyJoinColumn(name = "id")
	@Column(nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date DataNascimento;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}


}

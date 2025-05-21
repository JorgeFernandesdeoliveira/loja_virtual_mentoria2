package jdev.mentoria.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jdev.mentoria.lojavirtual.repository.UsuarioRepository;

@Service
public class PessoaUserService {
	
	@Autowired
	private UsuarioRepository usuarioRepositoy;

	public UsuarioRepository getUsuarioRepositoy() {
		return usuarioRepositoy;
	}

	public void setUsuarioRepositoy(UsuarioRepository usuarioRepositoy) {
		this.usuarioRepositoy = usuarioRepositoy;
	}

}

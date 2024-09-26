package br.com.criandoapi.projeto.DAO;

import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    Usuario findByUsuario(String usuario);
}

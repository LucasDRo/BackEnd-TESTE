package br.com.criandoapi.projeto.DAO;

import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUDREPOSITORY ou JPAREPOSITORY para implementar os metodos do crud
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuario(String usuario);
}

package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.DAO.UsuarioDAO;
import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//Libera todas as entradas
@CrossOrigin("*")
//Rota genérica para todos o endpoints
@RequestMapping("/usuarios")
public class UsuarioController {

    // implementa os métodos do crud DAO
    @Autowired
    private UsuarioDAO userDao;

    @GetMapping
    public List<Usuario> listarUsuarios (){
        return (List<Usuario>) userDao.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNovo = userDao.save(usuario);
        return usuarioNovo;
    }

    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNovo = userDao.save(usuario);
        return usuarioNovo;
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> excluirUsuario(@PathVariable Integer id){
        Optional<Usuario> usuario = userDao.findById(id);
        userDao.deleteById(id);
        return usuario;
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody Usuario user){
        Usuario usuario = userDao.findByUsuario(user.getUsuario());
        if(usuario.getSenha()!=null && usuario.getSenha().equals(user.getSenha())){
            return true;
        }
        return false;
    }
}

package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.DAO.UsuarioDAO;
import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    // implementa os métodos do crud DAO
    //@Autowired
    //private UsuarioDAO userDao;

    private UsuarioDAO userDao;

    public UsuarioService (UsuarioDAO userDao){
        this.userDao = userDao;
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = userDao.findAll();
        return usuarios;
    }

    public Usuario criarUsuario(Usuario user){
        userDao.save(user);
        return user;
    }

    public Usuario editarUsuario(Usuario user){
        userDao.save(user);
        return user;
    }

    public Boolean excluirUsuario(Integer id){
        userDao.deleteById(id);
        return true;
    }

    public Boolean validarLogin(Usuario user){
        Usuario usuario = userDao.findByUsuario(user.getUsuario());
        if(usuario.getSenha()!=null && usuario.getSenha().equals(user.getSenha())){
            return true;
        }
        return false;
    }
}

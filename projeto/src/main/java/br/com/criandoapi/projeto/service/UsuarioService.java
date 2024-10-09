package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.DAO.UsuarioDAO;
import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    // implementa os métodos do crud DAO
    //@Autowired
    //private UsuarioDAO userDao;

    //Ferramenta de criptografia
    private PasswordEncoder passwordEncoder;
    private UsuarioDAO userDao;

    public UsuarioService (UsuarioDAO userDao){
        this.userDao = userDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = userDao.findAll();
        return usuarios;
    }

    public Usuario criarUsuario(Usuario user){
        //criptografando a senha
        String encoder = this.passwordEncoder.encode(user.getSenha());
        user.setSenha(encoder);
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
        return (user.getSenha()!=null && passwordEncoder.matches(user.getSenha(), usuario.getSenha()));
    }
}

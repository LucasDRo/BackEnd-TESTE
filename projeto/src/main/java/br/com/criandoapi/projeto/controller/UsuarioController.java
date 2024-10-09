package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.DAO.UsuarioDAO;
import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//Libera todas as entradas
@CrossOrigin("*")
//Rota genérica para todos o endpoints
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios (){
        return ResponseEntity.status(200).body(userService.listarUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(userService.criarUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(200).body(userService.editarUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        userService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user){
        Boolean login = userService.validarLogin(user);
        if(login){
            return ResponseEntity.status(200).build();
        }else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

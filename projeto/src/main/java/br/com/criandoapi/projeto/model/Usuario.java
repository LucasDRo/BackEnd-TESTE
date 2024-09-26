package br.com.criandoapi.projeto.model;

import jakarta.persistence.*;

// Identifica como uma tabela do banco
@Entity
// Identifica o nome da tablea
@Table(name = "usuarios")
public class Usuario {

    //Identifica como uma chave primária
    @Id
    //Identifica como auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Identifica o nome da coluna do banco
    @Column(name = "id")
    private Integer id;

    //lenght - tamanho do varchar do banco
    //nullable = true - Não nulo
    @Column(name = "nome_completo", length = 200, nullable = true)
    private String nome;
    @Column(name = "usuario", length = 100, nullable = true)
    private String usuario;
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    @Column(name = "telefone", length = 15, nullable = true)
    private String telefone;
    //columnDefinition = "TEXT" - Identifica o tipo text
    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

package br.com.fiap.bean;

public class Usuarios {
    private String usuario,senha;
    private int nivel;

    public Usuarios(String usuario,String senha) {
        setUsuario(usuario);
        setSenha(senha);
    }

    public Usuarios(String usuario,String senha,int nivel) {
        this(usuario,senha);
        this.nivel = nivel;
    }

    public Usuarios() {}
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}

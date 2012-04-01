package br.com.fiap.dao;

import br.com.fiap.bean.Usuarios;

public class DaoUsuarios extends Dao{
    private Usuarios usuario;

    public DaoUsuarios(Usuarios usuario) {
        setUsuario(usuario);
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public boolean validaUsuario() {
        boolean b = false;
        if(abreConexao()) {
            try {
                st = cn.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO=? AND SENHA=?");
                st.setString(1, usuario.getUsuario());
                st.setString(2, usuario.getSenha());
                rs = st.executeQuery();
                if (rs.next()) {
                    b = true;
                    usuario.setNivel(rs.getInt("NIVEL"));
                }
            }
            catch(Exception ex) {
                erro = ex.getMessage();
            }
            finally {
                fechaConexao();
            }
        }
        return b;
    }

    public String incluiUsuario() {
        String s = "Dados inseridos com sucesso!";
        if(abreConexao()) {
            try {
                st = cn.prepareStatement("INSERT INTO USUARIOS (USUARIO,SENHA,NIVEL) VALUES (?,?,?)");
                st.setString(1, usuario.getUsuario());
                st.setString(2, usuario.getSenha());
                st.setInt(3, usuario.getNivel());
                st.executeUpdate();
            }
            catch(Exception ex) {
                s = erro = ex.getMessage();
            }
            finally {
                fechaConexao();
            }
        }
        return s;
    }
}

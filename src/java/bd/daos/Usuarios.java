package bd.daos;

import bd.BD;
import java.sql.*;
import bd.*;
import bd.core.*;
import modelo.Usuario;

public class Usuarios
{

    public void incluir (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Livro nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO usuario " +
                  "(nome,email,senha,idade,cidade) " +
                  "VALUES " +
                  "(?,?,?,?,?)";

            BD.COMANDO.prepareStatement (sql);

            //BD.COMANDO.setInt (1, Filme.getId());
            BD.COMANDO.setString (1, usuario.getNome());
            BD.COMANDO.setString  (2, usuario.getEmail());
            BD.COMANDO.setString  (3, usuario.getSenha());
            BD.COMANDO.setInt  (4, usuario.getIdade());
            BD.COMANDO.setString  (5, usuario.getCidade());
            
            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir filme");
        }
    }


    public Usuario getAluno (String nome, String senha) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIO " +
                  "WHERE nome = ? and senha = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, nome);
            BD.COMANDO.setString (2, senha);
            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            usuario = new Usuario (resultado.getString("nome"),resultado.getString("senha"),resultado.getString("cidade"),resultado.getString("email"),resultado.getInt("idade"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar filme");
        }

        return usuario;
    }

}
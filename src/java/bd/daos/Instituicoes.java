package bd.daos;

import bd.BD;
import java.sql.*;
import bd.*;
import bd.core.*;
import modelo.Instituicao;
import modelo.Sala;


public class Instituicoes
{

    public void incluir (Instituicao instituicao) throws Exception
    {
        if (instituicao==null)
            throw new Exception ("instituicao nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO instituicao " +
                  "(nome) " +
                  "VALUES " +
                  "(?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, instituicao.getNome());
      
            
            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir instituicao");
        }
    }


    public Instituicao getSala (String nome) throws Exception
    {
        Instituicao instituicao = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Instituicao " +
                  "WHERE nome = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, nome);
            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrada");

            instituicao = new Instituicao(resultado.getString("nome"),resultado.getInt("pais_id"),resultado.getInt("estado_id"),resultado.getInt("cidade_id"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar sala");
        }

        return instituicao;
    }

}
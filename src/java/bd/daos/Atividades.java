package bd.daos;

import bd.BD;
import java.sql.*;
import bd.*;
import bd.core.*;
import java.util.logging.Logger;
import modelo.Atividade;


public class Atividades
{

    private static final Logger LOG = Logger.getLogger(Atividades.class.getName());

    public void incluir (Atividade atividade) throws Exception
    {
        if (atividade==null)
            throw new Exception ("atividade nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO atividade " +
                  "(nome,nivel, texto, resposta) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, atividade.getNome());
            BD.COMANDO.setInt (2, atividade.getNivel());
            BD.COMANDO.setString (3, atividade.getTexto());       
            BD.COMANDO.setString(4, atividade.getResposta());   
            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir sala");
        }
    }


    public Atividade getAtividade(String nome) throws Exception
    {
        Atividade atividade = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ATIVIDADE " +
                  "WHERE nome = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, nome);
            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrada");

            atividade = new Atividade(resultado.getInt("id"),resultado.getString("nome"), resultado.getInt("nivel"),resultado.getString("texto"),resultado.getString("resposta") );
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar sala");
        }

        return atividade;
    }

}
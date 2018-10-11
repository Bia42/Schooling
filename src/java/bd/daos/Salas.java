package bd.daos;

import bd.BD;
import java.sql.*;
import bd.*;
import bd.core.*;
import modelo.Sala;


public class Salas
{

    public void incluir (Sala sala) throws Exception
    {
        if (sala==null)
            throw new Exception ("sala nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO sala " +
                  "(nome) " +
                  "VALUES " +
                  "(?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, sala.getNome());
      
            
            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir sala");
        }
    }


    public Sala getSala (String nome) throws Exception
    {
        Sala sala = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM SALA " +
                  "WHERE nome = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, nome);
            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrada");

            sala = new Sala(resultado.getInt("id"),resultado.getString("nome"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar sala");
        }

        return sala;
    }

}
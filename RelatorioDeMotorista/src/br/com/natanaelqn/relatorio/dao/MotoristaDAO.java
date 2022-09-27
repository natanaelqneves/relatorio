package br.com.natanaelqn.relatorio.dao;

import br.com.natanaelqn.relatorio.database.RelatorioBD;
import br.com.natanaelqn.relatorio.entity.Motorista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAO {
    
    private static final String INSERIR_SQL = "Insert into motorista "
            + "(matricula, nome, nomeDeUsuario, senha) "
            + "values ('%s', '%s', '%s', '%s')";
    
    private static final String REMOVER_SQL = "delete from motorista "
            + "where id=%d";
    
    private static final String ALTERAR_SQL = "Update motorista "
            + "set matricula ='%s', nome='%s' where id=%d";
    
    private static final String SELECIONAR_SQL = "Select * from motorista";
    
    private static final String SELECT_POR_ID = "Select * from motorista "
            + "where id = %d";
    
    private static final String SELECT_POR_NOME = "Select * from motorista "
            + "where nome = '%s'";
    
     public static void inserir(Motorista motorista) {
        String sql = String.format(INSERIR_SQL, 
                motorista.getMatricula(),
                motorista.getNome(), 
                motorista.getNomeDeUsuario(),
                motorista.getSenhaDeUsuario());
        RelatorioBD.execute(sql, true);
    }

     public static void remover(Motorista motorista) {
        String sql = String.format(REMOVER_SQL, motorista.getId());
        RelatorioBD.execute(sql, true);
    }
     
    public static void alterar(Motorista motorista) {
        String sql = String.format(ALTERAR_SQL,
                motorista.getMatricula(),
                motorista.getNome());
        RelatorioBD.execute(sql, true);
    }

    public static List<Motorista> selecionarTodos() {
        List<Motorista> lista = new ArrayList<>();
        Connection con = RelatorioBD.conectar();
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery(SELECIONAR_SQL);
            while (rs.next()) {
                byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                lista.add(new Motorista(id, matricula, nome));
            }
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }
    
    
    public static Motorista selecionarMotoristaPorId(int idPesquisa) {
        Motorista retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
            retorno = new Motorista(id, matricula, nome);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }

    public static Motorista selecionarMotoristaPorNome(String nomePesquisa) {
        Motorista retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_NOME, nomePesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
            retorno = new Motorista(id, matricula, nome);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
    
}

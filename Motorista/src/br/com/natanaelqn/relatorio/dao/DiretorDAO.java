package br.com.natanaelqn.relatorio.dao;

import br.com.natanaelqn.relatorio.database.RelatorioBD;
import br.com.natanaelqn.relatorio.entity.Diretor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DiretorDAO {
     
    private static final String INSERIR_SQL = "Insert into diretor "
            + "(matricula, nome, nomeDeUsuario, senha) "
            + "values ('%s', '%s', '%s', '%s')";
    
    private static final String REMOVER_SQL = "delete from diretor "
            + "where id=%d";
    
    private static final String ALTERAR_SQL = "Update diretor "
            + "set matricula ='%s', nome='%s' where id=%d";
    
    private static final String SELECIONAR_SQL = "Select * from diretor";
    
    private static final String SELECT_POR_ID = "Select * from diretor "
            + "where id = %d";
    
    private static final String SELECT_POR_NOME = "Select * from diretor "
            + "where nome = '%s'";
    
    private static final String SELECT_POR_LOGIN = "Select * from diretor "
            + "where nomeDeUsuario = '%s' and senha='%s'";
    
     public static void inserir(Diretor diretor) {
        String sql = String.format(INSERIR_SQL, 
                diretor.getMatricula(),
                diretor.getNome(), 
                diretor.getNomeDeUsuario(),
                diretor.getSenhaDeUsuario());
        RelatorioBD.execute(sql, true);
    }

     public static void remover(Diretor diretor) {
        String sql = String.format(REMOVER_SQL, diretor.getId());
        RelatorioBD.execute(sql, true);
    }
     
    public static void alterar(Diretor diretor) {
        String sql = String.format(ALTERAR_SQL,
                diretor.getMatricula(),
                diretor.getNome());
        RelatorioBD.execute(sql, true);
    }

    public static List<Diretor> selecionarTodos() {
        List<Diretor> lista = new ArrayList<>();
        Connection con = RelatorioBD.conectar();
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery(SELECIONAR_SQL);
            while (rs.next()) {
                byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                lista.add(new Diretor(id, matricula, nome));
            }
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }
    
    
    public static Diretor selecionarDiretorPorId(int idPesquisa) {
        Diretor retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
            retorno = new Diretor(id, matricula, nome);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }

    public static Diretor selecionarDiretorPorNome(String nomePesquisa) {
        Diretor retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_NOME, nomePesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
            retorno = new Diretor(id, matricula, nome);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
    
    public static Diretor selecionarDiretorPorLogin(String login, String senha) {
        Diretor retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_LOGIN, login, senha);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                String nomeDeUsuario = rs.getString("nomeDeUsuario");
                String senhaDoUsuario = rs.getString("senha");
            retorno = new Diretor(id, matricula, nome, nomeDeUsuario, senhaDoUsuario);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuário ou/e Senha incorreto(s)!");
        }
        return retorno;
    }
}

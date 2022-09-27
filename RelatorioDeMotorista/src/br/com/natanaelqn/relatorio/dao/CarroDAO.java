package br.com.natanaelqn.relatorio.dao;

import br.com.natanaelqn.relatorio.database.RelatorioBD;
import br.com.natanaelqn.relatorio.entity.Carro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    
    private static final String INSERIR_SQL = "Insert into carro "
            + "(placa, marca, modelo, km_atual, avariado, avaria) "
            + "values ('%s', '%s', '%s', %d, %b, '%s')";
    
    private static final String REMOVER_SQL = "delete from carro "
            + "where id=%d";
    
    private static final String ALTERAR_SQL = "Update carro "
            + "set km_atual =%d, avariado=%b, avaria='%s' where id=%d";
    
    private static final String SELECIONAR_SQL = "Select * from carro";
    
    private static final String SELECT_POR_ID = "Select * from carro "
            + "where id = %d";
    
    private static final String SELECT_POR_NOME = "Select * from carro "
            + "where nome = '%s'";
    
     public static void inserir(Carro carro) {
        String sql = String.format(INSERIR_SQL, 
                carro.getPlaca(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getKm_atual(),
                carro.isAvariado(),
                carro.getAvaria());
        RelatorioBD.execute(sql, true);
    }

     public static void remover(Carro carro) {
        String sql = String.format(REMOVER_SQL, carro.getId());
        RelatorioBD.execute(sql, true);
    }
     
    public static void alterar(Carro carro) {
        String sql = String.format(ALTERAR_SQL,
                carro.getKm_atual(),
                carro.isAvariado(),
                carro.getAvaria());
        RelatorioBD.execute(sql, true);
    }

    public static List<Carro> selecionarTodos() {
        List<Carro> lista = new ArrayList<>();
        Connection con = RelatorioBD.conectar();
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery(SELECIONAR_SQL);
            while (rs.next()) {
                byte id = rs.getByte("id");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int km_atual = Integer.parseInt(rs.getString("km_atual"));
                Boolean avariado = Boolean.parseBoolean(rs.getString("avariado"));
                String avaria = rs.getString("avaria");
                lista.add(new Carro(id, placa, marca, modelo, km_atual, avariado, avaria));
            }
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }
    
    
    public static Carro selecionarCarroPorId(int idPesquisa) {
        Carro retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int km_atual = Integer.parseInt(rs.getString("km_atual"));
                Boolean avariado = Boolean.parseBoolean(rs.getString("avariado"));
                String avaria = rs.getString("avaria");
            retorno = new Carro(id, placa, marca, modelo, km_atual, avariado, avaria);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }

    public static Carro selecionarCarroPorPlaca(String nomePesquisa) {
        Carro retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_NOME, nomePesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            byte id = rs.getByte("id");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int km_atual = Integer.parseInt(rs.getString("km_atual"));
                Boolean avariado = Boolean.parseBoolean(rs.getString("avariado"));
                String avaria = rs.getString("avaria");
            retorno = new Carro(id, placa, marca, modelo, km_atual, avariado, avaria);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
}

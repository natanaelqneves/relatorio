package br.com.natanaelqn.relatorio.dao;

import br.com.natanaelqn.relatorio.database.RelatorioBD;
import br.com.natanaelqn.relatorio.entity.Carro;
import br.com.natanaelqn.relatorio.entity.Motorista;
import br.com.natanaelqn.relatorio.entity.Relatorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO {

    //public static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private static final String INSERIR_SQL = "Insert into relatorio "
            + "(idMotorista, idCarro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato) "
            + "values (%d, %d, '%s', '%s', %d, '%s', '%s')";

    private static final String REMOVER_SQL = "delete from relatorio "
            + "where id=%d";

    private static final String ALTERAR_SQL = "Update relatorio "
            + "set dataDoServico='%s', kmPercorrido =%d, avariaNoServico='%s', relato='%s' where id=%d";

    private static final String SELECIONAR_SQL = "Select * from relatorio";

    private static final String SELECT_POR_ID = "Select * from relatorio "
            + "where id = %d";

    private static final String SELECT_POR_IDMOTORISTA = "Select * from relatorio "
            + "where idMotorista = %d";

    private static final String SELECT_POR_IDCARRO = "Select * from relatorio "
            + "where idCarro = %d";

    private static final String SELECT_POR_DATA = "Select * from relatorio "
            + "where dataDoServico = '%s'";

    private static final String SELECT_POR_AVARIADO = "Select * from relatorio "
            + "where avariaNoServico = '%s'";

    public static void inserir(Relatorio relatorio) {
        String sql = String.format(INSERIR_SQL,
                relatorio.getMotorista().getId(),
                relatorio.getCarro().getId(),
                relatorio.getDataDoServico(),
                relatorio.getDataDoEnvio(),
                relatorio.getKm_percorrido(),
                relatorio.getAvariaNoServico(),
                relatorio.getRelato());
        RelatorioBD.execute(sql, true);
    }

    public static void remover(Relatorio relatorio) {
        String sql = String.format(REMOVER_SQL, relatorio.getId());
        RelatorioBD.execute(sql, true);
    }

    public static void alterar(Relatorio relatorio) {
        String sql = String.format(ALTERAR_SQL,
                relatorio.getDataDoServico().toString(),
                relatorio.getKm_percorrido(),
                relatorio.getAvariaNoServico(),
                relatorio.getRelato(),
                relatorio.getId());
        RelatorioBD.execute(sql, true);
    }

    public static List<Relatorio> selecionarTodos() throws ParseException {
        List<Relatorio> lista = new ArrayList<>();
        Connection con = RelatorioBD.conectar();
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery(SELECIONAR_SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idMotorista = Integer.parseInt(rs.getString("idMotorista"));
                Motorista motorista = MotoristaDAO.selecionarMotoristaPorId(idMotorista);
                int idCarro = Integer.parseInt(rs.getString("idCarro"));
                Carro carro = CarroDAO.selecionarCarroPorId(idCarro);
                LocalDate dataDoServico = LocalDate.parse(rs.getString("dataDoServico"));
            LocalDate dataDoEnvio = LocalDate.parse(rs.getString("dataDoEnvio"));
                int kmPercorrido = Integer.parseInt(rs.getString("kmPercorrido"));
                String avariaNoServico = rs.getString("avariaNoServico");
                String relato = rs.getString("relato");
                lista.add(new Relatorio(id, motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato));
            }
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }

    public static Relatorio selecionarRelatorioPorId(int idPesquisa) throws ParseException {
        Relatorio retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            int idMotorista = Integer.parseInt(rs.getString("idMotorista"));
            Motorista motorista = MotoristaDAO.selecionarMotoristaPorId(idMotorista);
            int idCarro = Integer.parseInt(rs.getString("idCarro"));
            Carro carro = CarroDAO.selecionarCarroPorId(idCarro);
            LocalDate dataDoServico = LocalDate.parse(rs.getString("dataDoServico"));
            LocalDate dataDoEnvio = LocalDate.parse(rs.getString("dataDoEnvio"));
            int kmPercorrido = Integer.parseInt(rs.getString("kmPercorrido"));
            String avariaNoServico = rs.getString("avariaNoServico");
            String relato = rs.getString("relato");
            retorno = new Relatorio(id, motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }

    public static List<Relatorio> selecionarRelatoriosPorMotorista(Motorista moto) throws ParseException {
        List<Relatorio> lista = new ArrayList<>();
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_IDMOTORISTA, moto.getId());
            ResultSet rs = con.createStatement()
                    .executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idMotorista = Integer.parseInt(rs.getString("idMotorista"));
                Motorista motorista = MotoristaDAO.selecionarMotoristaPorId(idMotorista);
                int idCarro = Integer.parseInt(rs.getString("idCarro"));
                Carro carro = CarroDAO.selecionarCarroPorId(idCarro);
                LocalDate dataDoServico = LocalDate.parse(rs.getString("dataDoServico"));
            LocalDate dataDoEnvio = LocalDate.parse(rs.getString("dataDoEnvio"));
                int kmPercorrido = Integer.parseInt(rs.getString("kmPercorrido"));
                String avariaNoServico = rs.getString("avariaNoServico");
                String relato = rs.getString("relato");
                lista.add(new Relatorio(id, motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato));
            }
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
        }
        return lista;
    }

    public static Relatorio selecionarRelatorioPorCarro(Carro car) throws ParseException {
        Relatorio retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_IDCARRO, car.getId());
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            int idMotorista = Integer.parseInt(rs.getString("idMotorista"));
            Motorista motorista = MotoristaDAO.selecionarMotoristaPorId(idMotorista);
            int idCarro = Integer.parseInt(rs.getString("idCarro"));
            Carro carro = CarroDAO.selecionarCarroPorId(idCarro);
            LocalDate dataDoServico = LocalDate.parse(rs.getString("dataDoServico"));
            LocalDate dataDoEnvio = LocalDate.parse(rs.getString("dataDoEnvio"));
            int kmPercorrido = Integer.parseInt(rs.getString("kmPercorrido"));
            String avariaNoServico = rs.getString("avariaNoServico");
            String relato = rs.getString("relato");
            retorno = new Relatorio(id, motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }

    public static Relatorio selecionarRelatorioPorData(String data) throws ParseException {
        Relatorio retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_DATA, data);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            int idMotorista = Integer.parseInt(rs.getString("idMotorista"));
            Motorista motorista = MotoristaDAO.selecionarMotoristaPorId(idMotorista);
            int idCarro = Integer.parseInt(rs.getString("idCarro"));
            Carro carro = CarroDAO.selecionarCarroPorId(idCarro);
            LocalDate dataDoServico = LocalDate.parse(rs.getString("dataDoServico"));
            LocalDate dataDoEnvio = LocalDate.parse(rs.getString("dataDoEnvio"));
            int kmPercorrido = Integer.parseInt(rs.getString("kmPercorrido"));
            String avariaNoServico = rs.getString("avariaNoServico");
            String relato = rs.getString("relato");
            retorno = new Relatorio(id, motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }

    public static Relatorio selecionarRelatorioPorAvariado(Boolean avaria) throws ParseException {
        Relatorio retorno = null;
        Connection con = RelatorioBD.conectar();
        try {
            String sql = String.format(SELECT_POR_AVARIADO, avaria);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            int idMotorista = Integer.parseInt(rs.getString("idMotorista"));
            Motorista motorista = MotoristaDAO.selecionarMotoristaPorId(idMotorista);
            int idCarro = Integer.parseInt(rs.getString("idCarro"));
            Carro carro = CarroDAO.selecionarCarroPorId(idCarro);
            LocalDate dataDoServico = LocalDate.parse(rs.getString("dataDoServico"));
            LocalDate dataDoEnvio = LocalDate.parse(rs.getString("dataDoEnvio"));
            int kmPercorrido = Integer.parseInt(rs.getString("kmPercorrido"));
            String avariaNoServico = rs.getString("avariaNoServico");
            String relato = rs.getString("relato");
            retorno = new Relatorio(id, motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato);
            RelatorioBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
}

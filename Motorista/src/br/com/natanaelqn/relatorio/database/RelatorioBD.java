package br.com.natanaelqn.relatorio.database;

import br.com.natanaelqn.base.Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RelatorioBD {

    public static void inicializarBD() {
        String sql;
        Connection con = conectar();
        //DROP DE TABELAS, CASO EXISTAM
       sql = "Drop table if exists motorista";
        execute(con, sql);
        sql = "Drop table if exists diretor";
        execute(con, sql);
        sql = "Drop table if exists carro";
        execute(con, sql);
        sql = "Drop table if exists relatorio";
        execute(con, sql);

        //CRIAÇÃO DAS TABELAS, CASO NÃO EXISTAM
        //CRIA A TABELA DIRETOR
        sql = "Create table if not exists diretor "
                + "(id int not null auto_increment primary key, "
                + "matricula varchar(8) not null, "
                + "nome varchar(15) not null, "
                + "nomeDeUsuario varchar(15) not null, "
                + "senha varchar(10) not null, "
                + "unique key (nome, matricula, nomeDeUsuario))";
        execute(con, sql);

        //CRIA A TABELA MOTORISTA
        sql = "Create table if not exists motorista "
                + "(id int not null auto_increment primary key, "
                + "matricula varchar(8) not null, "
                + "nome varchar(15) not null, "
                + "nomeDeUsuario varchar(15) not null, "
                + "senha varchar(6) not null, "
                + "unique key (nome, matricula, nomeDeUsuario))";
        execute(con, sql);

        //CRIA A TABELA CARRO
        sql = "create table if not exists carro "
                + "(id int not null auto_increment primary key, "
                + "placa varchar(7) not null, "
                + "marca varchar(12) not null, "
                + "modelo varchar(12) not null, "
                + "km_atual int (12) not null, "
                + "avariado varchar(3) not null, "
                + "avaria varchar(200), "
                + "unique key (placa))";
        execute(con, sql);

        //CRIA A TABELA RELATORIO
        sql = "create table if not exists relatorio "
                + "(id int not null auto_increment primary key, "
                + "idMotorista int not null,"
                + "idCarro int not null,"
                + "dataDoServico date not null,"
                + "dataDoEnvio date not null,"
                + "kmPercorrido int (3) not null,"
                + "avariaNoServico varchar(3) not null, "
                + "relato varchar(200), "
                + "foreign key (idMotorista) references motorista(id), "
                + "foreign key (idCarro) references carro(id))";
        execute(con, sql);

        //INSERIR INTORMAÇÕES DAS ENTIDADES
        sql = "Insert into diretor (matricula, nome, nomeDeUsuario, senha) values ('1111111', 'Administrador', 'admin', '123456')";
        execute(con, sql);
        sql = "Insert into motorista (matricula, nome, nomeDeUsuario, senha) values ('2222222', 'Motorista', 'motorista', '123456')";
        execute(con, sql);
        sql = "Insert into motorista (matricula, nome, nomeDeUsuario, senha) values ('2022005', 'Antonio', 'antonio', '111222')";
        execute(con, sql);
        sql = "Insert into carro (placa, marca, modelo, km_atual, avariado) values ('NIS1234', 'Nissan', 'Frontier', 255, 'Não')";
        execute(con, sql);
        sql = "Insert into carro (placa, marca, modelo, km_atual, avariado) values ('HYL5678', 'Toyota', 'Hilux', 331, 'Não')";
        execute(con, sql);
        sql = "Insert into carro (placa, marca, modelo, km_atual, avariado) values ('AMR2256', 'Volkswagen', 'Amarok', 12, 'Sim')";
        execute(con, sql);
        sql = "Insert into relatorio (idMotorista, idCarro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico) values (1, 1, '2022-09-25', '2022-09-26', 55, 'Não')";
        execute(con, sql);
        sql = "Insert into relatorio (idMotorista, idCarro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico) values (1, 1, '2022-09-27', '2022-09-27', 45, 'Não')";
        execute(con, sql);
        sql = "Insert into relatorio (idMotorista, idCarro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato) values (1, 2, '2022-09-27', '2022-09-27', 62, 'Sim', 'Lanterna direita traseira')";
        execute(con, sql);
        desconectar(con);
    }

    public static void execute(String sql) {
        execute(sql, false);
    }

    public static void execute(String sql, boolean continuaNoErro) {
        // Fazer versão para conexões seguidas não desconectar
        Connection con = conectar();
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar\n" + sql);
            if (!continuaNoErro) {
                System.exit(1);
            }
        }
        desconectar(con);
    }

    private static void execute(Connection con, String sql) {
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Base.mensagemDeErro("Não foi possível executar\n" + sql);
            System.exit(1);
        }
    }

    public static Connection conectar() {
        Connection con = null;

        final String USUARIO = "root";
        final String SENHA = "984324";

        final String URL = "jdbc:mysql://localhost/relatorio";
        try {
            con = DriverManager.getConnection(URL,
                    USUARIO, SENHA);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.exit(1);
        }
        return con;
    }

    public static void desconectar(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
        }
    }
}

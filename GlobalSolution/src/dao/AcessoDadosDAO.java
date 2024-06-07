package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CadastroDados;


public class AcessoDadosDAO {

    private Connection conexao;

    public AcessoDadosDAO() {

        conexao = GerenciadorBD.obterConexao();
    }

    public ArrayList<CadastroDados> localizarAll() {
        ArrayList<CadastroDados> listaCadastros = new ArrayList<>();

        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM t_dados");
            ResultSet resultados = comandoSQL.executeQuery();
            while (resultados.next()) {
                CadastroDados cadastro = new CadastroDados();
                cadastro.setResponsavel(resultados.getString(7));
                cadastro.setTemperatura(resultados.getDouble(2));
                cadastro.setpH(resultados.getDouble(3));
                cadastro.setSalinidade(resultados.getDouble(4));
                cadastro.setNivelNutriente(resultados.getDouble(5));
                cadastro.setDate(resultados.getString(6));
                listaCadastros.add(cadastro);
            }
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCadastros;
    }


}

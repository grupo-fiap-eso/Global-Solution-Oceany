package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.CadastroDados;

public class CadastroDadosDAO {
	 private Connection conexao;
	 
	 public void inserir(CadastroDados cadastro) {
	        conexao = GerenciadorBD.obterConexao();
	        PreparedStatement comandoSQL = null;

	        try {
	            conexao = GerenciadorBD.obterConexao();
	            String sql = "INSERT INTO t_dados (id_responsavel, temperatura, ph, salinidade, nivel_nutriente, data) VALUES (?,?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))";
	            comandoSQL = conexao.prepareStatement(sql);
	            comandoSQL.setString(1, cadastro.getResponsavel());
	            comandoSQL.setDouble(2, cadastro.getTemperatura());
	            comandoSQL.setDouble(3, cadastro.getpH());
	            comandoSQL.setDouble(4, cadastro.getSalinidade());
	            comandoSQL.setDouble(5, cadastro.getNivelNutriente());
	            comandoSQL.setString(6, cadastro.getDate());
	            comandoSQL.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (comandoSQL != null) comandoSQL.close();
	                if (conexao != null) conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}

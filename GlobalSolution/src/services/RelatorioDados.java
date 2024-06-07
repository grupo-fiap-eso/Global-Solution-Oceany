package services;

import java.util.ArrayList;
import dao.AcessoDadosDAO;
import erros.ColecaoVazia;
import erros.RelatorioInvalido;
import model.CadastroDados;

public class RelatorioDados {

	public String calcularMedia(String tipo){
	        AcessoDadosDAO dao = new AcessoDadosDAO();
	        ArrayList<CadastroDados> cadastros = dao.localizarAll();
	        double soma = 0;
	        String resultado = "";
			
        try {
			if (cadastros == null || cadastros.size() == 0) {
	            throw new ColecaoVazia("CadastroDados");
	        }
	        switch (tipo) {
	        case "temperatura":
	        	soma = 0;
	        	for (CadastroDados cadastro : cadastros) {
	        		soma += cadastro.getTemperatura();
	            }	            	
	            break;
	        case "salinidade":
	        	soma = 0;
	        	for (CadastroDados cadastro : cadastros) {
	        		soma += cadastro.getSalinidade();
	            }
	        	break;
	        case "ph":
	        	soma = 0;
	        	for (CadastroDados cadastro : cadastros) {
	        		soma += cadastro.getpH();
	            }
	            break;
	        case "nivel_nutriente":
		    	soma = 0;
		    	for (CadastroDados cadastro : cadastros) {
		    		soma += cadastro.getNivelNutriente();
		        }		    	
		    	break;
	        default:
	            throw new RelatorioInvalido(tipo);
	        }
	        double media = soma/cadastros.size();
	        resultado = "A média de " + tipo + " é: " + media;
	     }catch (ColecaoVazia | RelatorioInvalido e) {
	    	 resultado = e.getMessage();
		 }finally{
			return resultado;
		}
	}
}	


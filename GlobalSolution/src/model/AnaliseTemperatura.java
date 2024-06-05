package model;

import dao.AcessoDadosDAO;
import java.util.ArrayList;


public class AnaliseTemperatura {

    public static void main(String[] args) {
        AcessoDadosDAO dao = new AcessoDadosDAO();
        ArrayList<CadastroDados> cadastros = dao.localizarAll();


        double somaTemperaturas = 0;
        for (CadastroDados cadastro : cadastros) {
            somaTemperaturas += cadastro.getTemperatura();
        }
        double mediaTemperatura = somaTemperaturas / cadastros.size();


        System.out.println("Média da temperatura: " + mediaTemperatura);
    }
}

package model;

public class CadastroDados {
	
	public String responsavel;
	public double temperatura;
    public double pH;
    public double salinidade;
    public double nivelNutriente;
    public String date;
    
    public CadastroDados() {
    }
    
    public CadastroDados(String responsavel, double temperatura, double pH, double salinidade, double nivelNutriente, String date) {
        this.responsavel = responsavel;
        this.temperatura = temperatura;
        this.pH = pH;
        this.salinidade = salinidade;
        this.nivelNutriente = nivelNutriente;
        this.date = date;
    }

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getpH() {
		return pH;
	}

	public void setpH(double pH) {
		this.pH = pH;
	}

	public double getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(double salinidade) {
		this.salinidade = salinidade;
	}

	public double getNivelNutriente() {
		return nivelNutriente;
	}

	public void setNivelNutriente(double nivelNutriente) {
		this.nivelNutriente = nivelNutriente;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
    

    
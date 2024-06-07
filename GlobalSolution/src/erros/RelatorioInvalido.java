package erros;

public class RelatorioInvalido extends Exception {
	private static final long serialVersionUID = 1L;

	 public RelatorioInvalido(String relatorio) {
	        super("O Relatorio: " + relatorio + " é invalido");
	    }
}
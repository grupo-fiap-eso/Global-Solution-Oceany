package erros;

public class ColecaoVazia extends Exception {
	private static final long serialVersionUID = 1L;

	 public ColecaoVazia(String classe) {
	        super("A coleção de: " + classe + " está vazia");
	    }
}
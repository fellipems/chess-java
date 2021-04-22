package boardgame;

public class BoardException extends RuntimeException {	// RuntimeException por ser opcional de ser tratada

	private static final long serialVersionUID = 1L;
	
	public BoardException(String mensagem) {
		super(mensagem);
	}

}

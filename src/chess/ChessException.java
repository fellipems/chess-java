package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {	// capturará tanto as exceções do Chess quanto possíveis exceções do Board

	private static final long serialVersionUID = 1L;
	
	public ChessException(String mensagem) {
		super(mensagem);
	}
}

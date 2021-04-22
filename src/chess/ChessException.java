package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {	// capturar� tanto as exce��es do Chess quanto poss�veis exce��es do Board

	private static final long serialVersionUID = 1L;
	
	public ChessException(String mensagem) {
		super(mensagem);
	}
}

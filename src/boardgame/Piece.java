package boardgame;

public class Piece {

	protected Position position;	// não é a posição da peça e sim da matriz. Não queremos visibilidade na camada das peças de xadrez
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {	// uso interno da camada do tabuleiro
		return board;
	}
	
}

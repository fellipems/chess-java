package boardgame;

public class Piece {

	protected Position position;	// n�o � a posi��o da pe�a e sim da matriz. N�o queremos visibilidade na camada das pe�as de xadrez
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {	// uso interno da camada do tabuleiro
		return board;
	}
	
}

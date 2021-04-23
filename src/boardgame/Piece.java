package boardgame;

public abstract class Piece {

	protected Position position;	// n�o � a posi��o da pe�a e sim da matriz. N�o queremos visibilidade na camada das pe�as de xadrez
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {	// uso interno da camada do tabuleiro
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {	// testar se a pe�a pode mover para uma dada posi��o
		return possibleMoves()[position.getRow()][position.getColumn()];	// temos um m�todo concreto(possibleMove) em que ele est� utilizando um m�todo abstrato. Rook methods(m�todo que faz um "gancho" com a subclasse)
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}	// chamar� o m�todo abstrato possibleMoves que retornar� uma matriz de booleano. Varreremos a matriz para verificar se existe, pelo menos, uma posi��o da matriz que � verdadeira
}

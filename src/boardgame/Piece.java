package boardgame;

public abstract class Piece {

	protected Position position;	// não é a posição da peça e sim da matriz. Não queremos visibilidade na camada das peças de xadrez
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {	// uso interno da camada do tabuleiro
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {	// testar se a peça pode mover para uma dada posição
		return possibleMoves()[position.getRow()][position.getColumn()];	// temos um método concreto(possibleMove) em que ele está utilizando um método abstrato. Rook methods(método que faz um "gancho" com a subclasse)
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
	}	// chamará o método abstrato possibleMoves que retornará uma matriz de booleano. Varreremos a matriz para verificar se existe, pelo menos, uma posição da matriz que é verdadeira
}

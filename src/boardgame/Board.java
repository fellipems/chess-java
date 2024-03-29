package boardgame;

public class Board {

	private int rows, columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar o tabuleiro: Deve haver, pelo menos, 1 linha e 1 coluna!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro!");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("J� tem uma pe�a na posi��o " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro!");
		}
		if(piece(position) == null) {
			return null;
		}
		
		Piece aux = piece(position);	// vari�vel aux apontando pra posi��o da pe�a que � para remover
		aux.position = null;	// recebe null pois foi removida do tabuleiro. Sem posi��o mais
		pieces[position.getRow()][position.getColumn()] = null;	// indica que n�o tem mais a pe�a nessa posi��o da matriz
		return aux;
	}
	
	private boolean positionExists(int row, int column) {	// dentro da classe vai ter um momento que ser� mais f�cil testar pela linha e coluna do que pela posi��o. Por isso este m�todo
		return (row >= 0 && row < rows) && (column >= 0 && column < columns);
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro!");
		}
		return piece(position) != null;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
}

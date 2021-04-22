package chess;

import boardgame.Position;

public class ChessPosition {
	
	// a linha da matriz será: 8 -(menos) a linha do xadrez (matrix_row = 8 - chess_row)
	// coluna "a" do xadrez corresponde a linha "0" da matriz
	// coluna "b" do xadrez corresponde a linha "1" da matriz, e assim sucessivamente	
	// código unicode do caractere 'a' - o caractere 'a' fica 0
	// código unicode do caractere 'b' - o caractere 'a' = 1
	// código unicode do 'c' - o 'a' teremos o 2 e assim sucessivamente
	// fórmula para "achar" a coluna da matriz: será a coluna do xadrez -(menos) o caractere 'a' (ou caractere escolhido). (matrix_column = chess_column - 'a')
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if((column < 'a' || column > 'h') || (row < 1 || row > 8)) {
			throw new ChessException("Erro ao instanciar ChessPosition. Valores de posições validos são do a1 até o h8");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
		// retorna uma nova posição. Quem será a linha dessa posição?  Será 8 -(menos) a linha da posição do xadrez
		// quem será a coluna ? coluna do xadrez -(menos) caractere 'a'
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
		// implementando a operação inversa, dada uma posição na matriz teremos que converter ela para uma posição de xadrez(ChessPosition)
		// feito o cast para o char. Xadrez primeiro a coluna depois a linha
	}
	
	@Override
	public String toString() {
		return "" + column + row; // sem aspas o compilador não entende, colocando aspas "força" o compilador a interpretar e entender que é uam concatenação de strings
	}
	
}

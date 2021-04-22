package chess;

import boardgame.Position;

public class ChessPosition {
	
	// a linha da matriz ser�: 8 -(menos) a linha do xadrez (matrix_row = 8 - chess_row)
	// coluna "a" do xadrez corresponde a linha "0" da matriz
	// coluna "b" do xadrez corresponde a linha "1" da matriz, e assim sucessivamente	
	// c�digo unicode do caractere 'a' - o caractere 'a' fica 0
	// c�digo unicode do caractere 'b' - o caractere 'a' = 1
	// c�digo unicode do 'c' - o 'a' teremos o 2 e assim sucessivamente
	// f�rmula para "achar" a coluna da matriz: ser� a coluna do xadrez -(menos) o caractere 'a' (ou caractere escolhido). (matrix_column = chess_column - 'a')
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if((column < 'a' || column > 'h') || (row < 1 || row > 8)) {
			throw new ChessException("Erro ao instanciar ChessPosition. Valores de posi��es validos s�o do a1 at� o h8");
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
		// retorna uma nova posi��o. Quem ser� a linha dessa posi��o?  Ser� 8 -(menos) a linha da posi��o do xadrez
		// quem ser� a coluna ? coluna do xadrez -(menos) caractere 'a'
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
		// implementando a opera��o inversa, dada uma posi��o na matriz teremos que converter ela para uma posi��o de xadrez(ChessPosition)
		// feito o cast para o char. Xadrez primeiro a coluna depois a linha
	}
	
	@Override
	public String toString() {
		return "" + column + row; // sem aspas o compilador n�o entende, colocando aspas "for�a" o compilador a interpretar e entender que � uam concatena��o de strings
	}
	
}

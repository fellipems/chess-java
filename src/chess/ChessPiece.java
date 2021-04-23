package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board); // repassa a chamada do construtor para a super classe(da classe Piece)
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
}

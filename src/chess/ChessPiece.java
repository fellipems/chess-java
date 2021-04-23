package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board); // repassa a chamada do construtor para a super classe(da classe Piece)
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;	// estamos testando se a cor da pe�a dessa posi��o � a cor diferente da cor da minha pe�a, ou seja, uma pe�a advers�ria
	}
}

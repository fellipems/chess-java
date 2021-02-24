package chess;

import boardgame.Board;

public class ChessMatch {	// regras do jogo de xadrez

	private Board board; 	// uma partida tem que ter um tabuleiro
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	public ChessPiece[][] getPieces() {	// retorna uma matriz de peças de xadrez correspondente a esta partida
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);	// DownCast para interpretar como uma peça de xadrez e não como uma peça comum
			}
		}
		return mat; 	// retorna a matriz de peças da partida de xadrez
	}
}

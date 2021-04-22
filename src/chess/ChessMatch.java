package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {	// regras do jogo de xadrez

	private Board board; 	// uma partida tem que ter um tabuleiro
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();		// na hora que for criada a partida, criamos um tabuleiro 8 X 8 e chamamos o initialSetup
	}
	
	public ChessPiece[][] getPieces() {	// retorna uma matriz de pe�as de xadrez correspondente a esta partida
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);	// DownCast para interpretar como uma pe�a de xadrez e n�o como uma pe�a comum
			}
		}
		return mat; 	// retorna a matriz de pe�as da partida de xadrez
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {	// recebe as coordenadas do xadrez
		board.placePiece(piece, new ChessPosition(column, row).toPosition());	// convertendo para a posi��o de matriz
	}
	
	private void initialSetup() {	// respons�vel por iniciar a partida de xadrez colocando as pe�as no tabuleiro
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));		// instanciando as pe�as no tabuleiro
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('a', 2, new King(board, Color.WHITE));
		//board.placePiece(new King(board, Color.BLACK), new Position(6, 2));
	}
}

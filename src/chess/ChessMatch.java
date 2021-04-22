package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {	// regras do jogo de xadrez

	private Board board; 	// uma partida tem que ter um tabuleiro
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();		// na hora que for criada a partida, criamos um tabuleiro 8 X 8 e chamamos o initialSetup
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();	// convertendo as duas ChessPosition para posição de matriz
		Position target = targetPosition.toPosition();	// convertendo as duas ChessPosition para posição de matriz
		ValidateSourcePosition(source);	// Validar se a posição de origem(sourcePosition) existe
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;	// downcast pq a peça capturada era do tipo Piece
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece piece = board.removePiece(source);	// removeu a peça na posição de origem
		Piece capturedPiece = board.removePiece(target);	// remover a possível peça que esteja na posição de destino, e ela por padrão será a peça capturada
		board.placePiece(piece, target);	// colocar a posição que estava na origem, lá na posição de destino
		return capturedPiece;
	}

	private void ValidateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("Não existe a peça na posição de origem informada");	// ela também é uma exceção de Board, então podemos extender ela
		}
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {	// recebe as coordenadas do xadrez
		board.placePiece(piece, new ChessPosition(column, row).toPosition());	// convertendo para a posição de matriz
	}
	
	private void initialSetup() {	// responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
		//placeNewPiece('b', 6, new Rook(board, Color.WHITE));		// instanciando as peças no tabuleiro
		//board.placePiece(new King(board, Color.BLACK), new Position(6, 2));
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}

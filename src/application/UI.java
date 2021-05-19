package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));	// recortando a String apartir do indice/posição 1 para pegar a linha e convertendo para int;
			return new ChessPosition(column, row);
		} catch(RuntimeException e) {
			throw new InputMismatchException("Erro ao instanciar ChessPosition. Valores de posições validos são do a1 até o h8");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");		// imprime os números
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);	// imprime as peças e quando for para imprimir o tabuleiro sem a questão dos movimentos possíveis, colocamos um false
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPiece(captured);	// Imprimir as peças capturadas
		System.out.println();
		System.out.println("Turno: " + chessMatch.getTurn());
		System.out.println("Esperando pelo jogador: " + chessMatch.getCurrentPlayer());
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");		// imprime os números
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);	// imprime as peças e quando for imprimir os movimentos possíveis, passamos o posssibleMoves na posição I J depedendo da variável para pintar ou não os movimentos
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece, boolean background) {	// imprime uma peça no tabuleiro
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if(piece == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if(piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}
	
	private static void printCapturedPiece(List<ChessPiece> captured){
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());	// Lista de peça capturada. Usamos Filtragem de lista. Pegamos o nome da lista original chamando o Stream com o filter. Dentro dele colocamos um predicado em que ele pegará um elemento da lista e verificamos a condição deste elemento. Estamos filtrando da nossa lista todo mundo cuja a cor é branca
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		// Lógica p/ imprimir as listas na tela
		System.out.println("Peças capturadas:");
		System.out.print("Brancas: ");
		System.out.println(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.println(ANSI_RESET);
		
		System.out.print("Pretas: ");
		System.out.println(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
	}

}

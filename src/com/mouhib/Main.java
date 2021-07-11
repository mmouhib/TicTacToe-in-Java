package com.mouhib;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] board;
        board = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        char symbol = getSymbol();
        char choice = choice(board);
        boardPrinter(board);
        filler(board,choice,symbol);
        boardPrinter(board);

    }


    public static char getSymbol() {
        System.out.println("Make your choice: (X|O)");
        String symbol;
        do {
            Scanner scan = new Scanner(System.in);
            symbol = scan.nextLine().toUpperCase();
        }while (!symbol.equals("X") && !symbol.equals("O"));
        return symbol.charAt(0);
    }

    public static void boardPrinter(char[][] board){
        System.out.println("\n----+---+----");
        for (byte i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (byte j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n----+---+----");
        }
    }

    public static boolean checker(char[][] board, char position) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == position) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char choice(char[][] board){
        Scanner scan = new Scanner(System.in);
        char choice;

        do {
            System.out.println("choice: ");
            choice = scan.nextLine().charAt(0);
        } while (!checker(board,choice) || (choice > '9' || choice < '1'));
        return choice;
    }

    public static void filler(char[][] board, char choice, char symbol){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == choice){
                    board[i][j] = symbol;
                }
            }
        }
    }
}

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

//        char symbol = getSymbol();
//        char choice = choice(board);
//        filler(board,choice,symbol);
//        boardPrinter(board);

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


    /*
            ----+---+----
            | 1 | 2 | 3 |
            ----+---+----
            | 4 | 5 | 6 |
            ----+---+----
            | 7 | 8 | 9 |
            ----+---+----
    */


    public static boolean Winner(char[][] board, char symbol){
        //straight horizontal
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == symbol) {return true;}
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == symbol) {return true;}
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == symbol) {return true;}

        //straight vertical
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == symbol) {return true;}
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == symbol) {return true;}
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == symbol) {return true;}

        //diagonal top left to buttom right
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == symbol) {return true;}

        //diagonal top right to buttom left
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == symbol) {return true;}

        return false;
    }

//    public static boolean Draw(char [][] board){
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[i][j] ! in  )
//            }
//        }
//        return true;
//    }
}

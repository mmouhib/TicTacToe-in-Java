package com.mouhib;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        long start = System.currentTimeMillis();
        char[][] board = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        char symbol = getSymbol(), ComputerChoice;
        if (symbol == 'X')
            ComputerChoice = 'O';
        else
            ComputerChoice = 'X';

        while (true){
            boardPrinter(board);
            char choice = choice(board);
            filler(board,choice,symbol);
            if (Draw(board) || Winner(board,symbol) || Winner(board,ComputerChoice)) break;
            char ComputerPos = ComputerChoice(board);
            filler(board,ComputerPos,ComputerChoice);
            System.out.println("\n*** Computer Choice: " + ComputerPos);
            if (Draw(board) || Winner(board,symbol) || Winner(board,ComputerChoice)) break;
        }

        boardPrinter(board);

        int winner = 0;
        if (Draw(board))
            winner = 2;
        else if (Winner(board,symbol))
            winner = 1;

        switch (winner) {
            case 0 -> System.out.println("\nDETROIT BECOME HUMAN");
            case 1 -> System.out.println("\nCongrats, you've won");
            default -> System.out.println("\nDraw");
        }

        System.out.print("\nRound Time: ");
        System.out.println((System.currentTimeMillis() - start)/1000 + " Seconds");

    }


    public static char getSymbol() {
        System.out.println("Make your choice: (X|O)");
        String symbol;
        do {
            Scanner scan = new Scanner(System.in);
            symbol = scan.nextLine().toUpperCase();
        } while (!symbol.equals("X") && !symbol.equals("O"));
        return symbol.charAt(0);
    }

    public static void boardPrinter(char[][] board) {
        System.out.println("\n----+---+----");
        for (char[] chars : board) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println("\n----+---+----");
        }
    }

    public static boolean checker(char[][] board, char position) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == position) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char choice(char[][] board) {
        Scanner scan = new Scanner(System.in);
        char choice;
        do {
            System.out.println("choice: ");
            choice = scan.nextLine().charAt(0);
        } while (!checker(board, choice) || (choice > '9' || choice < '1'));
        return choice;
    }

    public static void filler(char[][] board, char choice, char symbol) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == choice)
                    board[i][j] = symbol;
            }
        }
    }

    public static boolean Winner(char[][] board, char symbol) {
        //straight horizontal
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == symbol) return true;
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == symbol) return true;
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == symbol) return true;
        //straight vertical
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == symbol) return true;
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == symbol) return true;
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == symbol) return true;
        //diagonal top left to bottom right
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == symbol) return true;
        //diagonal top right to bottom left
        return board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == symbol;
    }

    public static boolean Draw(char[][] board) {
        if (Winner(board, 'X') || Winner(board, 'O'))
            return false;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar >= '1' && aChar <= '9') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean SearchInArray(char[][] board, char value) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == value)
                    return true;
            }
        }
        return false;
    }

    public static char ComputerChoice(char[][] board) {
        char pos;
        do {
            pos = Integer.toString((int) ((Math.random() * (9 - 1)) + 1)).charAt(0);
            System.out.println(pos);
        } while (!SearchInArray(board,pos));
        return pos;
    }
}
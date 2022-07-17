package io.metadevs.vkostyrev.chess;

import java.util.Scanner;

import static io.metadevs.vkostyrev.chess.ChessBoard.chessBoard;

abstract public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    public static boolean win = false;
    public static char walkingColour;

    public void startGame() {
        showStartInfo();

        while (!win) {
            playerStep();
        }
    }

    public void showStartInfo() {
        System.out.println("""
                "Добро пожаловать в консольный симулятор игры в шахматы.
                Игроки ходят по очереди, начиная с белых.
                Чтобы сделать ход, напишите номер поля, откуда хотите взять фигуру.
                Нажмите Enter.
                Чтобы передвинуть фигуру, напишите номер поля, куда собираетесь передвинуть фигуру.
                Нажмите Enter, передайте управление оппоненту.
                При некорректном вводе, повторите его.
                Ввод производится латинскими буквами.
                Пример ввода: h2
                Начинаю партию. Приятной игры.
                """);
    }

    static public void playerStep() {
        determineWalkingColour();
        takePiece();
        putPiece();
        checkGameWin();
    }

    static public void takePiece() {
        System.out.print("Взять фигуру с поля: ");
        String numSquareTakenPiece = scanner.nextLine();
        checkLengthNumSquareTakenPiece(numSquareTakenPiece);

        int firstIndex = getFirstIndex(numSquareTakenPiece);
        int secondIndex = getSecondIndex(numSquareTakenPiece);

        ChessPiece takenPiece = chessBoard[firstIndex][secondIndex];
        takenPiece.checkIsPieceHere();


    }

    public static void determineWalkingColour() {
        for (int i = 0; !win; i++) {
            if (i % 2 == 0) {
                walkingColour = 'w';
                System.out.println("Ход белых.");
            } else {
                walkingColour = 'b';
                System.out.println("Ход чёрных.");
            }
        }
    }

    public static int getSecondIndex(String numSquareTakenPiece) {
        int secondIndex = 666;
        int col = numSquareTakenPiece.charAt(0);

        switch (col) {
            case 'a':
                secondIndex = 0;
            case 'b':
                secondIndex = 1;
            case 'c':
                secondIndex = 2;
            case 'd':
                secondIndex = 3;
            case 'e':
                secondIndex = 4;
            case 'f':
                secondIndex = 5;
            case 'g':
                secondIndex = 6;
            case 'h':
                secondIndex = 7;
            default:
                System.out.println("Некорректный ввод. Пожалуйста повторите.");
                takePiece();
        }
        return secondIndex;
    }

    public static int getFirstIndex(String numSquareTakenPiece) {
        int firstIndex = 666;
        int row = numSquareTakenPiece.charAt(1);

        switch (row) {
            case 1:
                firstIndex = 7;
            case 2:
                firstIndex = 6;
            case 3:
                firstIndex = 5;
            case 4:
                firstIndex = 4;
            case 5:
                firstIndex = 3;
            case 6:
                firstIndex = 2;
            case 7:
                firstIndex = 1;
            case 8:
                firstIndex = 0;
            default:
                System.out.println("Некорректный ввод. Пожалуйста повторите.");
                takePiece();
        }
        return firstIndex;
    }

    public static void checkLengthNumSquareTakenPiece(String numSquareTakenPiece) {
        if (numSquareTakenPiece.length() != 2) {
            System.out.println("Некорректный ввод. Пожалуйста повторите.");
            takePiece();
        }
    }

    public static void putPiece() {

    }

    public static void checkGameWin() {}


    public void movementPieces() {

//        //хождния для пешки
//        if ((takenFiguara.row + 1 != squareForMove.row) && (takenFiguara.col - 1 > squareForMove.col || takenFiguara.col + 1 < squareForMove.col)) {
//            System.out.println("ERROR");
//        }
//
//        if ((takenFiguara.row - 1 == squareForMove.row) && (takenFiguara.col - 1 <= squareForMove.col || takenFiguara.col + 1 >= squareForMove.col)) {
//        }
//
//        //хождение для туры
//        if (!((takenFiguara.row == squareForMove.row) && (takenFiguara.col != squareForMove.col))
//        !((takenFiguara.col == squareForMove.col) && (takenFiguara.row != squareForMove.row))){
//            System.out.println("ERROR");
//        }
    }
}
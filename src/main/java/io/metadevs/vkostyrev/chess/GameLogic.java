package io.metadevs.vkostyrev.chess;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;

//TODO сделать всё двумя thread и обновлять каждый ход (enter) доску и ввод
//TODO сделать запрос истории в виде вывода на экран досок (реализация с помощью хранения принтов досок в массиве)

abstract public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static int countGameSteps = 0;
    public static boolean win = false;
    public static char walkingColour;

    public static void startGame() {
        //TODO сделать класс Game и создать при новой игре его объект, дать классу поля,  чтобы методы ниже н были static

        showStartInfo();
        assembleChessBoard();

        while (!win) {
            playerStep();
        }
    }

    public static void showStartInfo() {
        System.out.println("""
                "Добро пожаловать в консольный симулятор игры в шахматы.
                Соперники ходят по очереди, начиная с белых.
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

    public static void playerStep() {
        while (!win) {
            determineWalkingColour();
            ChessPiece takenPiece = takePiece();
            movePiece(takenPiece);
            checkGameWin();                                //TODO добавить реализацию
            countGameSteps++;
            printChessBoard();
        }
    }

    public static ChessPiece takePiece() {
        System.out.print("Взять фигуру с поля: ");
        ChessPiece takenPiece = getChessPiece();

        takenPiece.checkIsPieceHere();
        takenPiece.checkIsTakePieceMineColour();
        //TODO проверка kingUnderAttack
        //TODO проверка не заблокирована ли фигура
        return takenPiece;
    }

    public static void movePiece(ChessPiece takenPiece) {
        System.out.print("Поставить фигуру на поле: ");
        ChessPiece squareForMove = getChessPiece(); //              TODO нейминг данного метода

        takenPiece.checkIsMayPieceWalkThat(squareForMove);
        takenPiece.checkIsThereObstacleAlongPath(squareForMove);
        takenPiece.checkIsThereObstacleAtEndPath(squareForMove);
        takenPiece.putPiece(squareForMove);
    }

    public static ChessPiece getChessPiece() {
        String numSquare = scanner.nextLine();
        checkInputLengthNumSquare(numSquare);

        int firstIndex = getFirstIndex(numSquare);
        int secondIndex = getSecondIndex(numSquare);
        ChessPiece gottenPiece = chessBoard[firstIndex][secondIndex];
        gottenPiece.row = firstIndex;
        gottenPiece.col = secondIndex;
        return gottenPiece;
    }

    public static void determineWalkingColour() {
        if (countGameSteps % 2 == 0) {
            walkingColour = 'w';
            System.out.println("Ход белых.");
        } else {
            walkingColour = 'b';
            System.out.println("Ход чёрных.");
        }
    }

    public static int getFirstIndex(String numSquareTakenPiece) {
        int firstIndex = 666;
        int row = numSquareTakenPiece.charAt(1);

        switch (row) {
            case '1' -> firstIndex = 7;
            case '2' -> firstIndex = 6;
            case '3' -> firstIndex = 5;
            case '4' -> firstIndex = 4;
            case '5' -> firstIndex = 3;
            case '6' -> firstIndex = 2;
            case '7' -> firstIndex = 1;
            case '8' -> firstIndex = 0;
            default -> {
                System.out.println("Некорректный ввод. Пожалуйста повторите.");
                takePiece();
            }
        }
        return firstIndex;
    }

    public static int getSecondIndex(String numSquareTakenPiece) {
        int secondIndex = 666;
        int col = numSquareTakenPiece.charAt(0);

        switch (col) {
            case 'a' -> secondIndex = 0;
            case 'b' -> secondIndex = 1;
            case 'c' -> secondIndex = 2;
            case 'd' -> secondIndex = 3;
            case 'e' -> secondIndex = 4;
            case 'f' -> secondIndex = 5;
            case 'g' -> secondIndex = 6;
            case 'h' -> secondIndex = 7;
            default -> {
                System.out.println("Некорректный ввод. Пожалуйста повторите.");
                takePiece();
            }
        }
        return secondIndex;
    }

    public static void checkInputLengthNumSquare(String numSquareTakenPiece) {
        if (numSquareTakenPiece.length() != 2) {
            System.out.println("Некорректный ввод. Пожалуйста повторите.");
            takePiece();
        }
    }

    public static void checkGameWin() {
        //TODO проверка мата вражескому королю
    }

}
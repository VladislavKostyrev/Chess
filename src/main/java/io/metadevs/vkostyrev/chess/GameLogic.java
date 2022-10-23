package io.metadevs.vkostyrev.chess;

import java.util.Scanner;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;

//TODO реализовать пат, все виды ничьи тп

//TODO сделать всё двумя thread и обновлять каждый ход (enter) доску и ввод
//TODO сделать запрос истории в виде вывода на экран досок (реализация с помощью хранения принтов досок в массиве)

abstract public class GameLogic {
    public static int countGameSteps = 0;
    public static boolean win = false;
    public static char walkingColour;
    public static boolean isStepCorrect;

    //todo в конце партии обнулить все статик переменные

    public static void playGame() {
        //TODO сделать класс Game(партия) и создать при новой игре его объект, дать классу поля,  чтобы методы ниже не были static

        showStartInfo();
        assembleChessBoard();

        while (!win) {
            makeStep();
        }

        System.out.println("Спасибо за игру.");
        //TODO предложить еще партию
    }

    private static void showStartInfo() {
        System.out.println("""
                "Добро пожаловать в консольный симулятор игры в шахматы.
                Соперники ходят по очереди, начиная с белых.
                Чтобы сделать ход, введите координаты поля, с которого хотите взять фигуру.
                Нажмите Enter.
                Чтобы передвинуть фигуру, введите координаты поля, на которое собираетесь передвинуть фигуру.
                Нажмите Enter.
                Передайте управление оппоненту.
                При некорректном вводе, повторите его.
                Ввод производится латинскими буквами.
                Пример ввода: h2
                Начинаю партию. Приятной игры.
                """);
    }

    public static void makeStep() {
        determineWalkingColour();
        ChessPiece takenPiece = takePiece();
        movePiece(takenPiece);
        checkGameWin();                                //TODO добавить реализацию
        countGameSteps++;
        showChessBoard();
    }

    public static void determineWalkingColour() {
        if (countGameSteps % 2 == 0) {
            walkingColour = 'w';
            System.out.println("Ход белых.");
            return;
        }
        walkingColour = 'b';
        System.out.println("Ход чёрных.");
    }

    public static ChessPiece takePiece() {
        ChessPiece takenPiece;

        do {
            isStepCorrect = true;
            System.out.print("Взять фигуру с поля: ");
            takenPiece = getChessboardSquare();                         //todo нейминг метода
            takeChecks(takenPiece);
        } while (!isStepCorrect);
        return takenPiece;
    }

    public static void movePiece(ChessPiece takenPiece) {
        ChessPiece squareForMove;

        do {
            isStepCorrect = true;
            System.out.print("Поставить фигуру на поле: ");
            squareForMove = getChessboardSquare();                         //todo нейминг метода
            moveChecks(takenPiece);
        } while (!isStepCorrect);
        takenPiece.putPiece(squareForMove);
    }

    private static ChessPiece getChessboardSquare() {
        boolean isSquarePositionInputCorrect;
        String squarePosition;

        do {
            isSquarePositionInputCorrect = true;
            squarePosition = new Scanner(System.in).nextLine();
            isSquarePositionInputCorrect = checkSquarePositionInput(squarePosition);
        } while (!isSquarePositionInputCorrect);

        ChessPiece selectedSquare = chessBoard[getFirstIndex(squarePosition)][getSecondIndex(squarePosition)];
//        System.out.println(selectedSquare.row + " " + selectedSquare.col);   //todo удалить
//        selectedSquare.row = getFirstIndex(squarePosition);
//        selectedSquare.col = getSecondIndex(squarePosition);
        return selectedSquare;
    }

    private static int getFirstIndex(String squarePosition) {
        switch (squarePosition.charAt(1)) {
            case '1':
                return 7;
            case '2':
                return 6;
            case '3':
                return 5;
            case '4':
                return 4;
            case '5':
                return 3;
            case '6':
                return 2;
            case '7':
                return 1;
            case '8':
                return 0;
            default:
                return 666;
        }
    }

    private static int getSecondIndex(String squarePosition) {
        switch (squarePosition.charAt(0)) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:                                           //todo что делать с этими меджик намбер
                return 666;
        }
    }

    private static boolean checkSquarePositionInput(String squarePosition) {
        boolean isSquarePositionInputCorrect;
        isSquarePositionInputCorrect = checkInputtedSquarePositionLength(squarePosition);
        isSquarePositionInputCorrect = checkInputtedSquarePositionVertical(squarePosition);
        isSquarePositionInputCorrect = checkInputtedSquarePositionHorizontal(squarePosition);

        if (!isSquarePositionInputCorrect)
            System.out.println("Некорректный ввод координат. Пожалуйста повторите.");
        return isSquarePositionInputCorrect;
    }

    private static boolean checkInputtedSquarePositionLength(String squarePosition) {
        if (squarePosition.length() != 2)
            return false;
        return true;
    }

    private static boolean checkInputtedSquarePositionHorizontal(String squarePosition) {
        if (squarePosition.charAt(1) != '1' && squarePosition.charAt(1) != '2'
                && squarePosition.charAt(1) != '3' && squarePosition.charAt(1) != '4'
                && squarePosition.charAt(1) != '5' && squarePosition.charAt(1) != '6'
                && squarePosition.charAt(1) != '7' && squarePosition.charAt(1) != '8') {
            return false;
        }
        return true;
    }

    private static boolean checkInputtedSquarePositionVertical(String squarePosition) {
        if (squarePosition.charAt(0) != 'a' && squarePosition.charAt(0) != 'b'
                && squarePosition.charAt(0) != 'c' && squarePosition.charAt(0) != 'd'
                && squarePosition.charAt(0) != 'e' && squarePosition.charAt(0) != 'f'
                && squarePosition.charAt(0) != 'g' && squarePosition.charAt(0) != 'h') {
            return false;
        }
        return true;
    }

    private static void moveChecks(ChessPiece takenPiece) {
        //todo есть ли препятствие по пути и в конце
        //todo проверка не сьели ли короляч1
    }

    private static void takeChecks(ChessPiece takenPiece) {
        boolean isTakeChecksSuccessful;

        isTakeChecksSuccessful = ChessPiece.isPieceHere(takenPiece);
        takenPiece.isTakePieceMineColour();
        //TODO нельзя ставить откуда взял?
        //TODO проверка kingUnderAttack
        //TODO проверка не заблокирована ли фигура
    }

    public static void checkGameWin() {
        //TODO проверка мата вражескому королю
    }
}
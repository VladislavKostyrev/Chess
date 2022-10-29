package io.metadevs.vkostyrev.chess;

import java.util.Scanner;

import static io.metadevs.vkostyrev.chess.ChessBoard.*;

//TODO реализовать пат, все виды ничьи тп

//TODO сделать всё двумя thread и обновлять каждый ход (enter) доску и ввод
//TODO сделать запрос истории в виде вывода на экран досок (реализация с помощью хранения принтов досок в массиве)

abstract public class GameLogic {
    public static int countGameSteps;
    public static boolean win;
    public static char walkingColour;
    public static boolean isActionCorrect;                //todo нейминг
    public static String errorMessage;

    public static void playGame() {                       //TODO сделать класс Game(партия) и создать при новой игре его объект, дать классу поля, чтобы методы ниже не были static?
        showStartInfo();
        assembleChessBoard();

        while (!win) {
            makeStep();
        }

        repeatOrExit();
    }

    public static void repeatOrExit() {
        String answer;
        System.out.println("Спасибо за игру." +
                "Ещё партию? Введите \"Да\" или \"Нет\" и нажмите Enter.");
        do {
            isActionCorrect = true;
            answer = new Scanner(System.in).nextLine();
            checkCorrectnessAnswer(answer);
        } while (!isActionCorrect);

        if (answer.equals("Да"))
            playGame();
    }

    private static void checkCorrectnessAnswer(String answer) {
        if (!answer.equals("Да") && !answer.equals("Нет")) {
            System.out.println("Некорректный ввод. Пожалуйста, введите \"Да\" или \"Нет\" и нажмите Enter.");
            isActionCorrect = false;
        }
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
        showChessBoard();
//        determineWalkingColour();
        ChessPiece takenPiece = takePiece();
        movePiece(takenPiece);
        checkGameWin();                                //TODO добавить реализацию
        countGameSteps++;
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
            isActionCorrect = true;                                       //мб чек корект?
            System.out.print("Взять фигуру с поля: ");
            takenPiece = appointChessboardSquare();                         //todo нейминг метода
            doChecksForTake(takenPiece);
        } while (!isActionCorrect);
        return takenPiece;
    }

    public static void movePiece(ChessPiece takenPiece) {
        ChessPiece squareForMove;

        do {
            isActionCorrect = true;
            System.out.print("Поставить фигуру на поле: ");
            squareForMove = appointChessboardSquare();                         //todo нейминг метода
            moveChecks(takenPiece, squareForMove);
        } while (!isActionCorrect);
        takenPiece.putPiece(squareForMove);
    }

    private static ChessPiece appointChessboardSquare() {
        String squarePosition;

        do {
            isActionCorrect = true;
            squarePosition = new Scanner(System.in).nextLine();
            checkSquarePositionInput(squarePosition);
        } while (!isActionCorrect);

        return chessBoard[getFirstIndex(squarePosition)][getSecondIndex(squarePosition)];
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

    private static void checkSquarePositionInput(String squarePosition) {
        checkInputtedSquarePositionLength(squarePosition);
        checkInputtedSquarePositionVertical(squarePosition);
        checkInputtedSquarePositionHorizontal(squarePosition);
        if (!isActionCorrect)
            System.out.println("Некорректный ввод координат. Пожалуйста повторите.");
    }

    private static void checkInputtedSquarePositionLength(String squarePosition) {
        if (squarePosition.length() != 2)
            isActionCorrect = false;
    }

    private static void checkInputtedSquarePositionHorizontal(String squarePosition) {
        if (squarePosition.charAt(1) != '1' && squarePosition.charAt(1) != '2'
                && squarePosition.charAt(1) != '3' && squarePosition.charAt(1) != '4'
                && squarePosition.charAt(1) != '5' && squarePosition.charAt(1) != '6'
                && squarePosition.charAt(1) != '7' && squarePosition.charAt(1) != '8') {
            isActionCorrect = false;
        }
    }

    private static void checkInputtedSquarePositionVertical(String squarePosition) {
        if (squarePosition.charAt(0) != 'a' && squarePosition.charAt(0) != 'b'
                && squarePosition.charAt(0) != 'c' && squarePosition.charAt(0) != 'd'
                && squarePosition.charAt(0) != 'e' && squarePosition.charAt(0) != 'f'
                && squarePosition.charAt(0) != 'g' && squarePosition.charAt(0) != 'h') {
            isActionCorrect = false;
        }
    }

    private static void doChecksForTake(ChessPiece takenPiece) {
        errorMessage = "";

        takenPiece.checkPiecePresence();
        takenPiece.checkPieceColourCorrect();
        takenPiece.checkPieceNotBlocked();
        takenPiece.checkKingUnderAttack();
        System.out.println(errorMessage);
    }

    private static void moveChecks(ChessPiece takenPiece, ChessPiece squareForMove) {
        takenPiece.checkCanPieceMove(squareForMove);
        takenPiece.checkThereObstacleAtEndPath(squareForMove);
        takenPiece.checkPieceNotBeKing(squareForMove);                           //todo нейминг
    }

    public static void checkGameWin() {                        //todo закончить
        //TODO проверка мата вражескому королю
    }

    public static void fillErrorMessage(String eErrorMessage) {
        if (errorMessage.length() > 0)
            return;
        errorMessage = eErrorMessage;                                 //todo нейминг
    }
}
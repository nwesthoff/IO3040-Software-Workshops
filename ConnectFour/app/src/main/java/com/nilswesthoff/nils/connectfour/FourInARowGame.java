package com.nilswesthoff.nils.connectfour;

public class FourInARowGame {
    private int[] numberOfEmptyColumnCells = new int[]{6, 6, 6, 6, 6, 6, 6};
    private int[][] board = new int[6][7];
    private int playerId = 1;
    int playerWhoWon = 0;

    public int dropDisc(int column) {
        showBoard();

        if (column >= 1 && column <= 7) {
            int emptyColumnCells = numberOfEmptyColumnCells[column - 1];
            if (emptyColumnCells > 0) {
                board[emptyColumnCells - 1][column - 1] = playerId;
                numberOfEmptyColumnCells[column - 1] = emptyColumnCells - 1;

                checkForEndOfGame();

                playerId = (playerId == 1 ? 2 : 1);
            }
            return emptyColumnCells;
        }

        return 0;
    }

    private void showBoard() {
        System.out.println("Four in a row game board:");
        for (int rowIndex = 0; rowIndex < 6; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 7; columnIndex++)
                System.out.print(String.valueOf(board[rowIndex][columnIndex]));
            System.out.println();
        }
    }

    private void checkForEndOfGame() {
        if (currentPlayerWon()) {
            playerWhoWon = playerId;
        } else if (isBoardFull()) {
            playerWhoWon = 3;
        }
    }

    public int getResult() {
        return playerWhoWon;
    }

    private boolean currentPlayerWon() {
        return false;
    }

    private boolean isBoardFull() {
        for (int columnIndex = 6; columnIndex >= 0; columnIndex--)
            if (numberOfEmptyColumnCells[columnIndex] > 0)
                return false;
        return true;
    }

}

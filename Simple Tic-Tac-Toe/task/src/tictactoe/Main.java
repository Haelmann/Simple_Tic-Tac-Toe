package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var play = new gameField();
        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        int row, col;
        play.printField();
        while (true){
            try {
                System.out.println("Enter the coordinates: ");
                row = scanner.nextInt();
                row--;
                col = scanner.nextInt();
                col--;

            } catch (NumberFormatException e){
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }
            if (row > 2 | row < 0 | col > 2 | col < 0){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (!play.trySetField(row, col, player)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            play.printField();
            if (play.victoryForPlayer('X') | play.victoryForPlayer('O')){
                System.out.printf("%s wins!%n", player);
                break;
            }
            switch (player){
                case 'X':
                    player = 'O';
                    break;
                case 'O':
                    player = 'X';
                    break;
            }

        }
    }


}

class gameField {

    private char[][] field = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public boolean victoryForPlayer(char player) {
        return (field[0][0] == player & field[0][1] == player & field[0][2] == player) |
                (field[1][0] == player & field[1][1] == player & field[1][2] == player) |
                (field[2][0] == player & field[2][1] == player & field[2][2] == player) |
                (field[0][0] == player & field[1][0] == player & field[2][0] == player) |
                (field[0][1] == player & field[1][1] == player & field[2][1] == player) |
                (field[0][2] == player & field[1][2] == player & field[2][2] == player) |
                (field[0][0] == player & field[1][1] == player & field[2][2] == player) |
                (field[0][2] == player & field[1][1] == player & field[2][0] == player);
    }

    public void printField() {
        System.out.println("---------");
        System.out.printf("| %s %s %s |%n", field[0][0], field[0][1], field[0][2]);
        System.out.printf("| %s %s %s |%n", field[1][0], field[1][1], field[1][2]);
        System.out.printf("| %s %s %s |%n", field[2][0], field[2][1], field[2][2]);
        System.out.println("---------");
    }

    public char getField(int row, int col) {
        return field[row][col];
    }

    public boolean trySetField(int row, int col, char player) {
        if (this.field[row][col] == ' ') {
            this.field[row][col] = player;
            return true;

        } else if (!(this.field[row][col] == ' ')) {
            return false;
        }
        return false;
    }
}
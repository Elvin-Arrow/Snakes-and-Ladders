

import javax.swing.*;
import java.util.Random;

public class GamePlay implements Playable{
    private Player[] players;
    private Snadder[] snakes;
    private Snadder[] ladders;
    private int playerNumber;

    public GamePlay(){
        players = new Player[2];
        snakes = new Snadder[8];
        ladders = new Snadder[7];
        initializePlayers();
        initializeSnakesAndLadders();
        playerNumber = 0;

    }

    public void makeMove(int rollNum){
        int currentPlayerPosition = players[playerNumber].getPosition();
        int newPlayerPosition = currentPlayerPosition + rollNum;

        if (newPlayerPosition < 100){
            players[playerNumber].setPosition(newPlayerPosition);
            //Check for snake and ladder and makes appropriate changes
            ladderClimb();
            snakeBite();

        }
        else if (newPlayerPosition == 100) {
            String winnerMessage = "Player " + (playerNumber + 1) + " has won the game!";
            System.out.println(winnerMessage);
            players[playerNumber].setPosition(newPlayerPosition);
            JOptionPane.showMessageDialog(null, winnerMessage);
            System.exit(0);
        }

    }

    private void initializePlayers(){
        for (int i = 0; i < this.players.length; i++){
            this.players[i] = new Player();
        }
    }

    private void initializeSnakesAndLadders(){
        //Snakes
        snakes[0] = new Snadder(27, 5);
        snakes[1] = new Snadder(40, 3);
        snakes[2] = new Snadder(43, 18);
        snakes[3] = new Snadder(54, 31);
        snakes[4] = new Snadder(66, 45);
        snakes[5] = new Snadder(76, 58);
        snakes[6] = new Snadder(89, 53);
        snakes[7] = new Snadder(99, 41);

        //Ladders
        ladders[0] = new Snadder(4, 25);
        ladders[1] = new Snadder(13, 46);
        ladders[2] = new Snadder(33, 49);
        ladders[3] = new Snadder(42, 63);
        ladders[4] = new Snadder(50, 69);
        ladders[5] = new Snadder(62, 81);
        ladders[6] = new Snadder(74, 92);
    }

    private void snakeBite(){
        for (Snadder snake:snakes){
            if (snake.getStartPoint() == players[playerNumber].getPosition()) {
                players[playerNumber].setPosition(snake.getEndPoint());
                System.out.println("Snake!");
            }
        }

    }

    private void ladderClimb(){

        //Check for ladder at current position
        for (Snadder ladder:ladders){
            if (ladder.getStartPoint() == players[playerNumber].getPosition()) {
                players[playerNumber].setPosition(ladder.getEndPoint());
                System.out.println("Ladder");
            }
        }

    }

    public int getPlayerNumber(){
        return this.playerNumber;
    }

    public int getPlayerPosition(){
        return this.players[playerNumber].getPosition();
    }


    public void swapPlayers(){
        if (playerNumber== 0){
            playerNumber = 1;
        }
        else
            playerNumber = 0;
    }

    @Override
    public int dice() {
        Random dice = new Random();

        return dice.nextInt(6) + 1;
    }
}

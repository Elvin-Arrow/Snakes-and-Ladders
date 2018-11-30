

public class Player {
    private static int playerCount = 0;

    private int playerNumber;
    private int position;

    public Player(){
        countPlayer();
        this.playerNumber = playerCount;
        this.position = 0;
    }

    //Setters
    public void setPosition(int position){
        this.position = position;
    }


    //Getters
    public int getPosition(){
        return this.position;
    }

    public int getPlayerNumber(){
        return this.playerNumber;
    }

    //Misc
    private static void countPlayer(){
        playerCount++;
    }


}

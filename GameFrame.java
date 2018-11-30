

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    private JFrame frame;
    private GameBoard board;
    private ButtonPanel buttons;

    public GameFrame(){
        frame = new JFrame("Snakes and ladders");
        frame.setSize(620, 660);
        frame.setLayout(new BorderLayout());

        board = new GameBoard();
        buttons = new ButtonPanel(board);
        buttons.getGameParent(this);

        frame.add(buttons, BorderLayout.SOUTH);
        frame.setVisible(true);

        frame.add(board, BorderLayout.CENTER);
        frame.setVisible(true);



    }

    public void callMoveIcon(int playerNum, int playerPosition){
        board.moveIcon(playerNum, playerPosition);
    }
}

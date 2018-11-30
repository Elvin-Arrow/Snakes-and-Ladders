
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Commands {
    /*
    private JButton closeButton;
    private JButton diceRoll;
    private GamePlay game;
    private JLabel rollLabel;
    private int turn;
    private int temp_y = 40;
    private int temp_x = 35;

    public Commands(){
        super();
        super.setBackground(Color.WHITE);
        super.setLayout(new BorderLayout());

        closeButton = new JButton("Close");
        this.add(closeButton, BorderLayout.WEST);
        closeButton.addActionListener(this);

        diceRoll = new JButton("Roll");
        this.add(diceRoll, BorderLayout.EAST);
        diceRoll.addActionListener(this);

        rollLabel = new JLabel("", JLabel.CENTER);
        this.add(rollLabel, BorderLayout.CENTER);


        game = new GamePlay();
        turn = 0;
    }


    public void actionPerformed(ActionEvent event){
        Object eventHolder = event.getSource();

        if (eventHolder == closeButton){
            System.exit(0);
        }
        else{

            int rollNum = game.dice();
            String item = "Player " + (this.turn + 1) + " rolled: " + rollNum;
            System.out.println("Player " + (this.turn + 1) + " rolled: " + rollNum);
            game.makeMove(rollNum, this.turn);
            swapPlayers();
            rollLabel.setText(item);


        }

    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillOval(35, 40, 40, 40);
        //g.drawOval(100, 100, 10, 10);

        temp_x += 54;
        temp_y += 54;


    }

    private void swapPlayers(){
        if (this.turn == 0){
            this.turn = 1;
        }
        else
            this.turn = 0;
    }
    */
}

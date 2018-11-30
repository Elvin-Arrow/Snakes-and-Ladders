import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener, Playable{
    private JButton closeButton;
    private JButton diceRoll;
    private JLabel rollLabel;
    private Playable game;
    private GameFrame parent;

    public ButtonPanel(GameBoard gamePanel){
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

    }

    public void actionPerformed(ActionEvent event){
        Object eventHolder = event.getSource();

        if (eventHolder == closeButton){
            System.exit(0);
        }

        else{
            int rollNum = game.dice();

            String item = "Player " + (game.getPlayerNumber() + 1) + " rolled: " + rollNum;
            System.out.println(item);
            rollLabel.setText(item);

            game.makeMove(rollNum);

            parent.callMoveIcon(game.getPlayerNumber(), game.getPlayerPosition());

            game.swapPlayers();
        }
    }

    public void getGameParent(GameFrame f){
        this.parent = f;
    }


    @Override
    public void makeMove(int rollNum) {

    }

    @Override
    public void swapPlayers() {

    }

    @Override
    public int dice() {
        return 0;
    }

    @Override
    public int getPlayerNumber() {
        return 0;
    }

    @Override
    public int getPlayerPosition() {
        return 0;
    }
}

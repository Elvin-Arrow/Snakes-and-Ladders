

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private Image img;
    private Point[] points;

    public GameBoard() {
        super();
        img = new ImageIcon("D:\\University\\Object Oriented Programming\\Lab\\src\\SnakeAndLadder\\Game.jpg").getImage();
        points = new Point[2];
        points[0] = new Point();
        points[1] = new Point();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 1, 1, this);

        //First player
        g.setColor(Color.BLUE);
        g.fillOval(points[0].x, points[0].y, 40, 40);

        //Second player
        g.setColor(Color.RED);
        g.fillOval(points[1].x, points[1].y, 40, 40);

    }


    public void moveIcon(int playerNum, int newPlayerPosition) {
        int currentPlayerPosition = getCurrentPlayerPosition(playerNum);
        if (currentPlayerPosition < newPlayerPosition)
            points[playerNum] = getNewForwardPoint(currentPlayerPosition, newPlayerPosition, playerNum);
        else
            points[playerNum] = getNewBackwardPoint(currentPlayerPosition, newPlayerPosition, playerNum);

                    super.repaint();

    }

    private int getCurrentPlayerPosition(int currentPlayer){
        int position = 1;
        Point current = new Point(points[currentPlayer]);
        Point newPoint = new Point();

        while (newPoint.x != current.x || newPoint.y != current.y){
            position++;
            if (points[currentPlayer].flow_y){
                newPoint.decreaseY();
                points[currentPlayer].flow_y = false;
                points[currentPlayer].flow_x = !points[currentPlayer].flow_x;
            }
            else {
                if (points[currentPlayer].flow_x) {
                    newPoint.increaseX();
                } else
                    newPoint.decreaseX();
            }
            if (position % 10 == 0)
                points[currentPlayer].flow_y = true;
        }

        return position;
    }

    private Point getNewForwardPoint(int currentPlayerPosition, int newPlayerPosition, int currentPlayer){
        Point point = new Point(points[currentPlayer]);

        int currentPosition = currentPlayerPosition;

        while (currentPosition < newPlayerPosition){
            currentPosition++;

            if (points[currentPlayer].flow_y){
                point.decreaseY();
                points[currentPlayer].flow_y = false;
                points[currentPlayer].flow_x = !points[currentPlayer].flow_x;
            }
            else {
                if (points[currentPlayer].flow_x) {
                    point.increaseX();
                } else
                    point.decreaseX();
            }

            if (currentPosition % 10 == 0){
                points[currentPlayer].flow_y = true;
            }
        }

        return point;
    }

    private Point getNewBackwardPoint(int newCurrentPosition, int playerNewPosition, int currentPlayer){
        //Declaration block
        Point point = new Point(points[currentPlayer]);
        int currentPosition = newCurrentPosition;
        if (currentPosition == 11 || currentPosition == 21 || currentPosition == 31 || currentPosition == 41
        || currentPosition == 51 || currentPosition == 61 || currentPosition == 71 || currentPosition == 81
        || currentPosition == 91){
            points[currentPlayer].flow_y = true;
        }
        //Working block
        while (currentPosition > playerNewPosition){
            currentPosition--;

            if (points[currentPlayer].flow_y){
                point.increaseY();
                points[currentPlayer].flow_y = false;
                points[currentPlayer].flow_x = !points[currentPlayer].flow_x;
            }
            else {
                if (points[currentPlayer].flow_x) {
                    point.decreaseX();
                } else
                    point.increaseX();
            }

            if ((currentPosition - 1) % 10 == 0){
                points[currentPlayer].flow_y = true;
            }
        }

        return point;
    }

    private class Point{
        private int x;
        private int y;
        private boolean flow_x;
        private boolean flow_y;

        private Point(){
            x = 35;
            y = 525;
            flow_x = true;
            flow_y = false;
        }

        private Point(int x, int y){
            updatePoint(x, y);
        }

        private Point(Point anotherPoint){
            this.x = anotherPoint.x;
            this.y = anotherPoint.y;
            this.flow_x = true;
            this.flow_y = false;
            //this.flow_x = anotherPoint.flow_x;
            //this.flow_y = anotherPoint.flow_y;
        }

        private void updatePoint(int x, int y){
            this.x = x;
            this.y = y;
        }

        private boolean getFlow_X(){
            return flow_x;
        }

        private boolean getFlow_Y(){
            return flow_y;
        }

        private void increaseX(){
            this.x += 54;
        }

        private void decreaseX(){
            this.x -= 54;
        }

        private void increaseY(){
            this.y += 54;
        }

        private void decreaseY(){
            this.y -= 54;
        }

    }
}

package main;

import chipCard.Chip_Card;
import chipCard.SuperChip;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MouseHandler implements MouseListener, MouseWheelListener, MouseMotionListener {
    boolean dragged = false;
    String name = "City1";
    boolean released;
    boolean p =false;
    public boolean check=true;
    public boolean check2=true;
    public double scale = 1;

    public int x;
    public int y;
    int ont;

    SuperChip[] chip = new Chip_Card[72];

    public Point point = null;//setting initial parameters
    private Point start = null;//setting initial parameters
    private Point finish = null;//setting initial parameters
    private int size = 0;//setting initial parameters
    private int size1 = 0;//setting initial parameters

    private int size2 = 0;//setting initial parameters
    private GamePanel gp;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        point = new Point((int) (mouseEvent.getX()), (int) (mouseEvent.getY()));
        if(p) check2=false;
        else {
            check = false;
        }

        x=mouseEvent.getX();
        y= mouseEvent.getY();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        start = new Point((int) (mouseEvent.getX()), (int) (mouseEvent.getY()));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released =true;


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        finish = new Point((int) (mouseEvent.getX()), (int) (mouseEvent.getY()));

        size = (int) Math.min(Math.abs(finish.x - start.x),
                Math.abs(finish.y - start.y));
        size1 = (int) (finish.x - start.x);
        size2 = (int) (finish.y - start.y);

        dragged = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scale *= Math.exp((double) e.getWheelRotation() / 10);
        if(scale>2) scale =2;
        if(scale<0.1) scale =0.1;

    }
}
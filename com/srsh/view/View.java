package com.srsh.view; /**
 * Created by erosa on 2017. 05. 05..
 */

import com.srsh.controller.Controller;
import com.srsh.model.*;
import com.srsh.model.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class View {
    protected JFrame frame;
    protected JPanel panel;
    protected ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    protected Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        frame = new JFrame("srsh magic vonatos játék 1.0");
        frame.setSize(800, 800);
        panel = new JPanel() {
          @Override
            public void paintComponent(Graphics g){
              super.paintComponent(g);
              drawAll(g);
          }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               controller.handleClick(e.getX(), e.getY());
               panel.repaint();
            }
        });


        frame.add(panel);

    }


    /**
     * addss drawable map component given in the command which is divided to String[] params
     * @param params
     * @param c
     * @throws IOException
     */
    public void addComponent(String[] params, Component c) throws IOException {
        switch (params[4]) {
            case "Intersection":
                drawables.add(new GraphicIntersection((Intersection) c));
                break;
            case "Rail":
                drawables.add(new GraphicRail((Rail) c));
                break;
            case "Siding":
                drawables.add(new GraphicSiding((Siding) c));
                break;
            case "Station":
                drawables.add(new GraphicStation((Station) c));
                break;
            case "Switch":
                drawables.add(new GraphicSwitch((Switch) c));
                break;
            case "TunnelEnd":
                TunnelEnd t = (TunnelEnd)c;
                if(t.isActive()){
                    drawables.add(new GraphicTunnelEnd((TunnelEnd) c));
                }else{
                    drawables.add(new GraphicTunnelEnd((TunnelEnd) c));
                }
                break;
            default: break;
        }
        sortDrawables();
    }

    /**
     * adds drawable train components given in the command which is divided to String[] params
     * @param params
     * @param c
     * @throws IOException
     */
    public void addTrainComponent(String[] params, TrainComponent c) throws IOException {
        switch (params[2]) {
            case "CoalWagon":
                drawables.add(new GraphicCoalWagon((CoalWagon) c));
                break;
            case "Locomotive":
                drawables.add(new GraphicLocomotive((Locomotive) c));
                break;
            case "Wagon":
                drawables.add(new GraphicWagon((Wagon) c));
                break;
            default: break;
        }
        sortDrawables();
    }

    public void trainComponentDerailed(TrainComponent tc) {

    }

    public void rainComponentCollided(TrainComponent tc) {

    }

    public void _switch(Switch s) {

    }

    public void tunnelEndActivated(TunnelEnd end) {

    }

    public void tunnelActivated() {

    }

    public void addTunnel(Tunnel tunnel){
        drawables.add(new GraphicTunnel(tunnel, null));
    }

    /**
     * Draw all component
     */
    public void drawAll(Graphics g) {
        for (int i = 0; i < drawables.size(); i++) {
            drawables.get(i).draw(g);
        }
    }

    public void clear() {
        frame = new JFrame("srsh magic vonatos játék 1.0");
        frame.setSize(800, 800);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                drawAll(g);
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.handleClick(e.getX(), e.getY());
                panel.repaint();
            }
        });
        drawables.clear();

        frame.add(panel);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if(!controller.isGameOver())
                    controller.gameOver("Map not completed.");
                controller.setInGame(false);
            }
        });
    }

    public void setVisible(boolean value) {
        frame.setVisible(value);
    }

    public void invalidate(){
        panel.repaint();
    }

    public void gameOverDialog(String message){
        JOptionPane.showMessageDialog(frame,
                message,
                "Game Over",
                JOptionPane.ERROR_MESSAGE);
    }

    private void sortDrawables(){
        drawables.sort(new Comparator<Drawable>() {
            @Override
            public int compare(Drawable o1, Drawable o2) {
                return ((Integer)o1.z_index).compareTo(o2.z_index);
            }
        });
    }
}

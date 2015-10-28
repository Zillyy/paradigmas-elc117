package spaceship;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;

/**
 * Interface grafica de animacao de uma espaconave.
 *
 * @author andrea
 */
class SpaceShipGUI {

    public static void main(String[] args) {

        SpaceShip ship = new SpaceShip(50, 100);
        ship.setLimits(400, 400);
        SpaceShipAnim anim = new SpaceShipAnim(ship);
        showGUI(anim);

    }

    private static void showGUI(SpaceShipAnim anim) {
        JFrame f = new JFrame("Animation");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(anim);
        f.pack();
        f.setVisible(true);
        anim.run();
    }
}

// Representacao grafica de um SpaceShip.
class SpaceShipView {

    BufferedImage img;
    SpaceShip ship;
    static final String filename = "spaceship-small.png";

    public SpaceShipView(SpaceShip ship) {
        try {
            this.ship = ship;
            this.img = ImageIO.read(new File(getClass().getResource(filename).toURI()));
            replaceColor(ship.getColor());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(SpaceShipView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(img, ((int) ship.getX()), ((int) ship.getY()), null);
    }

    // Altera a cor do SpaceShip, pixel por pixel
    // (somente o corpo da espaconave)
    private void replaceColor(int c) {
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                if (img.getRGB(j, i) == SpaceShip.defaultColor) {
                    img.setRGB(j, i, c);
                }
            }
        }
    }
}

// Componente grafico que representa uma animacao de um SpaceShip.
class SpaceShipAnim extends Component {

    SpaceShipView view;
    SpaceShip ship;

    public SpaceShipAnim(SpaceShip ship) {
        this.ship = ship;
        view = new SpaceShipView(ship);
    }

    @Override
    public void paint(Graphics g) {
        view.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ship.getXmax(), ship.getYmax());
    }

    // Animacao: loop que move e redesenha a espaconave
    public void run() {
        while (true) {
            ship.moveCollision();
            ship.print();
            repaint();
            try {
                Thread.sleep(30); // pausa
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

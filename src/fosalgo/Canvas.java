package fosalgo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    double translateX;
    double translateY;
    double scale;

    Canvas() {
        translateX = 0;
        translateY = 0;
        scale = 1;
        setOpaque(false);
        setDoubleBuffered(true);
    }

    public void paint(Graphics g) {
        //---------------------------------------------------------------------------------------------------
        AffineTransform tx = new AffineTransform();
        tx.translate(translateX, translateY);
        tx.scale(scale, scale);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.9F));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setTransform(tx);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //---------------------------------------------------------------------------------------------------
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0, 0, 100, 60);
        //---------------------------------------------------------------------------------------------------
        g2d.dispose();
    }//end of paint

}

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * An example for the use of a GeneralPath to draw a car.
 *
 * @author Frank Klawonn
 * Last change 07.01.2005
 */
public class GeneralPathCar extends Frame
{
    //Constructor
    GeneralPathCar()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        //The GeneralPath to decribe the car.
        GeneralPath gp = new GeneralPath();

        //Start at the lower front of the car.
        gp.moveTo(20, 25);
        gp.lineTo(20, 87.5);
        gp.lineTo(115, 87.5);
        gp.lineTo(115, 141.5);
        gp.lineTo(170, 87.5);
        gp.lineTo(235, 87.5);
        gp.lineTo(205, 60);
        gp.lineTo(50, 60);
        gp.lineTo(20, 25);
        g2d.draw(gp);

        g2d.setStroke(new BasicStroke(1.0f));

        desenhaNuvens(g2d);
        desenhaPredios(g2d);
    }

    void desenhaPredios(Graphics2D g2d) {
        int larguraTela = g2d.getClip().getBounds().width;
        int x = 0;

        while (x <= larguraTela) {
            int larguraPredio = desenhaPredio(x, g2d);

            x += larguraPredio;

        }
    }

    int  desenhaPredio(int x, Graphics2D g2d) {
        int alturaTela = g2d.getClip().getBounds().height;

        Random random = new Random();

        int largura = random.nextInt(30, 100);
        int altura = random.nextInt(150, 250);

        g2d.fillRect(x, alturaTela-altura, largura, altura);

        return largura;

    }

    void desenhaNuvens(Graphics2D g2d) {
        Random random = new Random();

        for (int x = 0; x < 10; x++) {
            int diferenca_altura = random.nextInt(100,150);
            desenhaNuvem((x*100), diferenca_altura, g2d);
        }
    }

    void desenhaNuvem(int x, int y,Graphics2D g2d) {
        g2d.setColor(new Color(0,0,255));

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int altura = random.nextInt(20,50);
            int diferenca_y = random.nextInt(0,20);
            g2d.fillOval(x + (i*10),y + diferenca_y,50, altura);
        }
        g2d.setColor(new Color(0,0,0));
    }

    public static void main(String[] argv)
    {
        GeneralPathCar f = new GeneralPathCar();
        f.setTitle("GeneralPath example");
        f.setSize(800, 600);
        f.setVisible(true);
    }
}

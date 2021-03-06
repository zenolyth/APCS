
import java.awt.*;
import javax.swing.JApplet;
import java.awt.Color;

/**
 * Creates an American Flag.
 * 
 * @author	Emma Jiang
 * @version 9/7/17
 */
public class Flag extends JApplet {
	
	private final static Color OLDGLORYRED = new Color(0xBF0A30);
    private final static Color OLDGLORYBLUE = new Color(0x002868);
	
	private static final double B = 1.9;
	private static final double C = 0.5385;
	private static final double D = 0.76;
	private static final double F = 0.054;
	private static final double G = 0.063;
	private static final double K = 0.0616;
	private static final double L = 0.0769;
	
	private static final double pi = Math.PI;
	
	public Flag() {
		
	}
	
	public void paint(Graphics g) {
		
		int height = getHeight();
		int width = getWidth();
		
		//makes it so the flag would scale properly
		if (height * B <= width) {
            width = (int) (height * B);
            height = getHeight();
        } else {
            height = (int) (width / B);
        }
		
		paintFlag(g, height, width);
	}
	
	/**
	 * Draws the stripes, the union, and the stars on the flag.
	 * 
	 * @param height	height of the flag
	 * @param width		width of the flag
	 */
	public void paintFlag(Graphics g, int height, int width) {
		
		//draw stripes
		g.setColor(OLDGLORYRED);
		g.fillRect(0, 0, (int) width, (int) height);
		
		g.setColor(Color.WHITE);
		for (int j = 1; j <= 6; j++) {
			g.fillRect(0, (int) (2 * height * L * j - (height * L)), (int) (width), (int) (height * L));
		}
		
		//draw union
		g.setColor(OLDGLORYBLUE);
		g.fillRect(0, 0, (int) (height * D), (int) (height * C));
		
		//draw stars
		for(int i=0; i<11;i++){
			if(i % 2 == 0){
				
				//draws the stars in even rows
				stars(g, (int) (height * G + height * G * i), (int) (height * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 3 * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 5 * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 7 * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 9 * F), width, height);
				
			} else {

				//draws the stars in the odd rows
				stars(g, (int) (height * G + height * G * i), (int) (height * 2 * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 4 * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 6 * F), width, height);
				stars(g, (int) (height * G + height * G * i), (int) (height * 8 * F), width, height);
			}		
		}
	}

	/**
	 * A method that draws a star on the flag.
	 * 
	 * @param xc		x-coordinate of star
	 * @param yc		y-coordinate of star
	 * @param width		width of flag
	 * @param height	height of flag
	 */
	public void stars(Graphics g, int xc, int yc, int width, int height){
		
		//stores radius for stars
		int r[] = {(int) (height * K / 2), (int) (height * K / 4), (int) (height * K / 2), (int) (height * K / 4)};
		
		int[] X = new int[10];
		int[] Y = new int[10];
			
		//fills array to store points for the stars
		for (double i = 0.0; i < 10; i++)
		{
			int j = (int) i;
			double x = Math.cos(i * ((2 * pi) / 10) + 60) * r[j % 4];
			double y = Math.sin(i * ((2 * pi) / 10) + 60) * r[j % 4];

			X[j] = (int) x + xc;
			Y[j] = (int) y + yc;
		}

		//color the stars
		g.setColor(Color.WHITE);
		g.fillPolygon(X, Y, 10);
	}
	
	public static void main(String[] args) {
		Flag flag = new Flag();
	}
}

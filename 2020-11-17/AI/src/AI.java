import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentImg,img,img1,img2,img3,img4,img5;
	int x = 120;
	int y = 100;
	int l = 0;
	public MainCanvas(){
		try{
			img = Image.createImage("/sayo10.png");
			img1 = Image.createImage("/sayo12.png");
			img2 = Image.createImage("/sayo14.png");
			img3 = Image.createImage("/sayo16.png");
			img4 = Image.createImage("/sayo02.png");
			img5 = Image.createImage("/sayo22.png");
			currentImg = img;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == DOWN){
			currentImg = img;
			System.out.println("turn down");
			y += 1;
			repaint();
		}

		if(action == LEFT){
			currentImg = img1;
			System.out.println("turn left");
			x -= 10;
			if(l == 0){
				currentImg = img4;
				l=1;
			}else if(l == 1){
				currentImg = img5;
				l=0;
			}
			repaint();
		}

		if(action == UP){
			currentImg = img2;
			System.out.println("turn up");
			y -= 1;
			repaint();
		}

		if(action == RIGHT){
			currentImg = img3;
			System.out.println("turn right");
			x += 1;
			repaint();
		}
	}
}
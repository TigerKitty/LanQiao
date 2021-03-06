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
	Image currentImg,img,img2,img3;
	Image[] imgLeft;
	int x = 120;
	int y = 100;
	int leftFlag;
	public MainCanvas(){
		try{
			img = Image.createImage("/sayo10.png");
			img2 = Image.createImage("/sayo14.png");
			img3 = Image.createImage("/sayo16.png");
			currentImg = img;
			for(int i=0; i<3; i++){
				imgLeft[i] = Image.createImage("/sayo"+i+"2.png");
		}
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
			if(leftFlag == 0){
				currentImg = imgLeft[0];
				leftFlag=1;
			}else if(leftFlag == 1){
				currentImg = imgLeft[2];
				leftFlag=0;
			}
			System.out.println("turn left");
			x -= 1;
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
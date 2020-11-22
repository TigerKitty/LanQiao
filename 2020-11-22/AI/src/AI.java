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
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	Image currentImg;
	Image[][] heroImg = new Image [4][3];
	public MainCanvas(){
		try{
			x = 120;
			y = 100;
			currentImg = Image.createImage("/sayo31.png");
			//0表示left，1表示right，2表示up，3表示down
			for(int i=0; i<heroImg.length; i++){
				for(int j=0; j<heroImg[i].length; j++){
					heroImg[i][j]= Image.createImage("/sayo"+i+j+".png");
			}
		}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,100);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == LEFT){
			if(leftFlag == 0){
				currentImg = heroImg[0][0];
				leftFlag=1;
			}else if(leftFlag == 1){
				currentImg = heroImg[0][2];
				leftFlag=0;
			}
			System.out.println("turn left");
			x -= 1;
			repaint();
		}
		if(action == RIGHT){
			if(rightFlag == 0){
				currentImg = heroImg[1][0];
				rightFlag=1;
			}else if(rightFlag == 1){
				currentImg = heroImg[1][2];
				rightFlag=0;
			}
			System.out.println("turn right");
			x += 1;
			repaint();
		}
		if(action == UP){
			if(upFlag == 0){
				currentImg = heroImg[2][0];
				upFlag=1;
			}else if(upFlag == 1){
				currentImg = heroImg[2][2];
				upFlag=0;
			}
			System.out.println("turn up");
			y -= 1;
			repaint();
		}
		if(action == DOWN){
			if(downFlag == 0){
				currentImg = heroImg[3][0];
				downFlag=1;
			}else if(downFlag == 1){
				currentImg = heroImg[3][2];
				downFlag=0;
			}
			System.out.println("turn down");
			y += 1;
			repaint();
		}
	}
}
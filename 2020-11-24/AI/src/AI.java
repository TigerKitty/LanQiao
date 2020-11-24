import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.Random;
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
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int herox,heroy,bossX,bossY;
	int Flag;
	Random random = new Random();
	Image currentImg,bossImg;
	Image[][] heroImg = new Image [4][3];
	public MainCanvas(){
		try{
			herox = 120;
			heroy = 100;
			currentImg = Image.createImage("/sayo31.png");
			bossImg = Image.createImage("/zuzu000.png");
			//0��ʾleft��1��ʾright��2��ʾup��3��ʾdown
			for(int i=0; i<heroImg.length; i++){
				for(int j=0; j<heroImg[i].length; j++){
					heroImg[i][j]= Image.createImage("/sayo"+i+j+".png");
			}
		}
			Flag = 0;
			thread=new Thread(this);
			thread.start();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	/*
	�ڶ��߳���дһ����ѭ������ͣ�ıȽ�boss��hero������
	*/
	public void run(){
		while(true){
			 int r = random.nextInt(10);
			try{
				Thread.sleep(200);//fps��Ļˢ����,���������ʱboss���ƶ�
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(r%3 == 0){
				if(bossX < herox){
					bossX++;
				}else{
					bossX--;
				}

				if(bossY < heroy){
					bossY++;
				}else{
					bossY--;
				}
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,100);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,herox,heroy,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == LEFT){
			changePicAndDirection(0);
			System.out.println("turn left");
			herox -= 1;
			
		}
		if(action == RIGHT){
			changePicAndDirection(1);
			System.out.println("turn right");
			herox += 1;
			
		}
		if(action == UP){
			changePicAndDirection(2);
			System.out.println("turn up");
			heroy -= 1;
			
		}
		if(action == DOWN){
			changePicAndDirection(3);
			System.out.println("turn down");
			heroy += 1;
			
		}
	}
	public void changePicAndDirection(int direction){
		if(Flag == 0){
				currentImg = heroImg[direction][0];
				Flag=1;
			}else if(Flag == 1){
				currentImg = heroImg[direction][2];
				Flag=0;
			}
	}
}
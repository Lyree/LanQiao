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
	Image currentImg;
	Image Img[][]=new Image[3][4];
	int x,y;
	int count;
	public MainCanvas(){
		try{			
			//ÉÏ:1,ÏÂ£º0£¬×ó£º2£¬ÓÒ£º3
			for(int i=0;i<3;i++){
				for(int j=0;j<4;j++){
					Img[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=Img[0][0];
			x=120;
			y=100;
			count=1;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			x-=5;
		    ChangeImg(2);									
		}
		if(action==RIGHT){
			x+=5;
			ChangeImg(3);						          
		}
		if(action==UP){
			y-=5;
			ChangeImg(1);									
		}
		if(action==DOWN){
			y+=5;
			ChangeImg(0);							
		}
	}
       void ChangeImg(int direction){
		  
		if(count==1){
			currentImg=Img[count][direction];
			count++;
		}
	    else if(count==2){
            currentImg=Img[count][direction];
			count--;
			}
        repaint();
	}
}
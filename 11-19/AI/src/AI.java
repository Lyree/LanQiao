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
	int x,y;
	int leftcount,rightcount,upcount,downcount;
	Image Imageimg[][]=new Image[3][4];
    //声明图片数组
	/*Image LeftImage[]=new Image[3];
    Image RightImage[]=new Image[3];
	Image UpImage[]=new Image[3];
	Image DownImage[]=new Image[3];*/
	public MainCanvas(){
		try
		{
			/*
			//用for循环和一维数组存放图片
			//左
			for(int i=0;i<3;i++){
				LeftImage[i]=Image.createImage("/sayo02.png");
			}
			//右
            for(int i=0;i<3;i++){
				 RightImage[i]=Image.createImage("/sayo"+i+"6.png");
			}
			//上
            for(int i=0;i<3;i++){
				UpImage[i]=Image.createImage("/sayo"+i+"4.png");
			}
			//下
            for(int i=0;i<3;i++){
				DownImage[i]=Image.createImage("/sayo"+i+"0.png");
			}*/
			for(int i=0;i<3;i++){
				for(int j=0;j<4;j++){				
					Imageimg[i][j]=Image.createImage("/sayo"+i+j+".png");
               
				}
			}
			x=120;
			y=100;
            //给标志赋值
			leftcount=1;
			rightcount=1;
			upcount=1;
			downcount=1;

			currentImg = Imageimg[1][0];
		}
        catch(IOException e)
		{
            e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,182,193);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
		
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);		
		
		if(action == LEFT){
			if(leftcount==1){
			currentImg =Imageimg[0][1] ;
			leftcount++;
			}else if(leftcount==2){
				currentImg=Imageimg[2][1];
				leftcount--;
			}
			x-=5;
			System.out.println("向左转");
				repaint();
		}

		else if(action == RIGHT){
			if(rightcount==1){
			currentImg =Imageimg[0][3] ;
			rightcount++;
			}
			else if(rightcount==2){
				currentImg=Imageimg[2][3];
				rightcount--;
			}
			x+=5;
			System.out.println("向右转");
				repaint();
		}

		else if(action == UP){
			if(upcount==1){
			currentImg =Imageimg[0][2] ;
			upcount++;
			}
			else if(upcount==2){
				currentImg=Imageimg[2][2];
				upcount--;
			}
			y-=5;
			System.out.println("向上转");
				repaint();
		}

		else if(action == DOWN){
			if(downcount==1){
			currentImg =Imageimg[0][0] ;
			downcount++;
			}
			else if(downcount==2){
				currentImg=Imageimg[2][0];
				downcount--;
			}
			y+=5;
			System.out.println("向下转");
				repaint();
		}
	}
}
package entities.users;

import java.applet.*;
import java.awt.*;

public class Ludo extends Applet
{
	public void paint(Graphics g)
	{
        Graphics2D gdc =  (Graphics2D)g;
        BasicStroke bs0 = new BasicStroke(4.0f);
        gdc.setStroke(bs0);
        g.setColor(Color.BLACK);
        g.drawRect(10,10,650,650);
        g.setColor(Color.CYAN);
		g.fillRect(10,10,650,650);

        g.setColor(Color.BLACK);
        g.drawRect(10,10,250,250);
        g.setColor(Color.RED);
        g.fillRect(10,10,250,250);


        Graphics2D gdc1 =  (Graphics2D)g;
        BasicStroke bss = new BasicStroke(6.0f);
        gdc1.setStroke(bss);

		g.setColor(Color.BLACK);
        g.drawRect(260,260,150,150);
        g.setColor(new Color (100,100,60));
        g.fillRect(260,260,150,150);

        g.setColor(Color.BLACK);
        g.drawRect(410,410,250,250);
        g.setColor(Color.YELLOW);
		g.fillRect(410,410,250,250);

		g.setColor(Color.BLACK);
		g.drawRect(10,410,250,250);
		g.setColor(Color.GREEN);
		g.fillRect(10,410,250,250);

		g.setColor(Color.BLACK);
		g.drawRect(410,10,250,250);
		g.setColor(Color.BLUE);
		g.fillRect(410,10,250,250);


        Graphics2D gda = (Graphics2D)g;
        BasicStroke bs = new BasicStroke(3.0f);
        gda.setStroke(bs);

        g.setColor(Color.BLACK);
		g.drawArc(70,70,50,50,0,360);
		g.drawArc(150,70,50,50,0,360);
		g.drawArc(70,150,50,50,0,360);
		g.drawArc(150,150,50,50,0,360);

		g.drawArc(460,70,50,50,0,360);
		g.drawArc(550,70,50,50,0,360);
		g.drawArc(460,150,50,50,0,360);
		g.drawArc(550,150,50,50,0,360);
		g.drawArc(70,470,50,50,0,360);
		g.drawArc(150,470,50,50,0,360);
		g.drawArc(70,550,50,50,0,360);
		g.drawArc(150,550,50,50,0,360);
		g.drawArc(460,470,50,50,0,360);
		g.drawArc(550,470,50,50,0,360);
		g.drawArc(460,550,50,50,0,360);
		g.drawArc(550,550,50,50,0,360);


		g.drawLine(310,10,310,260);
		g.drawLine(360,10,360,260);

		g.drawLine(10,310,260,310);
		g.drawLine(10,360,260,360);

		g.drawLine(310,410,310,660);
		g.drawLine(360,410,360,660);

		g.drawLine(410,310,660,310);
		g.drawLine(410,360,660,360);

		g.drawLine(260,50,410,50);
		g.drawLine(260,90,410,90);

		g.drawLine(260,130,410,130);
		g.drawLine(260,170,410,170);

		g.drawLine(260,210,410,210);
		g.drawLine(50,260,50,410);

		g.drawLine(90,260,90,410);
		g.drawLine(130,260,130,410);

		g.drawLine(170,260,170,410);
		g.drawLine(210,260,210,410);
		g.drawLine(260,460,410,460);
		g.drawLine(260,500,410,500);
		g.drawLine(260,540,410,540);
		g.drawLine(260,580,410,580);
		g.drawLine(260,620,410,620);
		g.drawLine(460,260,460,410);
        g.drawLine(500,260,500,410);
        g.drawLine(540,260,540,410);
        g.drawLine(580,260,580,410);
        g.drawLine(620,260,620,410);
        g.drawLine(260,260,410,410);
        g.drawLine(410,260,260,410);

        Font f = new Font("Times New Roman",Font.BOLD,27);
        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString("HOME",295,340);

        g.drawLine(290,230,225,295);
        g.drawLine(290,230,266,236);
        g.drawLine(290,230,290,250);

        g.drawLine(387,230,430,290);
        g.drawLine(430,290,430,270);
        g.drawLine(430,290,415,280);

        g.drawLine(430,380,387,440);
        g.drawLine(387,440,385,420);
        g.drawLine(387,440,405,430);

        g.drawLine(240,387,280,440);
        g.drawLine(240,387,240,400);
        g.drawLine(240,387,255,392);


        g.setColor(Color.blue);
        int x[] = {335,320,345};
        int y[] = {220,245,245};
        g.drawPolygon(x,y,3);
        g.fillPolygon(x,y,3);

        g.setColor(Color.red);
        int a[] = {250,250,220};
        int b[] = {325,350,335};
        g.drawPolygon(a,b,3);
        g.fillPolygon(a,b,3);

        g.setColor(Color.green);
        int m[] = {335,320,350};
        int n[] = {450,420,420};
        g.drawPolygon(m,n,3);
        g.fillPolygon(m,n,3);


        g.setColor(Color.orange);
	    int p[] = {450,420,420};
	    int q[] = {333,344,320};
	    g.drawPolygon(p,q,3);
	    g.fillPolygon(p,q,3);

	    {
				        Graphics2D gd = (Graphics2D)g;
				        BasicStroke gdz=new BasicStroke(1.4f);
				        gd.setStroke(gdz);
									    int wd=getSize().width;
										int ht=getSize().height;
										gd.translate(wd/2.44,ht/2.32);
										for(int i=1;i<=40;i++)
									{
									   gd.setColor(Color.RED);
									   gd.rotate(2*Math.PI/20);
									   gd.drawRect(5,5,7,7);
								   }

										Graphics2D gd1 = (Graphics2D)g;
											    int wd1=getSize().width;
												int ht1=getSize().height;
												gd.translate(wd1/32,ht1/6.5);
												for(int i=1;i<=40;i++)
											{
											   gd.setColor(Color.RED);
											   gd.rotate(2*Math.PI/20);
											   gd.drawRect(5,5,7,7);
										   }

										   Graphics2D gd2 = (Graphics2D)g;
										   	    int wd2=getSize().width;
										   		int ht2=getSize().height;
										   		gd.translate(wd2/-4.29,ht2/3.1);
										   		for(int i=1;i<=40;i++)
										   	{
										   	   gd.setColor(Color.RED);
										   	   gd.rotate(2*Math.PI/20);
										   	   gd.drawRect(5,5,7,7);
										      }


								      Graphics2D gd3 = (Graphics2D)g;
									  	    int wd3=getSize().width;
									  		int ht3=getSize().height;
									  		gd.translate(wd3/12.96,ht3/-14.80);
									  		for(int i=1;i<=40;i++)
									  	{
									  	   gd.setColor(Color.RED);
									  	   gd.rotate(2*Math.PI/20);
									  	   gd.drawRect(5,5,7,7);
									     }




									        Graphics2D gd4 = (Graphics2D)g;
									  	  	    int wd4=getSize().width;
									  	  		int ht4=getSize().height;
									  	  		gd.translate(wd4/-4.29,ht4/-2.44);
									  	  		for(int i=1;i<=40;i++)
									  	  	{
									  	  	   gd.setColor(Color.RED);
									  	  	   gd.rotate(2*Math.PI/20);
									  	  	   gd.drawRect(5,5,7,7);
									     }


										       Graphics2D gd5 = (Graphics2D)g;
										 	  	    int wd5=getSize().width;
										 	  		int ht5=getSize().height;
										 	  		gd.translate(wd5/33,ht5/6.5);
										 	  		for(int i=1;i<=40;i++)
										 	  	{
										 	  	   gd.setColor(Color.RED);
										 	  	   gd.rotate(2*Math.PI/20);
										 	  	   gd.drawRect(5,5,7,7);
									     }


										       Graphics2D gd6 = (Graphics2D)g;
										 	  	    int wd6=getSize().width;
										 	  		int ht6=getSize().height;
										 	  		gd.translate(wd6/5,ht6/-2.09);
										 	  		for(int i=1;i<=40;i++)
										 	  	{
										 	  	   gd.setColor(Color.RED);
										 	  	   gd.rotate(2*Math.PI/20);
										 	  	   gd.drawRect(5,5,7,7);
									     }


										       Graphics2D gd7 = (Graphics2D)g;
										 	  	    int wd7=getSize().width;
										 	  		int ht7=getSize().height;
										 	  		gd.translate(wd7/-14,ht7/15.9);
										 	  		for(int i=1;i<=40;i++)
										 	  	{
										 	  	   gd.setColor(Color.RED);
										 	  	   gd.rotate(2*Math.PI/20);
										 	  	   gd.drawRect(5,5,7,7);
									     }
									 }







	}
}
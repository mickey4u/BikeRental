package entities.users;
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;

public class SnakeLadder extends Applet

{
	public void paint(Graphics g)
	{
		int wd = getSize().width;
		int ht = getSize().height;
		int aw = wd/10;
		int ah = ht/10;
        int count=0;
        int num=100;
		for(int r=0 ; r<10 ; r++)
		{
			for(int c=0 ; c<10 ; c++)
			{
				switch(count%4)
				{
					case 0 : g.setColor(Color.ORANGE); break;
					case 1 : g.setColor(Color.WHITE); break;
					case 2 : g.setColor(Color.YELLOW); break;
					case 3 : g.setColor(new Color(120,130,89)); break;
				}
				count ++;
			g.fillRect(c * aw,r * ah,aw,ah);
			g.setFont(new Font("Times New Roman",Font.BOLD,24));
			g.setColor(Color.BLACK);
			if(r%2==0)
			  g.drawString(""+(num-c),c*aw+95,r*ah+20);
			else
			  g.drawString(""+(num+c-9),c*aw+95,r*ah+20);

		}
		num-=10;
	}

    Graphics2D gd = (Graphics2D)g;
    g.setColor(Color.RED);
    BasicStroke bs = new BasicStroke(4.0f);
    gd.setStroke(bs);
	Line2D l = new Line2D.Double(300,485,185,620);
	gd.draw(l);
	gd.fill(l);

	g.setColor(Color.RED);
	Line2D l1 = new Line2D.Double(235,625,345,495);
	gd.draw(l1);
	gd.fill(l1);

    g.setColor(Color.RED);
	Line2D l2 = new Line2D.Double(280,510,330,510);
	gd.draw(l2);
	gd.fill(l2);

	g.setColor(Color.RED);
    Line2D l3 = new Line2D.Double(254,540,305,540);
    gd.draw(l3);
	gd.fill(l3);

	g.setColor(Color.RED);
	Line2D l4 = new Line2D.Double(228,570,280,570);
	gd.draw(l4);
	gd.fill(l4);

	g.setColor(Color.RED);
	Line2D l5 = new Line2D.Double(205,600,257,600);
	gd.draw(l5);
	gd.fill(l5);

	g.setColor(Color.RED);
	Line2D l6 = new Line2D.Double(700,385,975,625);
	gd.draw(l6);
	gd.fill(l6);

	g.setColor(Color.RED);
	Line2D l7 = new Line2D.Double(755,360,1036,615);
	gd.draw(l7);
	gd.fill(l7);

	g.setColor(Color.RED);
	Line2D l8 = new Line2D.Double(721,400,778,380);
	gd.draw(l8);
	gd.fill(l8);

	g.setColor(Color.RED);
	Line2D l9 = new Line2D.Double(755,430,810,410);
	gd.draw(l9);
	gd.fill(l9);

	g.setColor(Color.RED);
    Line2D l10 = new Line2D.Double(788,460,840,440);
	gd.draw(l10);
	gd.fill(l10);

	g.setColor(Color.RED);
	Line2D la = new Line2D.Double(822,490,878,470);
	gd.draw(la);
	gd.fill(la);

	g.setColor(Color.RED);
	Line2D lb = new Line2D.Double(860,520,910,500);
	gd.draw(lb);
	gd.fill(lb);

	g.setColor(Color.RED);
	Line2D lc = new Line2D.Double(890,550,942,530);
	gd.draw(lc);
	gd.fill(lc);

	g.setColor(Color.RED);
	Line2D ld = new Line2D.Double(928,580,976,560);
	gd.draw(ld);
	gd.fill(ld);

	g.setColor(Color.RED);
	Line2D le = new Line2D.Double(960,610,1010,590);
	gd.draw(le);
	gd.fill(le);

	g.setColor(Color.RED);
	Line2D lf = new Line2D.Double(355,540,560,480);
	gd.draw(lf);
	gd.fill(lf);

	g.setColor(Color.RED);
	Line2D lg = new Line2D.Double(365,580,580,515);
	gd.draw(lg);
	gd.fill(lg);

	g.setColor(Color.RED);
	Line2D lh = new Line2D.Double(397,530,410,568);
	gd.draw(lh);
	gd.fill(lh);

    g.setColor(Color.RED);
	Line2D li = new Line2D.Double(430,520,445,556);
	gd.draw(li);
	gd.fill(li);

	g.setColor(Color.RED);
	Line2D lJ = new Line2D.Double(463,512,480,546);
	gd.draw(lJ);
	gd.fill(lJ);

	g.setColor(Color.RED);
	Line2D lK = new Line2D.Double(499,500,515,535);
	gd.draw(lK);
	gd.fill(lK);

	g.setColor(Color.RED);
	Line2D lL = new Line2D.Double(535,490,550,525);
	gd.draw(lL);
	gd.fill(lL);


	BasicStroke bs1 = new BasicStroke(2.0f);
	gd.setStroke(bs1);
	GeneralPath gPath1 = new GeneralPath();

	gPath1.moveTo(180,238);
	gPath1.curveTo(150,280,270,350,200,500);
	gPath1.curveTo(290,350,170,280,200,242);
	gPath1.lineTo(200,242);
	gPath1.lineTo(190,260);

    CubicCurve2D c = new CubicCurve2D.Double(180,238,150,280,270,350,200,500);
    gd.draw(c);
    g.setColor( Color.BLACK);
	gd.draw(c);
	CubicCurve2D c1 = new CubicCurve2D.Double(202,238,170,280,290,350,200,500);
	gd.draw(c1);
	g.setColor( Color.BLACK);
	gd.draw(c1);

	Line2D n = new Line2D.Double(180,238,190,260);
	gd.draw(n);
	g.setColor( Color.BLACK);
	gd.draw(n);
	Line2D n1 = new Line2D.Double(200,242,190,260);
	gd.draw(n1);
	g.setColor( Color.BLACK);
	gd.draw(n1);
	g.setColor(new Color(100,200,60));
	gd.fill(gPath1);
	gd.setColor(Color.BLACK);
	Ellipse2D e = new Ellipse2D.Double(180,250,5,5);
	gd.draw(e);
	gd.fill(e);

    GeneralPath gPath3 = new GeneralPath();

    gPath3.moveTo(180,20);
    gPath3.curveTo(550,50,650,670,1280,630);
    gPath3.curveTo(620,700,530,70,180,40);
    gPath3.lineTo(240,48);
    gPath3.lineTo(240,47);

	CubicCurve2D n2 = new CubicCurve2D.Double(180,20,550,50,650,670,1280,630);
	gd.draw(n2);
	CubicCurve2D n3 = new CubicCurve2D.Double(180,40,530,70,620,700,1280,630);
	gd.draw(n3);
	Line2D n4 = new Line2D.Double(180,20,240,47);
	gd.draw(n4);
	Line2D n5 = new Line2D.Double(180,40,240,48);
	gd.draw(n5);
	g.setColor(Color.CYAN);
	gd.fill(gPath3);

	gd.setColor(Color.BLACK);
	Ellipse2D e1 = new Ellipse2D.Double(223,32,6,6);
	gd.draw(e1);
	gd.fill(e1);


   GeneralPath gPath2 = new GeneralPath();

   gPath2.moveTo(25,95);
   gPath2.curveTo(110,100,7,250,100,500);
   gPath2.curveTo(0,270,80,100,30,115);
   gPath2.lineTo(40,110);
   gPath2.lineTo(43,111);

   	CubicCurve2D n7 = new CubicCurve2D.Double(25,95,110,100,7,250,100,500);
   	gd.draw(n7);
   	CubicCurve2D n8 = new CubicCurve2D.Double(30,115,80,100,0,270,100,500);
   	gd.draw(n8);
    Line2D n9 = new Line2D.Double(25,95,43,111);
   	gd.draw(n9);
   	Line2D n6 = new Line2D.Double(30,115,40,110);
   	gd.draw(n6);
    g.setColor(new Color(70,210,220));
   	gd.fill(gPath2);

   	gd.setColor(Color.BLACK);
   	Ellipse2D e2 = new Ellipse2D.Double(35,100,4,4);
   	gd.draw(e2);
   	gd.fill(e2);



   GeneralPath gPath4 = new GeneralPath();

      gPath4.moveTo(1293,50);
      gPath4.curveTo(1115,82,1210,260,1000,360);
      gPath4.curveTo(1190,250,1090,85,1290,30);
      gPath4.lineTo(1270,50);
      gPath4.lineTo(1270,50);


   	  CubicCurve2D ns = new CubicCurve2D.Double(1293,50,1115,82,1210,260,1000,360);
	   	gd.draw(ns);
	   	CubicCurve2D nq = new CubicCurve2D.Double(1290,30,1090,85,1190,250,1000,360);
	   	gd.draw(nq);
	    Line2D ne = new Line2D.Double(1293,50,1270,50);
	   	gd.draw(ne);
	   	Line2D nr = new Line2D.Double(1290,30,1270,50);
   	    gd.draw(nr);
   	    g.setColor(new Color(170,10,160));
		   	gd.fill(gPath4);


   	    gd.setColor(Color.BLACK);
		   	Ellipse2D e3 = new Ellipse2D.Double(1272,38,5,5);
		   	gd.draw(e3);
		   	gd.fill(e3);


    BasicStroke bso = new BasicStroke(4.0f);
    gd.setStroke(bso);
	gd.setColor(Color.RED);
	Line2D ly = new Line2D.Double(595,115,440,340);
	gd.draw(ly);
	gd.fill(ly);
	Line2D lyy = new Line2D.Double(640,120,490,350);
	gd.draw(lyy);
	gd.fill(lyy);

	Line2D ly9 = new Line2D.Double(580,140,626,140);
	gd.draw(ly9);
	gd.fill(ly9);

	Line2D lym = new Line2D.Double(560,170,605,170);
	gd.draw(lym);
	gd.fill(lym);

	Line2D lyn = new Line2D.Double(540,200,585,200);
	gd.draw(lyn);
	gd.fill(lyn);

	Line2D lyq = new Line2D.Double(520,230,565,230);
	gd.draw(lyq);
	gd.fill(lyq);

	Line2D lye = new Line2D.Double(500,260,544,260);
	gd.draw(lye);
	gd.fill(lye);

	Line2D lyc = new Line2D.Double(478,290,526,290);
	gd.draw(lyc);
	gd.fill(lyc);

	Line2D lyg = new Line2D.Double(456,320,505,321);
	gd.draw(lyg);
	gd.fill(lyg);

	Line2D lyx = new Line2D.Double(960,240,1095,430);
	gd.draw(lyx);
	gd.fill(lyx);

	Line2D lyh = new Line2D.Double(1015,235,1150,430);
	gd.draw(lyh);
	gd.fill(lyh);

	Line2D lyv = new Line2D.Double(977,260,1028,260);
	gd.draw(lyv);
	gd.fill(lyv);

	Line2D lyl = new Line2D.Double(995,290,1050,290);
	gd.draw(lyl);
	gd.fill(lyl);

	Line2D lyu = new Line2D.Double(1017,320,1072,320);
	gd.draw(lyu);
	gd.fill(lyu);

	Line2D lyp = new Line2D.Double(1039,350,1094,350);
	gd.draw(lyp);
	gd.fill(lyp);

	Line2D lyo = new Line2D.Double(1061,380,1116,380);
	gd.draw(lyo);
	gd.fill(lyo);

	Line2D lyk = new Line2D.Double(1083,410,1136,410);
	gd.draw(lyk);
	gd.fill(lyk);

	Line2D lyr = new Line2D.Double(190,115,290,240);
	gd.draw(lyr);
	gd.fill(lyr);

	Line2D lyg1 = new Line2D.Double(230,110,335,240);
	gd.draw(lyg1);
	gd.fill(lyg1);

	Line2D lyh2 = new Line2D.Double(205,130,245,130);
	gd.draw(lyh2);
	gd.fill(lyh2);

	Line2D lyh1 = new Line2D.Double(229,160,270,160);
	gd.draw(lyh1);
	gd.fill(lyh1);

	Line2D lyc1 = new Line2D.Double(250,190,295,190);
	gd.draw(lyc1);
	gd.fill(lyc1);

	Line2D lyha = new Line2D.Double(274,220,319,220);
	gd.draw(lyha);
	gd.fill(lyha);

	Line2D le1 = new Line2D.Double(830,30,730,220);
	gd.draw(le1);
	gd.fill(le1);

	Line2D ld2 = new Line2D.Double(880,30,780,220);
	gd.draw(ld2);
	gd.fill(ld2);

	Line2D lu = new Line2D.Double(815,60,865,60);
	gd.draw(lu);
	gd.fill(lu);

	Line2D lfi = new Line2D.Double(800,90,849,90);
	gd.draw(lfi);
	gd.fill(lfi);

	Line2D lsw = new Line2D.Double(785,120,833,120);
	gd.draw(lsw);
	gd.fill(lsw);

	Line2D lzz = new Line2D.Double(762,160,810,160);
	gd.draw(lzz);
	gd.fill(lzz);

	Line2D lbb = new Line2D.Double(746,190,795,190);
	gd.draw(lbb);
	gd.fill(lbb);

	Line2D k = new Line2D.Double(1250,170,1250,360);
	gd.draw(k);
	gd.fill(k);
	Line2D k1 = new Line2D.Double(1300,170,1300,360);
	gd.draw(k1);
	gd.fill(k1);
	Line2D k2 = new Line2D.Double(1250,190,1300,190);
	gd.draw(k2);
	gd.fill(k2);
	Line2D k3 = new Line2D.Double(1250,220,1300,220);
	gd.draw(k3);
	gd.fill(k3);
	Line2D k4 = new Line2D.Double(1250,250,1300,250);
	gd.draw(k4);
	gd.fill(k4);
	Line2D k5 = new Line2D.Double(1250,280,1300,280);
	gd.draw(k5);
	gd.fill(k5);
	Line2D k6 = new Line2D.Double(1250,310,1300,310);
	gd.draw(k6);
	gd.fill(k6);
	Line2D k7 = new Line2D.Double(1250,340,1300,340);
	gd.draw(k7);
	gd.fill(k7);


    BasicStroke b3 = new BasicStroke(2.0f);
    gd.setStroke(b3);


	  GeneralPath gPath5 = new GeneralPath();

	   gPath5.moveTo(1000,90);
	   gPath5.curveTo(870,200,990,350,1020,430);
	   gPath5.curveTo(1020,350,890,200,1015,110);
	   gPath5.lineTo(990,120);
	   gPath5.lineTo(990,120);

	   	CubicCurve2D n81 = new CubicCurve2D.Double(1000,90,870,200,990,350,1020,430);
	   	gd.setColor(Color.BLACK);
	   	gd.draw(n81);
	   	CubicCurve2D n91 = new CubicCurve2D.Double(1015,110,890,200,1020,350,1020,430);
	   	gd.setColor(Color.BLACK);
	   	gd.draw(n91);
	    Line2D n11 = new Line2D.Double(1000,90,990,120);
	    gd.setColor(Color.BLACK);
	   	gd.draw(n11);
	   	Line2D n61 = new Line2D.Double(1015,110,990,120);
	   	gd.setColor(Color.BLACK);
	   	gd.draw(n61);
	    g.setColor(Color.CYAN);
	   	gd.fill(gPath5);

	   	gd.setColor(Color.BLACK);
	   	Ellipse2D e21 = new Ellipse2D.Double(986,108,5,5);
	   	gd.draw(e21);
   	    gd.fill(e21);




   	   GeneralPath gPath6 = new GeneralPath();

	   gPath6.moveTo(980,420);
	   gPath6.curveTo(1090,430,990,580,1290,550);
	   gPath6.curveTo(990,600,1090,460,980,440);
	   gPath6.lineTo(999,435);
	   gPath6.lineTo(999,435);

   	    CubicCurve2D ck = new CubicCurve2D.Double(980,420,1090,430,990,580,1290,550);
   	    gd.setColor(Color.BLACK);
   	    gd.draw(ck);
   	    CubicCurve2D cks = new CubicCurve2D.Double(980,440,1090,460,990,600,1290,550);
   	    gd.setColor(Color.BLACK);
   	    gd.draw(cks);
   	    Line2D h = new Line2D.Double(980,420,999,435);
   	    gd.setColor(Color.BLACK);
   	    gd.draw(h);
   	    Line2D hh = new Line2D.Double(980,440,999,435);
   	    gd.setColor(Color.BLACK);
   	    gd.draw(hh);
   	    g.setColor(new Color(190,50,126));
	   	gd.fill(gPath6);
   	    gd.setColor(Color.BLACK);
	   	Ellipse2D e211 = new Ellipse2D.Double(994,427,5,5);
	   	gd.draw(e211);
   	    gd.fill(e211);








    }
}





















































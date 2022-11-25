

package javagame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import static java.awt.event.KeyEvent.*;

public class GamePanel extends JPanel implements ActionListener {
    Player player;
    Timer gameTimer;
    ArrayList<Wall> walls = new ArrayList<Wall>();

    //------------ List Add Score -------------
    ArrayList<Coin> coin1 = new ArrayList<Coin>();
    ArrayList<Star> star1 = new ArrayList<Star>();
    ArrayList<Candy> cd = new ArrayList<Candy>();

    //------------ List Add HP -------------
    ArrayList<Heartwink>heartwink1 = new ArrayList<Heartwink>();
    ArrayList<Medicine> med1 = new ArrayList<Medicine>();


    //------------ List Delete Score -------------
    ArrayList<Bomb> bm2 = new ArrayList<Bomb>();
    ArrayList<BlueBomb> bmblue = new ArrayList<BlueBomb>();
    ArrayList<Skull> sk1 = new ArrayList<Skull>();
    ArrayList<SkullFire> sk2 = new ArrayList<SkullFire>();
    ArrayList<Devil> devil1 = new ArrayList<Devil>();

    //------------- BG ------------
    URL bg = this.getClass().getResource("img/bg.jpg");
    URL bg2 = this.getClass().getResource("img/bg2.png");
    URL bg3 = this.getClass().getResource("img/bg3.jpg");
    URL bg4 = this.getClass().getResource("img/bg4.png");
    URL bg5 = this.getClass().getResource("img/bg5.png");
    URL win = this.getClass().getResource("img/win.png");
    URL lose = this.getClass().getResource("img/LOST.png");

    //------------- BG ----------
    Image background = new ImageIcon(bg).getImage();
    Image background2 = new ImageIcon(bg2).getImage();
    Image background3 = new ImageIcon(bg3).getImage();
    Image background4 = new ImageIcon(bg4).getImage();
    Image background5 = new ImageIcon(bg5).getImage();
    Image backgroundwin = new ImageIcon(win).getImage();
    Image loser = new ImageIcon(lose).getImage();
    int x=400;
    int y=300;
    public int Full = 200;

    //------ Level ---------
    public int lv1 = 1;
    public int lv2 = 2;
    public int lv3 = 3;
    public int lv4 = 4;
    public int lv5 = 5;
    public int point = 0;
    boolean startball = false;

    Thread actor = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {}
                repaint();
            }
        }
    });

 //--------- add score ----------------
    Thread tCoin = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 100) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    coin1.add(new Coin());
                }
            }
        }
    });
    Thread tStar = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 500) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    star1.add(new Star());
                }
            }
        }
    });

    Thread tCandy = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 500) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    cd.add(new Candy());
                }
            }
        }
    });

    //--------- Add HP ----------------
    Thread tHeartwink = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    heartwink1.add(new Heartwink());
                }
            }
        }
    });

    Thread tMed = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() *10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    med1.add(new Medicine());
                }
            }
        }
    });



    //--------- delete score ----------------
    Thread tbombBlue = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    bmblue.add(new javagame.BlueBomb());
                }
            }
        }
    });

    Thread tbomb2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    bm2.add(new javagame.Bomb());
                }
            }
        }
    });

    Thread tskull = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 700) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    sk1.add(new javagame.Skull());
                }
            }
        }
    });

    Thread tskullfire = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 700) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    sk2.add(new javagame.SkullFire());
                }
            }
        }
    });

    Thread tdevil = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 700) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    devil1.add(new javagame.Devil());
                }
            }
        }
    });
    public GamePanel() {
        player = new Player(x, y, this);
        makeWalls();
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                repaint();
            }
        },0,10);

        actor.start();
        tCoin.start();
        tHeartwink.start();
        tCandy.start();
        tMed.start();
        tStar.start();
        tbomb2.start();
        tbombBlue.start();
        tskull.start();
        tskullfire.start();
        tdevil.start();
    }

    public void makeWalls(){
        for(int i = 50; i<650; i+=50){
            walls.add(new Wall(933,i,50,50));
        }
        for(int i = 50; i<650; i+=50){
            walls.add(new Wall(-150,i,50,50));
        }
    }
    public void paint(Graphics g) {
        super.paint(g);

        /// -------------- Level1 --------------

        if((point<200 && point>=0 )&& (Full>0)){
            Graphics2D gtd = (Graphics2D) g;
            g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
            player.draw(gtd);


            for (int i = 0; i < cd.size(); i++) {
                g.drawImage(cd.get(i).getImage(), cd.get(i).getX(), cd.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < cd.size(); i++) {
                if (Intersect(player.HitBox(), cd.get(i).HitBox())) {
                    cd.remove(i);
                    point += 10;
                    Full = Full;

                }
            }

            for (int i = 0; i < coin1.size(); i++) {
                g.drawImage(coin1.get(i).getImage(), coin1.get(i).getX(), coin1.get(i).getY(),
                        60, 60, this);
            }

            for (int i = 0; i < coin1.size(); i++) {
                if (Intersect(player.HitBox(), coin1.get(i).HitBox())) {
                    coin1.remove(i);
                    point += 20;
                    Full = Full;

                }
            }

            for (int i = 0; i < bm2.size(); i++) {
                g.drawImage(bm2.get(i).getImage(), bm2.get(i).getX(), bm2.get(i).getY(),
                        80, 80, this);
            }
            for (int i = 0; i < bm2.size(); i++) {
                if (Intersect(player.HitBox(), bm2.get(i).HitBox())) {
                    bm2.remove(i);
                    point -= 10;
                    Full = Full-10;
                }
            }


            g.setColor(Color.GRAY);
            g.fillRect(15,15,200,25);

            g.setColor(Color.GREEN);
            g.fillRect(15,15,Full,25);

            g.setColor(Color.WHITE);
            g.drawRect(15,15,200,25);

            g.setFont(Element.getFont(28));
            g.setColor(Color.white);
            g.drawString("Point : "+point,930 ,40);

            g.setFont(Element.getFont(28));
            g.setColor(Color.yellow);
            g.drawString("LEVEL : " +lv1,20,80);

            if(Full<=0 || point<0){
                g.drawImage(loser,0,0,this.getWidth(),this.getHeight(),this);
            }
        }

        /// -------------- Level2 --------------

        else if( (point<400 && point>=200)){
            Graphics2D gtd = (Graphics2D) g;
            g.drawImage(background2, 0, 0, this.getWidth(), this.getHeight(), this);
            player.draw(gtd);

            for (int i = 0; i < cd.size(); i++) {
                g.drawImage(cd.get(i).getImage(), cd.get(i).getX(), cd.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < cd.size(); i++) {
                if (Intersect(player.HitBox(), cd.get(i).HitBox())) {
                    cd.remove(i);
                    point += 10;
                    Full = Full;

                }
            }

            for (int i = 0; i < heartwink1.size(); i++) {
                g.drawImage(heartwink1.get(i).getImage(), heartwink1.get(i).getX(), heartwink1.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < heartwink1.size(); i++) {
                if (Intersect(player.HitBox(), heartwink1.get(i).HitBox())) {
                    heartwink1.remove(i);
                    Full = Full;
                    if(Full == 200){
                        Full = Full;
                    }
                    else{
                        Full = Full+10;
                    }
                }
            }

            for (int i = 0; i < coin1.size(); i++) {
                g.drawImage(coin1.get(i).getImage(), coin1.get(i).getX(), coin1.get(i).getY(), 60, 60, this);
            }

            for (int i = 0; i < coin1.size(); i++) {
                if (Intersect(player.HitBox(), coin1.get(i).HitBox())) {
                    coin1.remove(i);
                    point += 20;
                    Full = Full;

                }
            }


            for (int i = 0; i < bm2.size(); i++) {
                g.drawImage(bm2.get(i).getImage(), bm2.get(i).getX(), bm2.get(i).getY(), 80, 80, this);
            }
            for (int i = 0; i < bm2.size(); i++) {
                if (Intersect(player.HitBox(), bm2.get(i).HitBox())) {
                    bm2.remove(i);
                    point -= 10;
                    Full = Full-10;
                }
            }

            for (int i = 0; i < bmblue.size(); i++) {
                g.drawImage(bmblue.get(i).getImage(), bmblue.get(i).getX(), bmblue.get(i).getY(),
                        120, 100, this);
            }
            for (int i = 0; i < bmblue.size(); i++) {
                if (Intersect(player.HitBox(),bmblue.get(i).HitBox())) {
                    bmblue.remove(i);
                    point -= 20;
                    Full = Full-20;
                }
            }

            g.setColor(Color.GRAY);
            g.fillRect(15,15,200,25);

            g.setColor(Color.GREEN);
            g.fillRect(15,15,Full,25);

            g.setColor(Color.WHITE);
            g.drawRect(15,15,200,25);

            g.setFont(Element.getFont(28));
            g.setColor(Color.white);
            g.drawString("Point : "+point,930  ,40);

            g.setFont(Element.getFont(28));
            g.setColor(Color.yellow);
            g.drawString("LEVEL : " +lv2,20,80);

            if(Full<=0 || point<0){
                g.drawImage(loser,0,0,this.getWidth(),this.getHeight(),this);
            }


        }
        /// -------------- Level3 --------------

        else if (point<600 && point>=400){

            Graphics2D gtd = (Graphics2D) g;
            g.drawImage(background3, 0, 0, this.getWidth(), this.getHeight(), this);
            player.draw(gtd);


            for (int i = 0; i < cd.size(); i++) {
                g.drawImage(cd.get(i).getImage(), cd.get(i).getX(), cd.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < cd.size(); i++) {
                if (Intersect(player.HitBox(), cd.get(i).HitBox())) {
                    cd.remove(i);
                    point += 10;
                    Full = Full;

                }
            }
            for (int i = 0; i < coin1.size(); i++) {
                g.drawImage(coin1.get(i).getImage(), coin1.get(i).getX(), coin1.get(i).getY(), 60, 60, this);
            }

            for (int i = 0; i < coin1.size(); i++) {
                if (Intersect(player.HitBox(), coin1.get(i).HitBox())) {
                    coin1.remove(i);
                    point += 20;
                    Full = Full;

                }
            }
            for (int i = 0; i < heartwink1.size(); i++) {
                g.drawImage(heartwink1.get(i).getImage(), heartwink1.get(i).getX(), heartwink1.get(i).getY(), 60, 60, this);
            }
            for (int i = 0; i < heartwink1.size(); i++) {
                if (Intersect(player.HitBox(), heartwink1.get(i).HitBox())) {
                    heartwink1.remove(i);
                    Full = Full;
                    if(Full == 200){
                        Full = Full;
                    }
                    else{
                        Full = Full+10;
                    }
                }
            }


            for (int i = 0; i < bm2.size(); i++) {
                g.drawImage(bm2.get(i).getImage(), bm2.get(i).getX(), bm2.get(i).getY(), 80, 80, this);
            }
            for (int i = 0; i < bm2.size(); i++) {
                if (Intersect(player.HitBox(), bm2.get(i).HitBox())) {
                    bm2.remove(i);
                    point -= 10;
                    Full = Full-10;
                }
            }

            for (int i = 0; i < bmblue.size(); i++) {
                g.drawImage(bmblue.get(i).getImage(), bmblue.get(i).getX(), bmblue.get(i).getY(), 120, 100, this);
            }
            for (int i = 0; i < bmblue.size(); i++) {
                if (Intersect(player.HitBox(),bmblue.get(i).HitBox())) {
                    bmblue.remove(i);
                    point -= 20;
                    Full = Full-20;
                }
            }

            for (int i = 0; i < sk1.size(); i++) {
                g.drawImage(sk1.get(i).getImage(),sk1.get(i).getX(), sk1.get(i).getY(),
                        70, 70, this);
            }
            for (int i = 0; i < sk1.size(); i++) {
                if (Intersect(player.HitBox(),sk1.get(i).HitBox())) {
                    sk1.remove(i);
                    point -= 30;
                    Full = Full-30;
                }
            }

            g.setColor(Color.GRAY);
            g.fillRect(15,15,200,25);

            g.setColor(Color.GREEN);
            g.fillRect(15,15,Full,25);

            g.setColor(Color.WHITE);
            g.drawRect(15,15,200,25);

            g.setFont(Element.getFont(28));
            g.setColor(Color.white);
            g.drawString("Point : "+point,930  ,40);

            g.setFont(Element.getFont(28));
            g.setColor(Color.yellow);
            g.drawString("LEVEL : " +lv3,20,80);

            if(Full<=0){
                g.drawImage(loser,0,0,this.getWidth(),this.getHeight(),this);
            }

        }

        /// -------------- Level4 --------------

        else if (point<800 && point>=600){
            Graphics2D gtd = (Graphics2D) g;
            g.drawImage(background4, 0, 0, this.getWidth(), this.getHeight(), this);
            player.draw(gtd);

            for (int i = 0; i < cd.size(); i++) {
                g.drawImage(cd.get(i).getImage(), cd.get(i).getX(), cd.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < cd.size(); i++) {
                if (Intersect(player.HitBox(), cd.get(i).HitBox())) {
                    cd.remove(i);
                    point += 10;
                    Full = Full;

                }
            }
            for (int i = 0; i < coin1.size(); i++) {
                g.drawImage(coin1.get(i).getImage(), coin1.get(i).getX(), coin1.get(i).getY(), 60, 60, this);
            }

            for (int i = 0; i < coin1.size(); i++) {
                if (Intersect(player.HitBox(), coin1.get(i).HitBox())) {
                    coin1.remove(i);
                    point += 20;
                    Full = Full;

                }
            }

            for (int i = 0; i < star1.size(); i++) {
                g.drawImage(star1.get(i).getImage(), star1.get(i).getX(), star1.get(i).getY(),
                        60, 60, this);
            }

            for (int i = 0; i < star1.size(); i++) {
                if (Intersect(player.HitBox(), star1.get(i).HitBox())) {
                    star1.remove(i);
                    point += 40;
                    Full = Full;
                }
            }

            for (int i = 0; i < heartwink1.size(); i++) {
                g.drawImage(heartwink1.get(i).getImage(), heartwink1.get(i).getX(), heartwink1.get(i).getY(), 60, 60, this);
            }
            for (int i = 0; i < heartwink1.size(); i++) {
                if (Intersect(player.HitBox(), heartwink1.get(i).HitBox())) {
                    heartwink1.remove(i);
                    Full = Full;
                    if(Full == 200){
                        Full = Full;
                    }
                    else{
                        Full = Full+10;
                    }
                }
            }


            for (int i = 0; i < med1.size(); i++) {
                g.drawImage(med1.get(i).getImage(), med1.get(i).getX(), med1.get(i).getY(),
                        100, 100, this);
            }
            for (int i = 0; i < med1.size(); i++) {
                if (Intersect(player.HitBox(), med1.get(i).HitBox())) {
                    med1.remove(i);
                    Full = Full;
                    if(Full == 200){
                        Full = Full;
                    }
                    else{
                        Full = Full+30;
                    }
                }
            }


            for (int i = 0; i < bm2.size(); i++) {
                g.drawImage(bm2.get(i).getImage(), bm2.get(i).getX(), bm2.get(i).getY(), 80, 80, this);
            }
            for (int i = 0; i < bm2.size(); i++) {
                if (Intersect(player.HitBox(), bm2.get(i).HitBox())) {
                    bm2.remove(i);
                    point -= 10;
                    Full = Full-10;
                }
            }

            for (int i = 0; i < bmblue.size(); i++) {
                g.drawImage(bmblue.get(i).getImage(), bmblue.get(i).getX(), bmblue.get(i).getY(), 120, 100, this);
            }
            for (int i = 0; i < bmblue.size(); i++) {
                if (Intersect(player.HitBox(),bmblue.get(i).HitBox())) {
                    bmblue.remove(i);
                    point -= 20;
                    Full = Full-20;
                }
            }

            for (int i = 0; i < sk1.size(); i++) {
                g.drawImage(sk1.get(i).getImage(),sk1.get(i).getX(), sk1.get(i).getY(), 70, 70, this);
            }
            for (int i = 0; i < sk1.size(); i++) {
                if (Intersect(player.HitBox(),sk1.get(i).HitBox())) {
                    sk1.remove(i);
                    point -= 30;
                    Full = Full-30;
                }
            }

            for (int i = 0; i < sk2.size(); i++) {
                g.drawImage(sk2.get(i).getImage(),sk2.get(i).getX(), sk2.get(i).getY(),
                        80, 80, this);
            }
            for (int i = 0; i < sk2.size(); i++) {
                if (Intersect(player.HitBox(),sk2.get(i).HitBox())) {
                    sk2.remove(i);
                    point -= 50;
                    Full = Full-50;
                }
            }

            g.setColor(Color.GRAY);
            g.fillRect(15,15,200,25);

            g.setColor(Color.GREEN);
            g.fillRect(15,15,Full,25);

            g.setColor(Color.WHITE);
            g.drawRect(15,15,200,25);

            g.setFont(Element.getFont(28));
            g.setColor(Color.white);
            g.drawString("Point : "+point,930 ,40);

            g.setFont(Element.getFont(28));
            g.setColor(Color.yellow);
            g.drawString("LEVEL : " +lv4,20,80);

            if(Full<=0){
                g.drawImage(loser,0,0,this.getWidth(),this.getHeight(),this);
                g.setFont(Element.getFont(28));
                g.setColor(Color.yellow);
            }
        }

        /// -------------- Level5 --------------

        else if (point<1000 && point>=800) {
            Graphics2D gtd = (Graphics2D) g;
            g.drawImage(background5, 0, 0, this.getWidth(), this.getHeight(), this);
            player.draw(gtd);


            for (int i = 0; i < cd.size(); i++) {
                g.drawImage(cd.get(i).getImage(), cd.get(i).getX(), cd.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < cd.size(); i++) {
                if (Intersect(player.HitBox(), cd.get(i).HitBox())) {
                    cd.remove(i);
                    point += 10;
                    Full = Full;

                }
            }

            for (int i = 0; i < coin1.size(); i++) {
                g.drawImage(coin1.get(i).getImage(), coin1.get(i).getX(), coin1.get(i).getY(),
                        60, 60, this);
            }

            for (int i = 0; i < coin1.size(); i++) {
                if (Intersect(player.HitBox(), coin1.get(i).HitBox())) {
                    coin1.remove(i);
                    point += 20;
                    Full = Full;
                }
            }
            for (int i = 0; i < star1.size(); i++) {
                g.drawImage(star1.get(i).getImage(), star1.get(i).getX(), star1.get(i).getY(), 60, 60, this);
            }

            for (int i = 0; i < star1.size(); i++) {
                if (Intersect(player.HitBox(), star1.get(i).HitBox())) {
                    star1.remove(i);
                    point += 40;
                    Full = Full;
                }
            }

            for (int i = 0; i < heartwink1.size(); i++) {
                g.drawImage(heartwink1.get(i).getImage(), heartwink1.get(i).getX(), heartwink1.get(i).getY(),
                        60, 60, this);
            }
            for (int i = 0; i < heartwink1.size(); i++) {
                if (Intersect(player.HitBox(), heartwink1.get(i).HitBox())) {
                    heartwink1.remove(i);
                    Full = Full;
                    if(Full == 200){
                        Full = Full;
                    }
                    else{
                        Full = Full+10;
                    }
                }
            }


            for (int i = 0; i < med1.size(); i++) {
                g.drawImage(med1.get(i).getImage(), med1.get(i).getX(), med1.get(i).getY(), 100, 100, this);
            }
            for (int i = 0; i < med1.size(); i++) {
                if (Intersect(player.HitBox(), med1.get(i).HitBox())) {
                    med1.remove(i);
                    Full = Full;
                    if(Full == 200){
                        Full = Full;
                    }
                    else{
                        Full = Full+30;
                    }
                }
            }



            for (int i = 0; i < bm2.size(); i++) {
                g.drawImage(bm2.get(i).getImage(), bm2.get(i).getX(), bm2.get(i).getY(), 80, 80, this);
            }
            for (int i = 0; i < bm2.size(); i++) {
                if (Intersect(player.HitBox(), bm2.get(i).HitBox())) {
                    bm2.remove(i);
                    point -= 10;
                    Full = Full-10;
                }
            }

            for (int i = 0; i < bmblue.size(); i++) {
                g.drawImage(bmblue.get(i).getImage(), bmblue.get(i).getX(), bmblue.get(i).getY(), 120, 100, this);
            }
            for (int i = 0; i < bmblue.size(); i++) {
                if (Intersect(player.HitBox(),bmblue.get(i).HitBox())) {
                    bmblue.remove(i);
                    point -= 20;
                    Full = Full-20;
                }
            }

            for (int i = 0; i < sk1.size(); i++) {
                g.drawImage(sk1.get(i).getImage(),sk1.get(i).getX(), sk1.get(i).getY(), 70, 70, this);
            }
            for (int i = 0; i < sk1.size(); i++) {
                if (Intersect(player.HitBox(),sk1.get(i).HitBox())) {
                    sk1.remove(i);
                    point -= 30;
                    Full = Full-30;
                }
            }

            for (int i = 0; i < sk2.size(); i++) {
                g.drawImage(sk2.get(i).getImage(),sk2.get(i).getX(), sk2.get(i).getY(), 80, 80, this);
            }
            for (int i = 0; i < sk2.size(); i++) {
                if (Intersect(player.HitBox(),sk2.get(i).HitBox())) {
                    sk2.remove(i);
                    point -= 50;
                    Full = Full-50;
                }
            }

            for (int i = 0; i < devil1.size(); i++) {
                g.drawImage(devil1.get(i).getImage(),devil1.get(i).getX(), devil1.get(i).getY(),
                        70, 70, this);
            }
            for (int i = 0; i < devil1.size(); i++) {
                if (Intersect(player.HitBox(),devil1.get(i).HitBox())) {
                    devil1.remove(i);
                    point -= 70;
                    Full = Full-70;
                }
            }

            g.setColor(Color.GRAY);
            g.fillRect(15, 15, 200, 25);

            g.setColor(Color.GREEN);
            g.fillRect(15,15,Full,25);

            g.setColor(Color.WHITE);
            g.drawRect(15, 15, 200, 25);

            g.setFont(Element.getFont(28));
            g.setColor(Color.white);
            g.drawString("Point : " + point, 930   , 40);

            g.setFont(Element.getFont(28));
            g.setColor(Color.yellow);
            g.drawString("LEVEL : " +lv5,20,80);

            if(Full<=0){
                g.drawImage(loser,0,0,this.getWidth(),this.getHeight(),this);
            }
        }

        else if(point>1000){

            g.drawImage(backgroundwin, 0, 0, this.getWidth(), this.getHeight(), this);
            g.setFont(Element.getFont(28));
            g.setColor(Color.yellow);
        }

        else{
            g.drawImage(loser,0,0,this.getWidth(),this.getHeight(),this);
        }
    }
    private boolean Intersect(Rectangle2D hitBox, Rectangle2D hitBox1) {

        return (hitBox.intersects(hitBox1));
    }
    void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 'A') player.keyLeft = true;
        if(e.getKeyCode() == 'D') player.keyRight = true;
        if (e.getKeyCode()==VK_LEFT) player.keyLeft = true;
        if (e.getKeyCode()==VK_RIGHT) player.keyRight = true;
        }
    void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 'A') player.keyLeft = false;
        if(e.getKeyCode() == 'D') player.keyRight = false;
        if (e.getKeyCode()==VK_LEFT) player.keyLeft = false;
        if (e.getKeyCode()==VK_RIGHT) player.keyRight = false;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}


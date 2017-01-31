import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    ScoreCounter sc = new ScoreCounter();  
    ScoreCounter bulletCounter = new ScoreCounter();
    
    Player myPlayer = new Player();
    Ground ground = new Ground();
    StartPoint sp = new StartPoint();
    
    ICON[] bullets = new ICON[12];
    
    
    public MyWorld()
    {    
           super(1200, 600, 1); 
        
           addObject(sp,getWidth()/2,getHeight()/2);
           addObject(myPlayer,sp.getX(),sp.getY());
           addObject(sc,100,40);
           addObject(bulletCounter,getWidth()-100,40);
           addObject(ground,getWidth()/2,getHeight());
           
           Reload();
  
    }
    
    public ScoreCounter getScoreCounter()
    {
        return sc;
    }
     
    public ScoreCounter getBulletCounter()
    {
        return bulletCounter;
    }
    
    
    public StartPoint getStartPoint()
    {
        return sp;
    }
    
    public void Reload()
    {
         for(int i=0;i<bullets.length;i++)
           {
               bullets[i] = new ICON();
               bullets[i].setImage("ball.png");
               addObject(bullets[i],100+i*5,100);
           }
    }
    
    public ICON ReturnCurrentBullet(int i)
    {
        return bullets[i];
    }
    
    
}

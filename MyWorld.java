import greenfoot.*;

/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class MyWorld extends SWorld
{
    Player player = new Player();
    ScoreCounter sc = new ScoreCounter();  
    ScoreCounter bulletCounter = new ScoreCounter();
    
    StartPoint sp = new StartPoint();
    
    ICON[] bullets = new ICON[12];
    
    
    public MyWorld()
    {    
        super(1000, 500, 1, 5000);
        addObject(sp,500 ,200); 
        setPaintOrder(Player.class, Enemy.class, Ground.class);
        setMainActor(player,sp.getX(),sp.getY());
        
        
        addObject(new Ground(),502,400);
        addObject(sc,100,40,false);
        addObject(bulletCounter,getWidth()-100,40,false);
        
         
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
               addObject(bullets[i],100+i*5,100,false);
           }
    }
    
    public ICON ReturnCurrentBullet(int i)
    {
        return bullets[i];
    }
    
    
    
}

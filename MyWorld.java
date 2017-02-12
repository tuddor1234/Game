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
   
    Ground ground = new Ground();
    Hill hill = new Hill();
    
    
    GreenfootSound BkMusic = new GreenfootSound("BkMusic.mp3");
     
    public MyWorld()
    {    
        super(1300, 800, 1,10000);
        
      // BkMusic.playLoop();
        
       // addObject(sp,500 ,200); 
        
        setPaintOrder(Player.class, Enemy.class,Projectile.class,Food.class, Ground.class);
        setMainActor(player,250,getHeight()/2);
        
        //make the ground
        addObject(ground,getWidth()/2,getHeight()-50);
        //addObject(new Ground(), getWidth()/2+1300, getHeight()-50);
        
        
        
        
        addObject(sc,200,70,false);
        //addObject(bulletCounter,getWidth()-100,40,false);
  
        //addObject(new Enemy(),sp.getX(),sp.getY());
         
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
               bullets[i].setImage("Egg.png");
               bullets[i].turn(-90);
               addObject(bullets[i],100+i*10,100,false);
           }
    }
    
    public ICON ReturnCurrentBullet(int i)
    {
        return bullets[i];
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    Player player = new Player();
 
    public int projectileLife = 10;
    
    
    public void act() 
    {
      move(10);
      Actor enemy = getOneIntersectingObject(Enemy.class);
      Actor ground = getOneIntersectingObject(Ground.class);
      if(enemy != null)
      {
          World world = getWorld();  
          world.removeObject(enemy);
          world.removeObject(this);
         
          MyWorld mw = (MyWorld) world;
          ScoreCounter sc = mw.getScoreCounter();
          sc.add(10);
          
          
      }
      else if(atWorldEdge() == true || ground != null)
            {
                World MyWorld = getWorld();  
                MyWorld.removeObject(this);
            }
      
      
    }
    
    
    public boolean atWorldEdge()    
    {    
       if(getX() < 10 || getX() > getWorld().getWidth() - 10)    
           return true;    
       if(getY() < 10 || getY() > getWorld().getHeight() - 10)    
           return true;    
        return false;    
     }   
    
}

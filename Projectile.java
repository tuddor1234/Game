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
      if(enemy != null)
      {
          World MyWorld = getWorld();
          MyWorld.removeObject(enemy);
          MyWorld.removeObject(this);
          
          
      }
     
      
  
    }    
}
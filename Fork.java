import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fork here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fork extends ThingsThatCanKillYou
{
    /**
     * Act - do whatever the Fork wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        HitThePlayer();
    }
    
     public void HitThePlayer()
    {
       World world = getWorld();
       MyWorld mw = (MyWorld) world;
       Player player = mw.getPlayer();
       if(this.getOneIntersectingObject(Player.class) != null)
       {
           Greenfoot.setWorld(new GameOverScreen());
       }
    }
}

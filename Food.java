import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World world = getWorld();
        MyWorld mw = (MyWorld) world;
        ScoreCounter sc = mw.getScoreCounter();
        if(getOneIntersectingObject(Player.class) != null)
        {
            sc.add(10);
            // play sound
            mw.removeObject(this);
        }
    }    
}

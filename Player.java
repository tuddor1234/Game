import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       Movement();
    }
    
    public void Movement()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(5);
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            move(-5);
        }
    }
    
    
}

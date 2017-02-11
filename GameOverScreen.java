import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {   
        super(1300, 800, 1); 
        addObject(new QuitButton(), this.getWidth() - 300, this.getHeight() -150);
        addObject(new TryAgainButton() , 350 , this.getHeight() -150);
    }
}

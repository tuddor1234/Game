import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class TryAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TryAgainButton extends Button
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage image = new GreenfootImage("Button1.png");
    public TryAgainButton()
    {
        GreenfootImage text = new GreenfootImage("Try Again" , 30, Color.BLACK,transparent );
        image.drawImage(text, (image.getWidth())/2 ,(image.getHeight())/2-4);
        setImage(image);
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
           World world = getWorld();
           GameOverScreen go = (GameOverScreen) world;
           GreenfootSound bkMusic = go.getBackgroundMusic();
           bkMusic.pause();
           Greenfoot.setWorld(new MyWorld());
           
       }
    }    
}

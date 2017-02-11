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
    private GreenfootImage image = new GreenfootImage("Button.png");
    public TryAgainButton()
    {
        GreenfootImage text = new GreenfootImage("Try Again" , 22, Color.BLACK,transparent );
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
       {
           Greenfoot.setWorld(new MyWorld());
           
       }
    }    
}

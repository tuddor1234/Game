import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class TryAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGameButton extends Button
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage image = new GreenfootImage("Button1.png");
    public NewGameButton()
    {
        GreenfootImage text = new GreenfootImage("New Game" , 30, Color.BLACK,transparent );
        image.drawImage(text, (image.getWidth())/2 - 10,(image.getHeight())/2-5);
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

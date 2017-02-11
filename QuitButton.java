import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class QuitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuitButton extends Button
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage image = new GreenfootImage("Button.png");
    public QuitButton()
    {
        GreenfootImage text = new GreenfootImage("Quit Game" , 22, Color.BLACK,transparent );
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    
    public void act() 
    {

        if(Greenfoot.mouseClicked(this))
        {
            System.exit(0);
        }
    }    
}

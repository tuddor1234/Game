import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
    int score = 0;
    
    public void act() 
    {
        setImage(new GreenfootImage("Score: " + score, 24, Color.GREEN,Color.BLACK));
    }    
    
    public void AddScore()
    {
        score += 10;
    }
    
}

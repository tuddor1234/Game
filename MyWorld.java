import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    ScoreCounter sc = new ScoreCounter();  
    Player myPlayer = new Player();
    Ground ground = new Ground();
    StartPoint sp = new StartPoint();
    
    public MyWorld()
    {    
           super(1200, 600, 1); 
           
           addObject(sp,getWidth()/2,getHeight()/2);
           addObject(myPlayer,sp.getX(),sp.getY());
           addObject(sc,100,40);
           addObject(ground,getWidth()/2,getHeight());
           
    }
    
    public ScoreCounter getScoreCounter()
    {
        return sc;
    }
    
    public StartPoint getStartPoint()
    {
        return sp;
    }
    
    
    
    
}

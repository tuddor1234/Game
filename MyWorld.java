import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
           super(1200, 600, 1); 
           Player myPlayer = new Player();
           addObject(myPlayer,getWidth()/2,getHeight()/2);
           
           Ground ground = new Ground();
           addObject(ground,getWidth()/2,getHeight());
     
           
           
           for(int i=1;i<=5;i++)
           {
               Enemy enemy = new Enemy();
               addObject(enemy,getWidth()*2/4+i*100,getHeight()*3/4);
           }
    }
}

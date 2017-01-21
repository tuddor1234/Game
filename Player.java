import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int movingSpeed = 5 ;
    private int fallSpeed = 0;
    private int acceleration =2;
    
    public void act() 
    {
       Movement();
       CheckFall();
    }
    
    public void Movement()
    {
        // mergi la dreapta
        if(Greenfoot.isKeyDown("d"))
        {
            move(movingSpeed);
        }
        //mergi la stanga
        else if(Greenfoot.isKeyDown("a"))
        {
            move(-movingSpeed);
        }
        
    }
    //cade 
    public void Fall()
    {
        setLocation( getX(), getY()+ fallSpeed );
        fallSpeed = fallSpeed + acceleration;
    }
    // este pe pamant
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, Ground.class);
        return under != null;
    }
    
    public void CheckFall()
    {
        if (onGround()) {
            fallSpeed = 0;
        }
        else {
            Fall();
        }
    }
}

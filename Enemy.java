import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)





public class Enemy extends Actor
{
    private int fallSpeed = 0;
    private int acceleration = 2;
    
    public void act() 
    {
      CheckFall();
    }    
    
     public void Fall()
    {
        setLocation( getX(), getY()+ fallSpeed );
        fallSpeed = fallSpeed + acceleration;
    }
    
    // este pe pamant
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(2, getImage().getHeight()/2 + 10, Ground.class);
        return under != null;
    }
    //vezi daca e pe pamant
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

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)





public class Enemy extends ThingsThatCanKillYou
{
    private int fallSpeed = 0;
    private int acceleration = 2;
    private int walkSpeed = 2;
    private int timer = 0;
    
    public int life =3;
   
   
    public void act() 
    {
      CheckFall();
      Walk();
    }    
    
     public void Fall()
    {
        setLocation( getX(), getY()+ fallSpeed );
        fallSpeed = fallSpeed + acceleration;
    }
    
    // este pe pamant
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(2, getImage().getHeight()/2, Ground.class);
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
    
    public boolean Dead()
    {
        return true;
    }
    
    public void Walk()
    {
        move(-walkSpeed);      
    }
    
    
}

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
    private int jumpHeight = 20;
    public  int direction = 1;
    
    
    public void act() 
    {
       setImage("flower.png");
       Movement();
       CheckFall();
    }
    
    public void Movement()
    {
        // mergi la dreapta
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        {
            move(movingSpeed);
            direction = 2;
          
        }
        //mergi la stanga
        else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            move(-movingSpeed);
            direction = 1;
          
        }
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && onGround() ==true) Jump();
        if("space".equals(Greenfoot.getKey())) Fire();
        
    }
    //sare
    public void Jump()
    {
        fallSpeed = -jumpHeight;
        Fall(); 
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
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 10, Ground.class);
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
    
    public void Fire()
    {
        Projectile projectile = new Projectile();
        getWorld().addObject(projectile,getX(), getY());
        if(direction == 1) projectile.setRotation(180);
        else projectile.setRotation(0);
    }
    
}

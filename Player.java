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
    private int acceleration = 2;
    private int jumpHeight = 20;
    private int BulletsLeft = 12;
    private boolean crouching = false;
    
    public  int direction = 1;
    
    private GreenfootImage run1 = new GreenfootImage("duck_idle.3png.png");
    private GreenfootImage run2 = new GreenfootImage("duck_right_foot_forward.png");
    private int frame = 1;
    private int animationCounter = 0;
    
    public void act() 
    {
       Movement();
       CheckFall();
       backToStart();
       
       animationCounter++;
       
    }
    
    public void Movement()
    {
       
        
        World world = getWorld();
        MyWorld mw = (MyWorld) world;
          // mergi la dreapta
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        {
            move(movingSpeed);
            direction = 2;
            if(animationCounter % 8 == 0)
            {
                animateRight();
            }
        }
        //mergi la stanga
        else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            move(-movingSpeed);
            direction = 1;
          
        }
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && onGround() ==true)
        { 
             setImage("Cal_Idel.png");
              Jump();
        }
        else if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){ setImage("flower.png"); crouching = true;}
        if("space".equals(Greenfoot.getKey()) && BulletsLeft > 0)
        {
            Fire(); BulletsLeft--; 
           ICON x = mw.ReturnCurrentBullet(BulletsLeft);
           world.removeObject(x);
        
        }
        if(Greenfoot.isKeyDown("r") && BulletsLeft != 12) 
        {
            while(BulletsLeft > 0)
            {
             BulletsLeft--; 
            ICON x = mw.ReturnCurrentBullet(BulletsLeft);
             world.removeObject(x);
            }
            BulletsLeft = 12;
           mw.Reload(); 
        }
        
        setCounter(BulletsLeft);
        
    }
    //sare
    public void Jump()
    {
        fallSpeed = -jumpHeight;
        Fall(); 
    }
  
    public void animateRight()
    {
        if(frame ==1) 
        {
            setImage(run1);
            
        }
        else if(frame == 2) 
            {
                setImage(run2);
                frame=1;
                return;
            }
        frame++;
    }
    
    public void animateLeft()
    {
        
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
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    //vezi daca e pe pamant
    public void CheckFall()
    {
        if (onGround()) 
        {
            fallSpeed = 0;
        }
        else 
        {
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
   
    public void backToStart()
    {
         World world = getWorld();
         MyWorld mw = (MyWorld) world;
         int x = mw.getStartPoint().getX();
         int y = mw.getStartPoint().getY();
         if(getY() < 10 || getY() > world.getHeight() - 10)    
            setLocation(x,y);
    }

    public void setCounter(int value)
    {
       World world = getWorld();
        MyWorld mw = (MyWorld) world;
        
        ScoreCounter bulletCounter = mw.getBulletCounter();
        
        
        bulletCounter.setValue(value);
        
    }
    
    
    
  
    
}

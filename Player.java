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
   
    private boolean crouching = false;
    
    public  int direction = 2;
    public int BulletsLeft = 12;
    
    // Right Photos
    private GreenfootImage idle_R = new GreenfootImage("Idle_R.png");
    private GreenfootImage F1_R = new GreenfootImage("F1_R.png");
    private GreenfootImage F2_R = new GreenfootImage("F2_R.png");
    private GreenfootImage F3_R = new GreenfootImage("F3_R.png");
    private GreenfootImage F4_R = new GreenfootImage("F4_R.png");
    private GreenfootImage F5_R = new GreenfootImage("F5_R.png");
    // Left Photos
    private GreenfootImage idle_L = new GreenfootImage("Idle_L.png");
    private GreenfootImage F1_L = new GreenfootImage("F1_L.png");
    private GreenfootImage F2_L = new GreenfootImage("F2_L.png");
    private GreenfootImage F3_L = new GreenfootImage("F3_L.png");
    private GreenfootImage F4_L = new GreenfootImage("F4_L.png");
    private GreenfootImage F5_L = new GreenfootImage("F5_L.png");    
    
    // cade
    private GreenfootImage fall_R = new GreenfootImage("Jump_R.png");    
    private GreenfootImage fall_L = new GreenfootImage("Jump_L.png");    
    private GreenfootSound jumpSound = new GreenfootSound("Jump.mp3");
   
    
    
    
    
   
    
    private int frame = 1;
    private int animationCounter = 0;
    
    
    
    
    public void act() 
    {
       Movement();
       CheckFall();
      /// backToStart();
      
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
            if(animationCounter % 5 == 0)
            {
                animateRight();
               animationCounter=1;
            }
        
        }
        //mergi la stanga
        else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            move(-movingSpeed);
            direction = 1;
            if(animationCounter % 5 == 0)
            {
                animateLeft();
               animationCounter=1;
            }
        }
        else 
        {
            if(direction == 2)setImage(idle_R);
               else setImage(idle_L); 
        }
        
        
        
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && onGround() ==true)
        { 
              jumpSound.play();
              Jump();
        }
        
    
       

        if("space".equals(Greenfoot.getKey()) && BulletsLeft > 0)
        {
            if(direction ==1) setImage(idle_R);
            else setImage(idle_L);
                        
            Fire(); BulletsLeft--; 
           ICON x = mw.ReturnCurrentBullet(BulletsLeft);
           world.removeObject(x);
           Greenfoot.delay(4);
           
           if(direction ==1) setImage(idle_L);
            else setImage(idle_R);
        
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
            setImage(idle_R);
            
        }
        else if(frame == 2) 
            {
                setImage(F1_R);
                
            }
            else if(frame == 3) 
            {
                setImage(F2_R);
               
            }
                else if(frame == 4) 
                {
                    setImage(F3_R);
                    
                }
                    else if(frame == 5) 
                    {
                        setImage(F4_R);
                        frame=1;
                        return;
                    }
        frame++;
    }
    
    public void animateLeft()
    {
        if(frame ==1) 
        {
            setImage(idle_L);
            
        }
        else if(frame == 2) 
            {
                setImage(F1_L);
                
            }
            else if(frame == 3) 
            {
                setImage(F2_L);
               
            }
                else if(frame == 4) 
                {
                    setImage(F3_L);
                    
                }
                    else if(frame == 5) 
                    {
                        setImage(F4_L);
                        frame=1;
                        return;
                    }
        frame++;
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
        Object blocked = getOneObjectAtOffset(0, getImage().getWidth()/2, Capita.class);
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
            if(direction ==1) setImage(fall_L);
            else setImage(fall_R);
        }
    }
    
    public void Fire()
    {
        
        Projectile projectile = new Projectile();
        getWorld().addObject(projectile,getX(), getY());
        if(direction == 1)    projectile.setRotation(180);
            else             projectile.setRotation(0);
 
    }
    
    /*
    public void backToStart()
    {
         World world = getWorld();
         MyWorld mw = (MyWorld) world;
         int x = mw.getStartPoint().getX();
         int y = mw.getStartPoint().getY();
         if(getY() < 10 || getY() > world.getHeight() - 10)    
            setLocation(x,y);
    }
    */
   
   
    public void setCounter(int value)
    {
        World world = getWorld();
        MyWorld mw = (MyWorld) world;
        
        ScoreCounter bulletCounter = mw.getBulletCounter();
        
        
        bulletCounter.setValue(value);
        
    }
    
    public int getBulletsLeft()
    {
        return BulletsLeft;
    }
    

    
  
    
}

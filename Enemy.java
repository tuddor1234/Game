import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)





public class Enemy extends ThingsThatCanKillYou
{
    private int fallSpeed = 0;
    private int acceleration = 2;
    private int walkSpeed = 2;
    private int timer = 0;
    private int animationCounter =1;
    
    public int frame = 1;
   
    private GreenfootImage E1_R = new GreenfootImage("E1_R.png");
    private GreenfootImage E2_R = new GreenfootImage("E2_R.png");
    private GreenfootImage E3_R = new GreenfootImage("E3_R.png");
    
    private GreenfootImage E1_L = new GreenfootImage("E1_L.png");
    private GreenfootImage E2_L = new GreenfootImage("E2_L.png");
    private GreenfootImage E3_L = new GreenfootImage("E3_L.png");
    
    
    
    
    public void act() 
    {
      CheckFall();
      GoToPlayer();
      HitThePlayer();
      animationCounter++;
    }    
    
    
    public void animateRight()
    {
        if(frame ==1) 
        {
            setImage(E1_R);
            
        }
        else if(frame == 2) 
            {
                setImage(E2_R);    
            }
                 else if(frame == 3) 
                    {
                        setImage(E3_R);
                      
                    }
                   else if(frame == 4) 
                   {
                       setImage(E2_R);    
                        frame=1;
                        return;
                }
        frame++;
    }
    
      
    public void animateLeft()
    {
        if(frame ==1) 
        {
            setImage(E1_L);
            
        }
        else if(frame == 2) 
            {
                setImage(E2_L);    
            }
                 else if(frame == 3) 
                    {
                          setImage(E3_L);
                    }
                       else if(frame==4)
                       {
                       setImage(E2_L);
                        frame=1;
                        return;
                        }
        frame++;
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
    
    public void GoToPlayer()
    {
        World world = getWorld();
        MyWorld mw = (MyWorld) world;
        Player player = mw.getPlayer();
        if(this.getX() < player.getX()) 
        {
            this.setLocation(this.getX()+ walkSpeed, this.getY());
           if(animationCounter % 5 == 0)
            {
                animateRight();
                animationCounter=1;
            }
           
        }
         else
         {
             this.setLocation(this.getX()-walkSpeed, this.getY());
              if(animationCounter % 5 == 0)
            {
                animateLeft();
                animationCounter=1;
            }
         }
        
        
    }
    
     public void HitThePlayer()
    {
       if(Killed() == true)
       {
           Greenfoot.setWorld(new GameOverScreen());
       }
    }
    
    public boolean Killed()
    {
        World world = getWorld();
       MyWorld mw = (MyWorld) world;
       Player player = mw.getPlayer();
       if(this.getOneIntersectingObject(Player.class) != null) return true;
       return false;
       
    }
    
    
}

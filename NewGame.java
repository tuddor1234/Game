import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGame extends World
{

    /**
     * Constructor for objects of class NewGame.
     * 
     */
    public NewGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 800, 1); 
        
        this.setPaintOrder(NewGameButton.class, QuitButton.class,Ground.class);
        
        addObject(new QuitButton(), this.getWidth()/2, this.getHeight()/2 +50);
        addObject(new NewGameButton() , this.getWidth()/2 , this.getHeight()/2 -50);
        
        
        addObject(new Ground() , this.getWidth()/2, this.getHeight()-50);
  
       
        
        addObject(new Hill(), this.getWidth()/2,530);
        addObject(new iarba(), this.getWidth()/4,this.getHeight()-150);
        addObject(new iarba(), this.getWidth()/4*3,this.getHeight()-150);
        
        
        addObject(new nor3(),288,162);
        addObject(new nor2(),1128,171);
        
        
    }
}

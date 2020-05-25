import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends SmoothMover
{
    
    public Lives()
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 1));
    }
    
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        
        if(isTouching(Rocket.class))
        {
            getWorld().removeObject(this);
        }
    }  
}

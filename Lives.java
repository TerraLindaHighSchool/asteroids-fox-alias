import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When the rocket hits a heart, it gains a life.
 * 
 * @author Jordan Miller
 * @version 1.0
 */
public class Lives extends SmoothMover
{
    
    public Lives()
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 1)); //sets speed and direction of movement
    }
    
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        
        //if it touches the rocket class, the heart disappears.
        if(isTouching(Rocket.class))
        {
            getWorld().removeObject(this);
        }
    }  
}

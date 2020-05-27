import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Limiter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Limiter extends SmoothMover
{
    public Limiter()
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 1));
    }
    
    /**
     * Act - do whatever the Limiter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
}

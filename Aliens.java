import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aliens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aliens extends SmoothMover
{
    public int resilience = 1;
    
    public Aliens()
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
    }
    
    /**
     * Act - do whatever the Aliens wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    } 
    
    //when colliding with the rocket, the rocket loses a life
    //when the score reaches 10, the aliens come in (optional)
    //if it is shot down, it disappears and score updates by one
    //They are harder to shoot down than asteroids
    //Problem: rocket collision with the aliens, bullet collision
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 

/**
 * One of the lasers in the rocket's arsenal that can be used even when the rocket is limited, but only for a certain amount of time.
 * 
 * @author Jordan Miller
 * @version 1.0
 */
public class APShot extends SmoothMover
{
    //These two variables determine the amount of points to add, depending on whether the user shot down an asteroid or an alien.
    private int pointsToAdd = 1; 
    private int alienPoints = 2;
    
    /*
     * The constructor determines the speed and direction at which the laser is fired.
     */
    public APShot(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 20));
        Greenfoot.playSound("laserSound.wav");
    }
    
    /**
     * Act - do whatever the APShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        checkAnythingHit();
        checkAtEdge();
    }
    
    /*
     * This method checks whether the AP shot hit an asteroid or an alien.
     */
    private void checkAnythingHit()
    {
        List<Asteroid> asteroids = getIntersectingObjects(Asteroid.class);
        List<Aliens> aliens = getIntersectingObjects(Aliens.class);
        Space space = (Space) getWorld();
        
        for(Asteroid asteroid : asteroids)
        {
            if(asteroid != null)
            {
                ((Space)getWorld()).updateScore(pointsToAdd);
                space.addObject(new Explosion(), asteroid.getX(), asteroid.getY());
                getWorld().removeObject(asteroid);
            }
        }
        
        for(Aliens alien : aliens)
        {
            if(alien != null)
            {
                ((Space)getWorld()).updateScore(alienPoints);
                space.addObject(new Explosion(), alien.getX(), alien.getY());
                getWorld().removeObject(alien);
            }
        }
    }
    
    /*
     * Checks if the laser is at the edge of the world and removes it if it is.
     */
    private void checkAtEdge()
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Like asteroids, the aliens have to be shot down by the rocket.
 * 
 * @author Jordan Miller
 * @version 2.0
 */
public class Aliens extends SmoothMover
{
    private int resilience = 16; //Amount of resistance the alien has to the rocket's weapons
    private int pointsToAdd = 2; //number of points to add, should the rocket shoot the alien down.
    
    public Aliens()
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2)); //sets speed and direction of movement
    }
    
    /**
     * Act - do whatever the Aliens wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        checkBulletHit();
    } 
    
    /*
     * If the alien has been hit by a bullet, resilience decrements, and if resilience is 0, then the alien disappears.
     */
    private void checkBulletHit()
    {
        if(isTouching(Bullet.class))
        {
            resilience--;
            
            if(resilience <= 0)
            {
                Space space = (Space) getWorld();
                
                ((Space)getWorld()).updateScore(pointsToAdd);
                Greenfoot.playSound("Explosion.wav");
                space.addObject(new Explosion(), getX(), getY());
                getWorld().removeObject(this);
            }
        }
    }
}

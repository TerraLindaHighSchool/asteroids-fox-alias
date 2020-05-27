import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Like asteroids, the aliens have to be shot down by the rocket.
 * 
 * @author Jordan Miller
 * @version 2.0
 */
public class Aliens extends SmoothMover
{
    private int resilience = 16;
    private int pointsToAdd = 2;
    
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
        checkBulletHit();
    } 
    
    private void checkBulletHit()
    {
        if(isTouching(Bullet.class))
        {
            resilience--;
            
            if(resilience <= 0)
            {
                ((Space)getWorld()).updateScore(pointsToAdd);
                Greenfoot.playSound("Explosion.wav");
                getWorld().removeObject(this);
            }
        }
    }
    
    //when the score reaches 10, the aliens come in (optional)
}

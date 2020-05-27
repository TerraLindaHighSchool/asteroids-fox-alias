import greenfoot.*;
import java.util.List;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling a
 * 
 * @version 1.2
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5; // The minimum delay between firing the gun.

    private static final int waveReloadTime = 100; //minimum delay for the proton wave.
    
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    
    private int reloadDelayWaveCount; //How long ago we fired the wave.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
    private double speed = 0.3;
    
    private int lives = 10;
    private int timer = 10;
    
    private boolean gameIsOver = false;
    
    /**
     * Initialise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        reloadDelayWaveCount = 3;
        addToVelocity(new Vector(180, 0.1));
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        Space space = (Space) getWorld();
        
        checkKeys();
        reloadDelayCount++;
        reloadDelayWaveCount++;
        move();
        limit();
        gainLives();
        countLives();
        
        if(!gameIsOver) 
        {
            checkCollision();
        }
        
        if(!gameIsOver) 
        {
            checkAlienCollision();
        }
        
        if(gameIsOver) 
        {
            space.gameOver();
        } 
    }
    
    private void startProtonWave()
    {
        int rocketX = getX();
        int rocketY = getY();
        
        if(reloadDelayWaveCount >= waveReloadTime)
        {
            getWorld().addObject(new ProtonWave(), rocketX, rocketY);
            reloadDelayWaveCount = 0;
        }
    }
    
    /*
     * This programs the speed of the rocket as the UP button is pressed.
     */
    private void ignite(boolean boosterOn)
    {
        if(boosterOn)
        {
            setImage("rocketWithThrust.png");
            addToVelocity(new Vector(getRotation(), speed));
        }
        
        if(!boosterOn)
        {
            setImage("rocket.png");
        }
    }
    
    /* 
     * This method checks whether the rocket collided with any asteroids.
     */
    public void checkCollision()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        
        if(asteroid != null)
        {
            Space space = (Space) getWorld();
           if(lives <= 0)
            {
                space.addObject(new Explosion(), getX(), getY());
                space.removeObject(this);
                gameIsOver = true;
            } else  {
                lives--;
                Greenfoot.playSound("lifeLost.wav");
                
            }
        }
    }
    
    public void checkAlienCollision()
    {
        Aliens alien = (Aliens) getOneIntersectingObject(Aliens.class);
        
        if(alien != null)
        {
            Space space = (Space) getWorld();
            if(lives <= 0)
            {
                space.addObject(new Explosion(), getX(), getY());
                space.removeObject(this);
                gameIsOver = true;
            } else  {
                lives = lives - 2;
                Greenfoot.playSound("lifeLost.wav");
            }
        }
        //problem with getOneIntersectingObject upon asteroid and alien collision with rocket; Illegal State Exception.
    }
    
    private void limit()
    {
        boolean limited = false;
        Limiter limiter = (Limiter) getOneIntersectingObject(Limiter.class);
        
        if(limiter != null)
        {
            limited = true;
            
            while(limited)
            {
                timer--;
                speed = 0;
                if(timer <= 0)
                {
                    speed = 0.3;
                    getWorld().removeObject(limiter);
                    limited = false;
                }
            }
        }
    }
    
    public void countLives()
    {
        getWorld().showText("Lives: " + lives, 50, 20);
    }
    
    private void gainLives()
    {
        if(isTouching(Lives.class))
        {
            lives++;
            Greenfoot.playSound("lifeGained.wav"); 
        } 
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-5);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            turn(5);
        }
        
        ignite(Greenfoot.isKeyDown("up")); //programs rocket movement
        
        //slows down the momentum of the rocket when player feels it's going too fast.
        if (Greenfoot.isKeyDown("down"))
        {
            move(-5);
        }
        
        if(Greenfoot.isKeyDown("z"))
        {
            startProtonWave();
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
}
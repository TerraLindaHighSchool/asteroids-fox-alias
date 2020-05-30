 import greenfoot.*;
import java.util.List;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * When the rocket collides into an alien or an asteroid, it loses some lives.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling and Jordan Miller
 * 
 * @version 1.2
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5; // The minimum delay between firing the gun.
    private static final int waveReloadTime = 100; //minimum delay for the proton wave.
    private static final int shadowReloadTime = 400;
    
    private int reloadDelayCount; // How long ago we fired the gun the last time.
    private int reloadDelayWaveCount; //How long ago we fired the wave.
    private int reloadDelayShadowCount;
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
    private double thrustSpeed = 0.3; //The speed at which the rocket goes with thrust
    
    private int lives = 5;  //Number of lives a player has
    private int timer = 100; 
    private int shadowTime = 500;
    private boolean limited = false;
    private boolean cloaked = false;
    private boolean isPressed = false;
    
    private boolean gameIsOver = false; //boolean declaring when the game is or isn't over 
    
    /**
     * Initialise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        reloadDelayWaveCount = 3;
        reloadDelayShadowCount = 0;
        
        if(limited)
        {
            addToVelocity(new Vector(180, 0));
        } else if(!limited) {
            addToVelocity(new Vector(180, 0.1));
        }
    }

    /**
     * Do what a rocket's gotta do.
     */
    public void act()
    {
        Space space = (Space) getWorld();
        
        checkKeys();
        reloadDelayCount++;
        reloadDelayWaveCount++;
        reloadDelayShadowCount++;
        move();
        
        if(!cloaked)
        {
            limit();
        }
        
        gainLives();
        countLives();
        shadowMode();
        
        //These if statements prevent a previous IllegalStateException error with the rocket out of the world
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

    /*
     * Starts the proton wave as long as the player hasn't fired it in a while.
     */
    
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
    
    private void shadowMode()
    {
        if(cloaked)
        {
            isPressed = true;
            getWorld().showText("Shadow Mode ON" , 300, 400);
            getImage().setTransparency(100);
            shadowTimer();
        }
        
        if(!Greenfoot.isKeyDown("tab"))
        {
            if(shadowTime <= 0)
            {
                getImage().setTransparency(255);
                isPressed = false;
                cloaked = false;
                getWorld().showText("" , 300, 400);
                reloadDelayShadowCount = 0;
            }
        }
        
        if(!cloaked && !isPressed)
        {
            restartTimer();
        }
    }
    
    private void restartTimer()
    {
        if(shadowTime <= 0)
        {
            shadowTime = 500;
        }
    }
    
    private void shadowTimer()
    {
        shadowTime--;
    }
    
    /*
     * This programs the speed of the rocket as the UP button is pressed.
     */
    private void ignite(boolean boosterOn)
    {
        if(boosterOn)
        {
            setImage("rocketWithThrust.png");
            addToVelocity(new Vector(getRotation(), thrustSpeed));
        }
        
        if(!boosterOn)
        {
            setImage("rocket.png");
        }
    }
    
    /* 
     * This method checks whether the rocket collided with any asteroids, and decrements the lives if it has.
     */
    public void checkCollision()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        
        if(asteroid != null)
        {
            if(!cloaked)
            {
                Space space = (Space) getWorld();
                if(lives <= 0)
                {
                    space.addObject(new Explosion(), getX(), getY());
                    space.removeObject(this);
                    space.removeObject(asteroid);
                    gameIsOver = true;
                } else  {
                    lives--;
                    space.removeObject(asteroid);
                    Greenfoot.playSound("lifeLost.wav");
                }
            }
        }
    }
    
    /*
     * This method checks whether the rocket has collided with any aliens, and decrements the lives by two if it has.
     */
    public void checkAlienCollision()
    {
        Aliens alien = (Aliens) getOneIntersectingObject(Aliens.class);
        
        if(alien != null)
        {
            if(!cloaked)
            {
                Space space = (Space) getWorld();
                if(lives <= 0)
                {
                    space.addObject(new Explosion(), getX(), getY());
                    space.removeObject(this);
                    space.removeObject(alien);
                    gameIsOver = true;
                } else  {
                    lives = lives - 2;
                    space.removeObject(alien);
                    Greenfoot.playSound("lifeLost.wav");
                }
            }
        }
    }
    
    private void limit()
    {
        Limiter limiter = (Limiter) getOneIntersectingObject(Limiter.class);
        
        if(limiter != null)
        {
            limited = true;
        }
        
        if(limited)
        {
            countTime();
            thrustSpeed = 0;
            limiter.speed = 0;
            getWorld().showText("Avoid the freeze pills next time!" , 300, 400);
        }
        
        if(timer <= 0)
        {
            thrustSpeed = 0.3;
            getWorld().removeObject(limiter);
            getWorld().showText(" " , 300, 400);
            limited = false;
            limiter.speed = 2;
            timer = 500;
        }
    }
    
    private void countTime()
    {
        timer--;
    }
    
    /*
     * Codes for the lives display that shows up on the screen.
     */
    public void countLives()
    {
        getWorld().showText("Lives: " + lives, 50, 20);
    }
    
    /*
     * The rocket gains a life if it has touched a heart floating by.
     */
    private void gainLives()
    {
        if(!cloaked)
        {
            if(isTouching(Lives.class))
            {
                lives++;
                Greenfoot.playSound("lifeGained.wav"); 
            }
        }
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            if(!limited)
            {
                fire();
            }
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
            if(!limited)
            {
                move(-5);
            }
        }
        
        if(Greenfoot.isKeyDown("z"))
        {
            if(!limited)
            {
                startProtonWave();
            }
        }
        
        if(Greenfoot.isKeyDown("tab"))
        {
            if(reloadDelayShadowCount >= shadowReloadTime)
            {
                if(!limited)
                {
                    cloaked = true;
                }
            }
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
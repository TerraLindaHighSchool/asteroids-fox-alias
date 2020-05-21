import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Part of the start screen that tells the player who their enemies are.
 * 
 * @author Jordan Miller
 * @version 1.0
 */
public class EnemiesScreen extends World
{

    /**
     * Constructor for objects of class EnemiesScreen.
     * 
     */
    public EnemiesScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(555, 536, 1); 
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new LastScreen());
        }
    }
}

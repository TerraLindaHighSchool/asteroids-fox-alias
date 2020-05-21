import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Part of the start screen that informs the player who their enemies are.
 * 
 * @author Jordan Miller 
 * @version 1.0
 */
public class WeaponsScreen extends World
{

    /**
     * Constructor for objects of class WeaponsScreen.
     * 
     */
    public WeaponsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(555, 555, 1); 
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
           Greenfoot.setWorld(new EnemiesScreen()); 
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponsScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

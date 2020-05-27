import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The last part of the start screen that illustates any other details the player should know.
 * 
 * @author Jordan Miller 
 * @version 1.0
 */
public class LastScreen extends World
{

    /**
     * Constructor for objects of class LastScreen.
     * 
     */
    public LastScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(555, 563, 1); 
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {

            Greenfoot.setWorld(new Space());
        }
    }
}

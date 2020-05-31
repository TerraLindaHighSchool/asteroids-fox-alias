 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When a rocket touches this, it stops moving and is unable to use most of its weapons.
 * 
 * @author Jordan Miller
 * @version 1.0
 */
public class Limiter extends SmoothMover
{
    public static int speed = 2; //speed at which the limiter moves.
    
    public Limiter()
    {
        //for testing purposes
    }
    
    /**
     * Act - do whatever the Limiter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed); //movement
        randomTurns(); 
        checkAtEdge();
    }  
    
    /*
     * If the limiter is at the edge of the world, it will disappear.
     */
    private void checkAtEdge()
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    /*
     * Programs some random turns into the limiter.
     */
    private void randomTurns()
    {
        int angle = Greenfoot.getRandomNumber(360);
        
        if(angle <= 180)
        {
            if(angle <= 90)
            {
                int variAngle1 = Greenfoot.getRandomNumber(30); 
                
                if(variAngle1 <= 15)
                {
                    turn(-4);
                } else if(variAngle1 >= 15) {
                    turn(-3);
                }
                
            } else if (angle >= 90) {
                int variAngle2 = Greenfoot.getRandomNumber(30);
                
                if(variAngle2 <= 15)
                {
                    turn(-2);
                } else if(variAngle2 >= 15) {
                    turn(-1);
                }
                
            }
        }
        else if(angle >= 180) {
               
                if(angle <= 270)
               {
                   int variAngle3 = Greenfoot.getRandomNumber(30);
                   
                   if(variAngle3 <= 15)
                   {
                       turn(4);
                   } else if(variAngle3 >= 15){
                       turn(3);
                   }
                   
               } else if (angle >= 270) {
                   int variAngle4 = Greenfoot.getRandomNumber(30);
                   
                   if(variAngle4 <= 15)
                   {
                       turn(2);
                   } else if(variAngle4 >= 15){
                       turn(1);
                   }
                   
               }
        }
    }
}

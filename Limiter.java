 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Limiter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Limiter extends SmoothMover
{
    public static int speed = 2;
    
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
        move(speed);
        randomTurns();
        checkAtEdge();
    }  
    
    private void checkAtEdge()
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
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

import greenfoot.*;
import java.util.List;

/**
 * A proton wave that expands and destroys asteroids in its path.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class ProtonWave extends Actor
{
    /** The damage this wave will deal */
    private static final int DAMAGE = 30;
    
    /** How many images should be used in the animation of the wave */
    private static final int NUMBER_IMAGES= 30;
    
    /** 
     * The images of the wave. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    private int currentImage = 0;
    
    /**
     * Create a new proton wave.
     */
    public ProtonWave() 
    {
        setImage("wave.png");
        Greenfoot.playSound("proton.wav");
        initializeImages();
    }
    
    /** 
     * Create the images for expanding the wave.
     */
    public static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            int i = 0;
            while (i < NUMBER_IMAGES) 
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
                i++;
            }
        }
    }
    
    //This method animates the proton wave!
    private void grow()
    {
        setImage(images[currentImage]);
        currentImage++;
        
        if(currentImage == images.length)
        {
            getWorld().removeObject(this);
        }
    }
    
    /*
     * To check whether the wave touches an asteroid, and cause damage if it does. 
     */
    private void checkCollision()
    {
        int radiusOfWave = getImage().getWidth() / 2;
            
        List<Asteroid> nearByAsteroids = getObjectsInRange(radiusOfWave, Asteroid.class);
 
        for(Asteroid asteroid : nearByAsteroids)
        {
            ((Asteroid) asteroid).hit(DAMAGE);
            getWorldOfType(Space.class).updateScore(1); //updates score when asteroid is destroyed by the wave
        }
    }
        
    /**
     * Act for the proton wave is: grow and check whether we hit anything.
     */
    public void act()
    { 
        checkCollision();
        grow();
    }
    
}

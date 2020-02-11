import greenfoot.*;

/**
 * Space. Something for rockets to fly in. Covered with lots of different stars.
 * 
 * @author Michael Kölling and Jordan Miller
 * @version 1.2
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    //private Color starBrightness;

    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        paintStars(400); //Paints 400 stars.
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    /*
     * This method paints stars in various shades, shapes, and brightnesses.
     */
    private void paintStars(int count) 
    {
        GreenfootImage background = getBackground();
        
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int width = Greenfoot.getRandomNumber(6); //sets the range of size
            int length = width;
            
            background.fillOval(x, y, width, length);
            
            int alpha = Greenfoot.getRandomNumber(215);
            int tint = alpha + Greenfoot.getRandomNumber(150);
            
            //If the random number plus alpha is too high for the color parameters, it is defaulted to white.
            if(alpha > 255)
            {
                alpha = 255;
            }
            
            if(tint > 255)
            {
                tint = alpha;
            }
            
            Color alphaColor =  new Color(tint, alpha, alpha);
            background.setColor(alphaColor); //sets the color!
        }
    }
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing.
    }

}
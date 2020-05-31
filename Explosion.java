import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Well...I did it the hard way. In this class, the explosion animation is coded.
 * 
 * @author Jordan Miller
 * @version 1.0
 */
public class Explosion extends Actor
{
    GreenfootImage explosion1 = new GreenfootImage("explosion1.png");
    GreenfootImage explosion2 = new GreenfootImage("explosion2.png");
    GreenfootImage explosion3 = new GreenfootImage("explosion3.png");
    GreenfootImage explosion4 = new GreenfootImage("explosion4.png");
    GreenfootImage explosion5 = new GreenfootImage("explosion5.png");
    GreenfootImage explosion6 = new GreenfootImage("explosion6.png");
    GreenfootImage explosion7 = new GreenfootImage("explosion7.png");
    GreenfootImage explosion8 = new GreenfootImage("explosion8.png");
    GreenfootImage explosion9 = new GreenfootImage("explosion9.png");
    GreenfootImage explosion10 = new GreenfootImage("explosion10.png");
    GreenfootImage explosion11 = new GreenfootImage("explosion11.png");
    GreenfootImage explosion12 = new GreenfootImage("explosion12.png");
    GreenfootImage explosion13 = new GreenfootImage("explosion13.png");
    GreenfootImage explosion14 = new GreenfootImage("explosion14.png");
    GreenfootImage explosion15 = new GreenfootImage("explosion15.png");
    GreenfootImage explosion16 = new GreenfootImage("explosion16.png");
    GreenfootImage explosion17 = new GreenfootImage("explosion17.png");
    GreenfootImage explosion18 = new GreenfootImage("explosion18.png");
    GreenfootImage explosion19 = new GreenfootImage("explosion19.png");
    GreenfootImage explosion20 = new GreenfootImage("explosion20.png");
    GreenfootImage explosion21 = new GreenfootImage("explosion21.png");
    GreenfootImage explosion22 = new GreenfootImage("explosion22.png");
    GreenfootImage explosion23 = new GreenfootImage("explosion23.png");
    GreenfootImage explosion24 = new GreenfootImage("explosion24.png");
    GreenfootImage explosion25 = new GreenfootImage("explosion25.png");
    GreenfootImage explosion26 = new GreenfootImage("explosion26.png");
    GreenfootImage explosion27 = new GreenfootImage("explosion27.png");
    GreenfootImage explosion28 = new GreenfootImage("explosion28.png");
    GreenfootImage explosion29 = new GreenfootImage("explosion29.png");
    GreenfootImage explosion30 = new GreenfootImage("explosion30.png");
    GreenfootImage explosion31 = new GreenfootImage("explosion31.png");
    GreenfootImage explosion32 = new GreenfootImage("explosion32.png");
    GreenfootImage explosion33 = new GreenfootImage("explosion33.png");
    GreenfootImage explosion34 = new GreenfootImage("explosion34.png");
    GreenfootImage explosion35 = new GreenfootImage("explosion35.png");
    
    public Explosion()
    {
        Greenfoot.playSound("MetalExplosion.wav");
        setImage(explosion1);
    }
    
    /**
     * Act - do whatever the ExplosionE wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getImage() == explosion1)
        {
            setImage(explosion2);
        } else if(getImage() == explosion2)
        {
            setImage(explosion3);
        } else if(getImage() == explosion3)
        {
            setImage(explosion4);
        } else if(getImage() == explosion4)
        {
            setImage(explosion5);
        } else if(getImage() == explosion5)
        {
            setImage(explosion6);
        } else if(getImage() == explosion6)
        {
            setImage(explosion7);
        } else if(getImage() == explosion7)
        {
            setImage(explosion8);
        } else if(getImage() == explosion8)
        {
            setImage(explosion9);
        } else if(getImage() == explosion9)
        {
            setImage(explosion10);
        } else if(getImage() == explosion10)
        {
            setImage(explosion11);
        } else if(getImage() == explosion11)
        {
            setImage(explosion12);
        } else if(getImage() == explosion12)
        {
            setImage(explosion13);
        } else if(getImage() == explosion13)
        {
            setImage(explosion14);
        } else if(getImage() == explosion14)
        {
            setImage(explosion15);
        } else if(getImage() == explosion15)
        {
            setImage(explosion16);
        } else if(getImage() == explosion16)
        {
            setImage(explosion17);
        } else if(getImage() == explosion17)
        {
            setImage(explosion18);
        } else if(getImage() == explosion18)
        {
            setImage(explosion19);
        } else if(getImage() == explosion19)
        {
            setImage(explosion20);
        } else if(getImage() == explosion20)
        {
            setImage(explosion21);
        } else if(getImage() == explosion21)
        {
            setImage(explosion22);
        } else if(getImage() == explosion22)
        {
            setImage(explosion23);
        } else if(getImage() == explosion23)
        {
            setImage(explosion24);
        } else if(getImage() == explosion24)
        {
            setImage(explosion25);
        } else if(getImage() == explosion25)
        {
            setImage(explosion26);
        } else if(getImage() == explosion26)
        {
            setImage(explosion27);
        } else if(getImage() == explosion27)
        {
            setImage(explosion28);
        } else if(getImage() == explosion28)
        {
            setImage(explosion29);
        } else if(getImage() == explosion29)
        {
            setImage(explosion30);
        } else if(getImage() == explosion30)
        {
            setImage(explosion31);
        } else if(getImage() == explosion31)
        {
            setImage(explosion32);
        } else if(getImage() == explosion32)
        {
            setImage(explosion33);
        } else if(getImage() == explosion33)
        {
            setImage(explosion34);
        } else if(getImage() == explosion34)
        {
            setImage(explosion35);
        } else if(getImage() == explosion35)
        {
            getWorld().removeObject(this);
        }
    }    
}

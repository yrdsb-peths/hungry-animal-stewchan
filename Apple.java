import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    
    public void act()
    {
        int x = getX();
        int y = getY() + 3;
        setLocation(x, y);
        
    }
}

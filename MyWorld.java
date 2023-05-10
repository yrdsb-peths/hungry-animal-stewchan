import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1);
        Elephant elephant = new Elephant();
        addObject(elephant, 100, 300);
        
        spawnApple();
    }
    
    public void spawnApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(apple, x, y);
    }
}

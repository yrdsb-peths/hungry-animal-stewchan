import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor{

    public void act() {
        if(Greenfoot.isKeyDown("d")){
            move(5);
        }
        if(Greenfoot.isKeyDown("a")){
            move(-5);
        }
        
        
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
        }
    }
}

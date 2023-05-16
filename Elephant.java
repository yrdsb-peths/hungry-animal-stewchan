import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor{
    GreenfootSound sound = new GreenfootSound("elephantcub.mp3");

    public void act() {
        if(Greenfoot.isKeyDown("d")){
            move(5);
        }
        if(Greenfoot.isKeyDown("a")){
            move(-5);
        }
        
        // Elephant eats the apple
        if (isTouching(Apple.class)){
            sound.play();
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
        }
    }
}

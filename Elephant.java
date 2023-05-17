import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor{
    GreenfootSound sound = new GreenfootSound("elephantcub.mp3");

    GreenfootImage[] images = new GreenfootImage[8];
    
    public Elephant(){        
        for(int i = 0; i < images.length; i++) {
            images[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            images[i].scale(100,100);
        }
        setImage(images[0]);
    }
    
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

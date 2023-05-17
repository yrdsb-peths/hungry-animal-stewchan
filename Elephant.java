import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor{
    GreenfootSound sound = new GreenfootSound("elephantcub.mp3");

    GreenfootImage[] images = new GreenfootImage[8];
    SimpleTimer animTimer = new SimpleTimer();
    
    public Elephant(){  
        // Load elephant images
        for(int i = 0; i < images.length; i++) {
            images[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            images[i].scale(100,100);
        }
        setImage(images[0]);
        
        // Reset the timer
        animTimer.mark();
    }
    
    private int imageIndex = 0;
    public void animateElephant(){
        if(animTimer.millisElapsed() > 100) {
            imageIndex = (imageIndex + 1) % images.length;
            setImage(images[imageIndex]);
            animTimer.mark();
        }
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("d")){
            move(5);
        }
        if(Greenfoot.isKeyDown("a")){
            move(-5);
        }
        
        // Animate the elephant
        animateElephant();
        
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

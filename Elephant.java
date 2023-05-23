import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor{
    GreenfootSound sound = new GreenfootSound("elephantcub.mp3");

    GreenfootImage[] rightImages = new GreenfootImage[8];
    GreenfootImage[] leftImages = new GreenfootImage[8];
    SimpleTimer animTimer = new SimpleTimer();
    boolean facingRight = true;
    
    public Elephant(){  
        // Load elephant images
        for(int i = 0; i < rightImages.length; i++) {
            rightImages[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            rightImages[i].scale(100,100);
            // leftImages[i] = rightImages[i];
            leftImages[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            leftImages[i].mirrorHorizontally();
            leftImages[i].scale(100,100);
        }
        setImage(leftImages[0]);
        
        // Reset the timer
        animTimer.mark();
    }
    
    private int imageIndex = 0;
    public void animateElephant(){
        if(facingRight) {
            if(animTimer.millisElapsed() > 100) {
                imageIndex = (imageIndex + 1) % rightImages.length;
                setImage(rightImages[imageIndex]);
                animTimer.mark();
            }
        } else {
            if(animTimer.millisElapsed() > 100) {
                imageIndex = (imageIndex + 1) % leftImages.length;
                setImage(leftImages[imageIndex]);
                animTimer.mark();
            }
        }
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("d")){
            facingRight = true;
            move(5);
        }
        if(Greenfoot.isKeyDown("a")){
            facingRight = false;
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

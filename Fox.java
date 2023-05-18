import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fox extends Actor{
    
    GreenfootImage[] idleImages = new GreenfootImage[5];
    SimpleTimer animTimer = new SimpleTimer();
    
    public Fox() {
        for(int i = 0; i < idleImages.length; i++){
            idleImages[i] = new GreenfootImage("fox/fox_0" + i + ".png");
            idleImages[i].scale(100,100);
        }
        setImage(idleImages[0]);
        animTimer.mark();
    }
    
    int animIndex = 0;
    public void animateIdle(){
        if(animTimer.millisElapsed() > 100) {
            animIndex = (animIndex + 1) % idleImages.length;
            setImage(idleImages[animIndex]);
            animTimer.mark();
        }
    }
    
    public void act() {
        // Add your action code here.
        animateIdle();
    }
}

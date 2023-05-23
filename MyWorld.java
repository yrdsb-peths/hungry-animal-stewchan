import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    Label gameOverLabel;
    
    public MyWorld()
    {    
        super(600, 400, 1, false);
        
        GreenfootImage bgImage = new GreenfootImage("Backgrounds/backgroundColorGrass.png");
        bgImage.scale(500, 500);
        setBackground(bgImage);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 100, 300);
        
        //Fox fox = new Fox();
        //addObject(fox, 500, 300);
        
        // Score
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        spawnApple();
    }
    
    public void spawnApple(){
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    public void gameOver(){
        // Game over
        gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
}

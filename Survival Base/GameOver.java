import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World
{
    public GameOver()
    {    
        super(600, 400, 1);
        
        BotaoReturn botaoReturn = new BotaoReturn();
        addObject(botaoReturn,317,300);
    }
}

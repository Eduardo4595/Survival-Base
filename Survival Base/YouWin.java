import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class YouWin extends World
{
    public YouWin()
    {    
        super(600, 400, 1); 
        
        BotaoReturn botaoReturn = new BotaoReturn();
        addObject(botaoReturn,292,300);
    }
}

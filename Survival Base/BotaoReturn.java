import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BotaoReturn extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Lobby());
            Greenfoot.playSound("Click.mp3");
        }
    }
}

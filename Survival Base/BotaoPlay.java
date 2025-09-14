import greenfoot.*;

public class BotaoPlay extends Actor
{
    public int start = 0;
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CenarioBase());
            Greenfoot.playSound("Click.mp3");
            start++;
        }
    }
}

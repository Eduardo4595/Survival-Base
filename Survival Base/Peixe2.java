import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Peixe2 extends Actor
{
    public void act()
    {
        move(2);
        
        if (isAtEdge()) {
            getWorld().removeObject(this);  // remove o ator atual
        }
    }
}

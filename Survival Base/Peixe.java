import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Peixe extends Actor
{
    public void act()
    {
        move(2);
        setRotation(180);
        
        if (isAtEdge()) {
            getWorld().removeObject(this);  // remove o ator atual
        }
    }
}

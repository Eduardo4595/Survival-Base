import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inimigo extends Actor
{
    public int espera = 0;
    public int som = 0;
    
    public void act()
    {
        espera++;
        
        if (!getWorld().getObjects(Jogador.class).isEmpty()) {
            Jogador j = (Jogador) getWorld().getObjects(Jogador.class).get(0);

            // gira na direção do jogador
            turnTowards(j.getX(), j.getY());

            // anda para frente (ajuste a velocidade)
            move(2);
        }
        
        if(espera==60){
            som++;
            espera = 0;
        }
        
        if(som == 2){
            Greenfoot.playSound("Spider.mp3");
            som = 0;
        }
    }
}

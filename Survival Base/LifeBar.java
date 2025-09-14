import greenfoot.*;

public class LifeBar extends Actor
{
    public void act()
    {
        setLife();
    }
    
    void setLife() {
        if (Jogador.vida == 5) {
            setImage("full.png");
        } else if (Jogador.vida == 4) {
            setImage("primeiroHit.png");
        } else if (Jogador.vida == 3) {
            setImage("segundoHit.png");
        } else if (Jogador.vida == 2) {
            setImage("terceiroHit.png");
        } else {
            setImage("quartoHit.png");
        }
    }
}

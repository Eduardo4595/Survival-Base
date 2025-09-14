import greenfoot.*;

public class Jangada extends Actor
{
    private boolean AMOUNT_WOOD_FIX = false;
    private boolean AMOUNT_ROCK_FIX = false;
    private boolean FIXED = false;
    private byte yUpEndGame = 0;

    public void act()
    {
        verifyWin();
        build();
        runAway();
        verifyItens();
    }
    
    void verifyItens(){
        if (Jogador.madeiras >= 5 && Jogador.pedras >= 5){
            AMOUNT_WOOD_FIX = true;
            AMOUNT_ROCK_FIX = true;
        }
    }
    
    void verifyWin() {
        setLocation(getX(), getY() - yUpEndGame);
        if(yUpEndGame == 1 && FIXED == true && getY() == 0) {
            //Jogador.musica.stop();
            Greenfoot.setWorld(new YouWin());
            Greenfoot.playSound("Win.mp3");
        }
    }
    void runAway() {
      
        if(FIXED && Greenfoot.isKeyDown("j") && isTouching(Jogador.class)) {
            setImage("playerjangada.png");
            removeTouching(Jogador.class);
            yUpEndGame = 1;
        }
    }

    void build() {
        Jogador j = (Jogador) getOneIntersectingObject(Jogador.class);

        if(j != null && AMOUNT_ROCK_FIX == true && AMOUNT_WOOD_FIX == true) {
            setImage("Jangada.png");
            FIXED = true;
        }
    }

    //boolean isItemsOkayToRepair(Jogador j) {
        //return j.getAmountWood() == AMOUNT_WOOD_FIX && j.getAmountRock() == AMOUNT_ROCK_FIX;
    //}

    void setBroken() {
        setImage("jangadasabugada.png");
    }
}


import greenfoot.*;

public class CenarioBaixo extends World
{
    int numPedras = 3;
    int numArvores = 3;
    int numInimigos = 2;
    int numArmadilhas = 3;

    public CenarioBaixo()
    {    
        super(600, 400, 1); 
    }

    public CenarioBaixo(int posX)
    {    
        super(600, 400, 1);

        Jogador jogador = new Jogador();
        addObject(jogador, posX, 2);

        LifeBar lifebar = new LifeBar();
        addObject(lifebar,80,40);
        apperEnnemies();
        apperItens();
        
        MadeiraInventario madeiraInventario = new MadeiraInventario();
        addObject(madeiraInventario,45,65);
        
        PedraInventario pedraInventario = new PedraInventario();
        addObject(pedraInventario,45,95);
    }

    void apperItens()
    {
        for (int i = 0; i < numPedras; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Pedra(), x, y);
        }

        for (int i = 0; i < numArvores; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Árvore(), x, y);
        }
    }

    void apperEnnemies()
    {
        for (int i = 0; i < numInimigos; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Inimigo(), x, y);
        }

        for (int i = 0; i < numArmadilhas; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Armadilhas(), x, y);
        }
    }
}

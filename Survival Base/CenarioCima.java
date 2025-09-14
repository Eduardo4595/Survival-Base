import greenfoot.*;

public class CenarioCima extends World
{
    int numPeixes = 1;
    
    public CenarioCima()
    {    
        super(600, 400, 1); 
    }
    
    public CenarioCima(int posX)
    {     
        super(600, 400, 1);
        
        Jogador jogador = new Jogador();
        addObject(jogador, posX, 598);
        
        Jangada jangada = new Jangada();
        jangada.setBroken();
        addObject(jangada, 527, 237);
        
        LifeBar lifebar = new LifeBar();
        addObject(lifebar,80,40);
        
        MadeiraInventario madeiraInventario = new MadeiraInventario();
        addObject(madeiraInventario,45,65);
        
        PedraInventario pedraInventario = new PedraInventario();
        addObject(pedraInventario,45,95);
          

        spawnFish();
        exchangeRaft();
        animation();
    }
    
    void spawnFish()
    {
        for (int i = 0; i < numPeixes; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            addObject(new Peixe(), x, 30);
        }
        
        //Segundo peixe, esse anda(nada) para uma direção diferente do peixe anterior
        for (int i = 0; i < numPeixes; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            addObject(new Peixe2(), x, 30);
        }
    }
    
    void exchangeRaft()
    {
        if(Jogador.message == 1)
        {
             Jangada jangada = new Jangada();
             addObject(jangada, 527, 237);
        }
    }
    
    void animation()
    {
        if(Jogador.message == 1) {
            removeObjects(getObjects(Jogador.class));
            removeObjects(getObjects(Jangada.class));
            
            //PlayerJangada playerJangada = new PlayerJangada();
            //addObject(playerJangada, 527, 237);
        }

    }
}


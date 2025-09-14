import greenfoot.*;

public class CenarioBase extends World
{
    public CenarioBase()
    {   
        super(600, 400, 1);
        prepare();
        
        Jogador.resetPoint();
    }

    public CenarioBase(int pY)
    {   
        super(600, 400, 1);

        Jogador jogador = new Jogador();
        addObject(jogador,598,pY);
        
        LifeBar lifebar = new LifeBar();
        addObject(lifebar,80,40);
        
        MadeiraInventario madeiraInventario = new MadeiraInventario();
        addObject(madeiraInventario,45,65);
        
        PedraInventario pedraInventario = new PedraInventario();
        addObject(pedraInventario,45,95);
    }
    
    public CenarioBase(int pY, int pX)
    {   
        super(600, 400, 1);
        Jogador jogador = new Jogador();
        addObject(jogador, pX, pY);
        
        LifeBar lifebar = new LifeBar();
        addObject(lifebar,80,40);
        
        MadeiraInventario madeiraInventario = new MadeiraInventario();
        addObject(madeiraInventario,45,65);
        
        PedraInventario pedraInventario = new PedraInventario();
        addObject(pedraInventario,45,95);
    }

    private void prepare()
    {
        Jogador jogador = new Jogador();
        addObject(jogador,71,206);
        
        LifeBar lifebar = new LifeBar();
        addObject(lifebar,80,40);
        
        MadeiraInventario madeiraInventario = new MadeiraInventario();
        addObject(madeiraInventario,45,65);
        
        PedraInventario pedraInventario = new PedraInventario();
        addObject(pedraInventario,45,95);
    }
}


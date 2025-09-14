import greenfoot.*;

public class Lobby extends World
{
    public Lobby()
    {    
        super(600, 400, 1);
        prepare();
    }
    
    private void prepare()
    {
        BotaoPlay botaoPlay = new BotaoPlay();
        addObject(botaoPlay,292,300);
    }
}

import greenfoot.*;

public class Jogador extends Actor
{
    ///public static GreenfootSound musica = new GreenfootSound("Musica.mp3");
    public static int vida = 5;
    public static int madeiras = 0;
    public static int pedras = 0;
    public static int message = 0;
    public static int contador = 0;
    public static int timer = 0;
    public static int dias = 0;
    
    public void act()
    {
        movePlayer();
        exchangeScenarios();
        verificationScenarios();
        collectResources();
        damageEnemies();
        diePlayer();
        message();
        time();
        timeOver();
        sound();
        
        getWorld().showText("" +madeiras, 70, 65);
        getWorld().showText("" +pedras, 70, 95);
        getWorld().showText("Day = " +dias , 300, 30);
        getWorld().showText("Timer = " +timer+ "s" , 540, 380);
    }
    
    void sound(){
        //musica.playLoop();
    }
    
    void movePlayer()
    {
        if (Greenfoot.isKeyDown("w")) {
            setRotation(270); // Cima
            move(3);
        }
        if (Greenfoot.isKeyDown("s")) {
            setRotation(90); // Baixo
            move(3);
        }
        if (Greenfoot.isKeyDown("a")) {
            setRotation(180); // Esquerda
            move(3);
        }
        if (Greenfoot.isKeyDown("d")) {
            setRotation(0); // Direita
            move(3);
        }
    }
    
    public int getAmountWood() {
        return madeiras;
    }
    
    public int getAmountRock() {
        return pedras;
    }
    
    void exchangeScenarios()
    {
        if(getWorld() instanceof CenarioDireita) {
            //Trocar de cenários
            if (getX() < 1) {
                int posicaoY = getY();
                Greenfoot.setWorld(new CenarioBase(posicaoY));  
            }
        }

        if(getWorld() instanceof CenarioEsquerda) {
            //Trocar de cenários
            if (getX() > 598) {
                int posicaoY = getY();
                Greenfoot.setWorld(new CenarioBase(posicaoY, 2));
            }
        }
        
        if(getWorld() instanceof CenarioBaixo) {
            //Trocar de cenários
            if (getY() < 1) {
                int posicaoX = getX();
                Greenfoot.setWorld(new CenarioBase(598, posicaoX));
            }
        }
        
        if(getWorld() instanceof CenarioCima) {
            //Trocar de cenários
            if (getY() > 398) {
                int posicaoX = getX();
                Greenfoot.setWorld(new CenarioBase( 2, posicaoX));
            }
        }
    }
    
    void verificationScenarios()
    {
        if(getWorld() instanceof CenarioBase) {
            if (getX() + 1 == getWorld().getWidth()) {
                int posicaoY = getY();
                Greenfoot.setWorld(new CenarioDireita(posicaoY));
                Greenfoot.playSound("Troca.mp3");
            }
            if (getX() == 0) {
                int posicaoY = getY();
                Greenfoot.setWorld(new CenarioEsquerda(posicaoY));
                Greenfoot.playSound("Troca.mp3");
            }
            if (getY() + 1 == getWorld().getHeight()) {
                int posicaoX = getX();
                Greenfoot.setWorld(new CenarioBaixo(posicaoX));
                Greenfoot.playSound("Troca.mp3");
            }
            if (getY() < 2 ) {
                int posicaoX = getX();
                Greenfoot.setWorld(new CenarioCima(posicaoX));
                Greenfoot.playSound("Troca.mp3");
            }
        }
    }
    
    void collectResources()
    {
        if (isTouching(Árvore.class) && (Greenfoot.isKeyDown("f"))){
            madeiras++;
            removeTouching(Árvore.class);
            Greenfoot.playSound("Collect.mp3");
        }
        if (isTouching(Pedra.class) && (Greenfoot.isKeyDown("f"))){
            pedras++;
            removeTouching(Pedra.class);
            Greenfoot.playSound("Collect.mp3");
        }
        
        //Peixe1
        if (vida < 5 && isTouching(Peixe.class) && (Greenfoot.isKeyDown("f"))){
            vida++;
            removeTouching(Peixe.class);
            Greenfoot.playSound("Collect.mp3");
        }
        
        //Peixe2
        if (vida < 5 && isTouching(Peixe2.class) && (Greenfoot.isKeyDown("f"))){
            vida++;
            removeTouching(Peixe2.class);
            Greenfoot.playSound("Collect.mp3");
        }
    }
    
    void damageEnemies()
    {
        if (isTouching(Inimigo.class)){
            vida--;
            removeTouching(Inimigo.class);
            Greenfoot.playSound("Damage.mp3");
        }
        
        if (isTouching(Armadilhas.class)){
            vida--;
            removeTouching(Armadilhas.class);
            Greenfoot.playSound("Trap.mp3");
        }
    }
    
    void diePlayer()
    {
        if(vida == 0)
        {
            //musica.stop();
            Greenfoot.setWorld(new GameOver());
            Greenfoot.playSound("Over.mp3");
        }
    }
    
    void message()
    {
        if(madeiras >= 3 && pedras >= 3 && (isTouching(Jangada.class)) && (Greenfoot.isKeyDown("f")))
        {
            //removeTouching(JangadaSabugada.class);
            message++;
        }
    }
    
    void time()
    {
        contador++;
        
        if (contador == 60)
        {
            contador = 0;
            timer++;
        }
        
        else if (timer == 30)
        {
            dias = 1;
        }
        
        else if (timer == 60)
        {
            dias = 2;
        }
        
        else if (timer == 90)
        {
            dias = 3;
        }
    }
    
    void timeOver()
    {
        if (dias == 3)
        {
           //musica.stop();
            Greenfoot.setWorld(new GameOver());
           Greenfoot.playSound("Over.mp3");
        }
    }
    
    public static void resetPoint() {
        vida = 5;
        madeiras = 0;
        pedras = 0;
        message = 0;
        timer = 0;
        contador = 0;
        dias = 0;
    }
}

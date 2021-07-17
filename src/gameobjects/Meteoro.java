package gameobjects;

import main.Database;

import java.awt.*;

public class Meteoro {
    private final int minLado = 0;
    private final int maxLado = 1;
    private final int minAltura = 0;

    private Image sprite;
    private int lado; //1 = esquerda, -1 = direita
    private int velocidadeX;
    private int velocidadeY;
    private int posX;
    private int posY;
    private int diametro;

    public Meteoro(int maxAltura, int maxLargura) throws Exception{
        this.sprite = Database.getSpriteMeteoro();
        this.lado = (int)(Math.random()*(maxLado - minLado + 1) + minLado);
        if(this.lado == 0){
            this.lado = -1;
        }
        this.diametro = (int)(Math.random()*(Database.getMaxDiametroMeteoro() - Database.getMinDiametroMeteoro() + 1) + Database.getMinDiametroMeteoro());
        this.posY = (int)(Math.random()*(maxAltura - minAltura + 1) + minAltura);
        this.velocidadeX = this.lado * (int)(Math.random()*(Database.getMaxVelocidadeMeteoro() - Database.getMinVelocidadeMeteoro() + 1) + Database.getMinVelocidadeMeteoro());
        this.velocidadeY = (int)(Math.random()*(Database.getMaxVelocidadeMeteoro() - Database.getMinVelocidadeMeteoro() + 1) + Database.getMinVelocidadeMeteoro());
        if(this.posY - minAltura > maxAltura - this.posY){
            velocidadeY = velocidadeY * (-1);
        }
        if(this.lado > 0){
            this.posX = this.getDiametro() * (-1);
        }
        else {
            this.posX = maxLargura + this.getDiametro();
        }
    }

    public void movimentar(){
        this.posX = this.posX + this.velocidadeX;
        this.posY = this.posY + this.velocidadeY;
    }

    public boolean checarHitbox(Integer[] posNave, Integer naveLargura, Integer naveAltura){
        return this.posX > posNave[0] - this.diametro && this.posX < posNave[0] + naveLargura
                && this.posY < posNave[1] + naveAltura && this.posY > posNave[1] - this.diametro;
    }

    public Image getSprite() {
        return sprite;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDiametro() {
        return diametro;
    }
}

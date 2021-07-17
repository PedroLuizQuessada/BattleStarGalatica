package gameobjects;

import java.awt.*;

public class Disparo {
    private Image sprite;
    private int posX;
    private int posY;
    private int velocidade;
    private int largura;
    private int comprimento;

    public Disparo(Disparo disparoModelo, Integer posXInicial, Integer posYInicial){
        this.sprite = disparoModelo.getSprite();
        this.velocidade = disparoModelo.velocidade;
        this.largura = disparoModelo.getLargura();
        this.comprimento = disparoModelo.getComprimento();

        this.posX = posXInicial;
        this.posY = posYInicial;
    }

    public Disparo(){ }

    public void movimentar(){
        this.posY = this.posY - this.velocidade;
    }

    public boolean checarHitbox(Integer[] posNave, Integer naveLargura, Integer naveAltura) {
        return this.posX > posNave[0] - this.largura && this.posX < posNave[0] + naveLargura
                && this.posY < posNave[1] + naveAltura && this.posY > posNave[1];
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }
}

package gameobjects;

import main.Database;

import java.awt.*;

public class Nave {
    private int id;
    private Image spriteNave;
    private int velocidade;
    private int velocidadeNormal;
    private int velocidadeReparo;
    private int velocidadeTurbo;
    private int cooldownDisparo;
    private int larguraNave;
    private int alturaNave;
    private int alturaNaveAux;
    private int distanciaArma1;
    private int distanciaArma2 = 0;
    private int posX;
    private int posY;
    private Disparo disparo = new Disparo();

    public Nave(Integer posInicialX){
        this.posX = posInicialX;
        this.posY = 0;
    }

    public void atirar(java.util.List<Disparo> disparos){
        switch (this.id){
            case Database.ID_COPENDIUM:
                disparos.add(new Disparo(disparo, this.getPosX() + this.distanciaArma1, this.getPosY()));
                disparos.add(new Disparo(disparo, this.getPosX() + this.distanciaArma2, this.getPosY()));
                break;
            default:
                disparos.add(new Disparo(disparo, this.getPosX() + this.distanciaArma1, this.getPosY()));
                break;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getSpriteNave() {
        return spriteNave;
    }

    public void setSpriteNave(Image spriteNave) {
        this.spriteNave = spriteNave;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelocidadeNormal() {
        return velocidadeNormal;
    }

    public void setVelocidadeNormal(int velocidadeNormal) {
        this.velocidadeNormal = velocidadeNormal;
    }

    public int getVelocidadeReparo() {
        return velocidadeReparo;
    }

    public void setVelocidadeReparo(int velocidadeReparo) {
        this.velocidadeReparo = velocidadeReparo;
    }

    public int getVelocidadeTurbo() {
        return velocidadeTurbo;
    }

    public void setVelocidadeTurbo(int velocidadeTurbo) {
        this.velocidadeTurbo = velocidadeTurbo;
    }

    public int getCooldownDisparo() {
        return cooldownDisparo;
    }

    public void setCooldownDisparo(int cooldownDisparo) {
        this.cooldownDisparo = cooldownDisparo;
    }

    public int getLarguraNave() {
        return larguraNave;
    }

    public void setLarguraNave(int larguraNave) {
        this.larguraNave = larguraNave;
    }

    public int getAlturaNave() {
        return alturaNave;
    }

    public void setAlturaNave(int alturaNave) {
        this.alturaNave = alturaNave;
    }

    public void setDistanciaArma1(int distanciaArma1) {
        this.distanciaArma1 = distanciaArma1;
    }

    public void setDistanciaArma2(int distanciaArma2) {
        this.distanciaArma2 = distanciaArma2;
    }

    public int getAlturaNaveAux() {
        return alturaNaveAux;
    }

    public void setAlturaNaveAux(int alturaNaveAux) {
        this.alturaNaveAux = alturaNaveAux;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Disparo getDisparo() {
        return disparo;
    }
}

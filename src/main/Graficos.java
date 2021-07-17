package main;

import exceptions.ImagemNaoEncontradaException;
import gameobjects.Disparo;
import gameobjects.Meteoro;
import gameobjects.Nave;

import javax.swing.*;
import java.awt.*;

public class Graficos extends JPanel {
    private final Image[] imagens = new Image[10];
    private final Image[] numeros = new Image[10];

    private final int FUNDO = 0;
    private final int VITORIA = 1;
    private final int DERROTA = 2;
    private final int VIDA_CHEIA = 3;
    private final int VIDA_VAZIA = 4;
    private final int ARMA = 5;
    private final int TURBO = 6;
    private final int REPARO = 7;
    private final int NAVE = 8;
    private final int DISPARO = 9;
    private final int NUM0 = 9;
    private final int NUM1 = 8;
    private final int NUM2 = 7;
    private final int NUM3 = 6;
    private final int NUM4 = 5;
    private final int NUM5 = 4;
    private final int NUM6 = 3;
    private final int NUM7 = 2;
    private final int NUM8 = 1;
    private final int NUM9 = 0;

    Graficos(Nave nave) throws ImagemNaoEncontradaException{
        try {
            imagens[FUNDO] = Database.getSpriteFundo();
            imagens[VITORIA] = Database.getSpriteVitoria();
            imagens[DERROTA] = Database.getSpriteDerrota();
            imagens[VIDA_CHEIA] = Database.getSpriteVidaCheia();
            imagens[VIDA_VAZIA] = Database.getSpriteVidaVazia();
            imagens[ARMA] = Database.getSpriteArma();
            imagens[TURBO] = Database.getSpriteTurbo();
            imagens[REPARO] = Database.getSpriteReparo();
            numeros[NUM0] = Database.getSpriteNum0();
            numeros[NUM1] = Database.getSpriteNum1();
            numeros[NUM2] = Database.getSpriteNum2();
            numeros[NUM3] = Database.getSpriteNum3();
            numeros[NUM4] = Database.getSpriteNum4();
            numeros[NUM5] = Database.getSpriteNum5();
            numeros[NUM6] = Database.getSpriteNum6();
            numeros[NUM7] = Database.getSpriteNum7();
            numeros[NUM8] = Database.getSpriteNum8();
            numeros[NUM9] = Database.getSpriteNum9();

            imagens[NAVE] = nave.getSpriteNave();
            imagens[DISPARO] = nave.getDisparo().getSprite();
        } catch (Exception e) {
            throw new ImagemNaoEncontradaException("básica do jogo");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (Jogo.vidaInimigo <= 0){
            g.drawImage(imagens[VITORIA], 0, 0, getSize().width, getSize().height, this);
            return;
        }
        else if (Jogo.vida <= 0){
            g.drawImage(imagens[DERROTA], 0, 0, getSize().width, getSize().height, this);
            return;
        }

        g.drawImage(imagens[FUNDO], 0, 0, getSize().width, getSize().height, this);

        if (Jogo.cdProtecao % 2 == 0) {
            g.drawImage(imagens[NAVE], Jogo.nave.getPosX(), Jogo.nave.getPosY(),this);
        }
        if (Jogo.cdProtecaoInimigo % 2 == 0) {
            g.drawImage(imagens[NAVE], Jogo.naveInimiga.getPosX(), Jogo.naveInimiga.getPosY() + Jogo.naveInimiga.getAlturaNave(), imagens[NAVE].getWidth(this), - imagens[NAVE].getHeight(this), this);
        }

        for (int i = 1; i <= 10; i++){
            if (Jogo.vida >= i || Jogo.cdReparo % 2 == 0 && Jogo.cdReparo < Database.getDuracaoReparo() && !Jogo.reparoOk) {
                g.drawImage(imagens[VIDA_CHEIA], 0, getSize().height - i * imagens[VIDA_CHEIA].getHeight(this), this);
            }
            else {
                g.drawImage(imagens[VIDA_VAZIA], 0, getSize().height - i * imagens[VIDA_CHEIA].getHeight(this), this);
            }
        }

        for (int i = 1; i <= 10; i++){
            if (Jogo.vidaInimigo >= i) {
                g.drawImage(imagens[VIDA_CHEIA], 0, i * imagens[VIDA_CHEIA].getHeight(this) - imagens[VIDA_CHEIA].getHeight(this), this);
            }
            else {
                g.drawImage(imagens[VIDA_VAZIA], 0, i * imagens[VIDA_VAZIA].getHeight(this) - imagens[VIDA_VAZIA].getHeight(this),this);
            }
        }

        for (Meteoro meteoro: Jogo.meteoros){
            if (!Jogo.meteorosContabilizados.contains(meteoro)) {
                g.drawImage(meteoro.getSprite(), meteoro.getPosX(), meteoro.getPosY(), meteoro.getDiametro(), meteoro.getDiametro(), this);
            }
        }

        for (Disparo disparo: Jogo.disparos){
            if (!Jogo.disparosContabilizados.contains(disparo)) {
                g.drawImage(disparo.getSprite(), disparo.getPosX(), disparo.getPosY(), disparo.getLargura(), disparo.getComprimento(), this);
            }
        }

        g.drawImage(imagens[REPARO], getSize().width - imagens[REPARO].getWidth(this), getSize().height - imagens[REPARO].getHeight(this),this);

        if (Jogo.cdReparo > 0){
            g.drawImage(numeros[Jogo.cdReparo / 10 + NUM9],getSize().width - imagens[REPARO].getWidth(this),getSize().height - imagens[REPARO].getHeight(this), imagens[REPARO].getWidth(this), imagens[REPARO].getHeight(this),this);
        }

        g.drawImage(imagens[TURBO], getSize().width - imagens[TURBO].getWidth(this), getSize().height - 2 * imagens[TURBO].getHeight(this),this);

        if (Jogo.cdTurbo > 0){
            g.drawImage(numeros[Jogo.cdTurbo / 10 + NUM6],getSize().width - imagens[TURBO].getWidth(this),getSize().height - 2 * imagens[TURBO].getHeight(this), imagens[TURBO].getWidth(this), imagens[TURBO].getHeight(this),this);
        }

        g.drawImage(imagens[ARMA], getSize().width - imagens[ARMA].getWidth(this), getSize().height - 3 * imagens[ARMA].getHeight(this),this);

        if (Jogo.cdDisparo > 0){
            g.drawImage(numeros[Jogo.cdDisparo / 10 + NUM3],getSize().width - imagens[ARMA].getWidth(this),getSize().height - 3 * imagens[ARMA].getHeight(this), imagens[ARMA].getWidth(this), imagens[ARMA].getHeight(this),this);
        }

        Toolkit.getDefaultToolkit().sync();
    }
}

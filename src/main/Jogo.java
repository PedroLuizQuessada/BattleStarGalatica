package main;

import exceptions.ImagemNaoEncontradaException;
import gameobjects.Disparo;
import gameobjects.Meteoro;
import gameobjects.Nave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Jogo extends JFrame{
    static int vida = 5;
    static int vidaInimigo = 10;
    static int cdDisparo = 0;
    boolean disparoOk = true;
    static int cdReparo = 0;
    static boolean reparoOk = true;
    static int cdTurbo = 0;
    boolean turboOk = true;
    static int cdProtecao = 0;
    static boolean protecaoOk = false;
    static int cdProtecaoInimigo = 0;
    static boolean protecaoInimigoOk = false;
    int contador = 0;
    int multiplicadorMeteoros = 1;

    static Graficos graficos;
    static Nave nave = new Nave(Database.getJanelaInicialLargura() / 2);
    static Nave naveInimiga = new Nave(Database.getJanelaInicialLargura() / 2);

    static java.util.List<Disparo> disparos = new ArrayList<>();
    static java.util.List<Disparo> disparosContabilizados = new ArrayList<>();
    static java.util.List<Meteoro> meteoros = new ArrayList<>();
    static java.util.List<Meteoro> meteorosContabilizados = new ArrayList<>();
    Timer t;

    Jogo() {
        super("BattleStar Galatica");
        setPreferredSize(new Dimension(Database.getJanelaInicialLargura(), Database.getJanelaInicialAltura()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(graficos);
        pack();
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && nave.getPosX() + nave.getVelocidade() < getSize().width - nave.getLarguraNave()){
                    nave.setPosX(nave.getPosX() + nave.getVelocidade());
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT && nave.getPosX() + nave.getVelocidade() >= getSize().width - nave.getLarguraNave()){
                    nave.setPosX(getSize().width - nave.getLarguraNave());
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT && nave.getPosX() - nave.getVelocidade() > 0){
                    nave.setPosX(nave.getPosX() - nave.getVelocidade());
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT && nave.getPosX() - nave.getVelocidade() <= 0){
                    nave.setPosX(0);
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP && nave.getPosY() - nave.getVelocidade() > (getSize().height / 2)){
                    nave.setPosY(nave.getPosY() - nave.getVelocidade());
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP && nave.getPosY() - nave.getVelocidade() <= getSize().height / 2){
                    nave.setPosY(getSize().height / 2);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN && nave.getPosY() + nave.getVelocidade() + nave.getAlturaNaveAux() < getSize().height){
                    nave.setPosY(nave.getPosY() + nave.getVelocidade());
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN && nave.getPosY() + nave.getVelocidade() + nave.getAlturaNaveAux() >= getSize().height){
                    nave.setPosY(getSize().height - nave.getAlturaNaveAux());
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    if (disparoOk) {
                        nave.atirar(disparos);
                        disparoOk = false;
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_Q){
                    if (reparoOk && !protecaoOk) {
                        reparoOk = false;
                        nave.setVelocidade(nave.getVelocidadeReparo());
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_W){
                    if (turboOk && vida > 1 && !protecaoOk) {
                        turboOk = false;
                        nave.setVelocidade(nave.getVelocidadeTurbo());
                        vida--;
                    }
                }
            }
        });
        t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checaDisparo();
                checaProtecao();
                checaReparo();
                checaTurbo();

                if (nave.getPosX() > getSize().width - nave.getLarguraNave()){
                    nave.setPosX(getSize().width - nave.getLarguraNave());
                }
                if (nave.getPosY() + nave.getAlturaNaveAux() > getSize().height){
                    nave.setPosY(getSize().height - nave.getAlturaNaveAux());
                }
                if (nave.getPosY() < (getSize().height / 2)){
                    nave.setPosY(getSize().height / 2);
                }
                if (getSize().width < Database.getJanelaMinimaLargura()){
                    setSize(Database.getJanelaMinimaLargura(), getSize().height);
                }
                if (getSize().height < Database.getJanelaMinimaAltura()){
                    setSize(getSize().width, Database.getJanelaMinimaAltura());
                }

                if (contador % 100 == 0) {
                    for (int i = 1; i <= multiplicadorMeteoros; i++) {
                        try {
                            meteoros.add(new Meteoro(getSize().height, getSize().width));
                        } catch (Exception ignored) { }
                    }
                }
                if (contador % 300 == 0){
                    multiplicadorMeteoros++;
                }
                contador++;

                for(Meteoro meteoro: meteoros){
                    meteoro.movimentar();
                }

                for(Disparo disparo: disparos){
                    disparo.movimentar();
                }

                graficos.repaint();

                for(Meteoro meteoro: meteoros){
                    if(!meteorosContabilizados.contains(meteoro) && meteoro.checarHitbox(new Integer[]{nave.getPosX(), nave.getPosY()}, nave.getLarguraNave(), nave.getAlturaNave())){
                        meteorosContabilizados.add(meteoro);
                        if (!protecaoOk) {
                            vida--;
                            protecaoOk = true;
                        }
                    }
                }

                for(Disparo disparo: disparos){
                    if(!disparosContabilizados.contains(disparo) && disparo.checarHitbox(new Integer[]{naveInimiga.getPosX(), naveInimiga.getPosY()}, naveInimiga.getLarguraNave(), naveInimiga.getAlturaNave())){
                        disparosContabilizados.add(disparo);
                        if (!protecaoInimigoOk) {
                            vidaInimigo--;
                            protecaoInimigoOk = true;
                        }
                    }
                }
            }
        });
        t.start();
    }

    static public void main(String[] args) {
        try {
            new Menu(nave);
        }
        catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
            new ExceptionHandler(imagemNaoEncontradaException.getMessage());
        }
    }

    public static void comecarJogo(){
        try {
            graficos = new Graficos(nave);
            new Jogo();
        }
        catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
            interrompeJogo(imagemNaoEncontradaException.getMessage());
        }
    }

    void checaDisparo(){
        if (!disparoOk) {
            cdDisparo++;
            if (cdDisparo == nave.getCooldownDisparo()) {
                cdDisparo = 0;
                disparoOk = true;
            }
        }
    }

    void checaProtecao(){
        if (protecaoInimigoOk){
            cdProtecaoInimigo++;
            if (cdProtecaoInimigo == Database.getCooldownProtecao()){
                cdProtecaoInimigo = 0;
                protecaoInimigoOk = false;
            }
        }
        if (protecaoOk){
            cdProtecao++;
            if (cdProtecao == Database.getCooldownProtecao()){
                cdProtecao = 0;
                protecaoOk = false;
            }
        }
    }

    void checaReparo(){
        if (!reparoOk){
            cdReparo++;
            if (cdReparo == Database.getCooldownReparo()){
                cdReparo = 0;
                reparoOk = true;
            }
            else if (cdReparo == Database.getDuracaoReparo()){
                vida++;
                nave.setVelocidade(nave.getVelocidadeNormal());
            }
        }
    }

    void checaTurbo(){
        if (!turboOk){
            cdTurbo++;
            if (cdTurbo == Database.getCooldownTurbo()){
                cdTurbo = 0;
                turboOk = true;
            }
            else if (cdTurbo == Database.getDuracaoTurbo()){
                nave.setVelocidade(nave.getVelocidadeNormal());
            }
        }
    }

    public static void interrompeJogo(String mensagem){
        new ExceptionHandler(mensagem);
    }
}

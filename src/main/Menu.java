package main;

import exceptions.ImagemNaoEncontradaException;
import gameobjects.Nave;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class Menu extends JFrame {

    Menu(Nave nave) throws ImagemNaoEncontradaException {
        super("BattleStar Galatica");

        JPanel opcoesNaves = new JPanel();
        opcoesNaves.setLayout(new GridLayout(2, 3));

        JLabel copendium = new JLabel();
        copendium.setOpaque(true);
        copendium.setBackground(Color.blue);
        copendium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        copendium.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    escolherNave(nave, 1);
                }
                catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
                    Jogo.interrompeJogo(imagemNaoEncontradaException.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                copendium.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                copendium.setBackground(Color.BLUE);
            }
        });
        opcoesNaves.add(copendium);
        JLabel caelestis = new JLabel();
        caelestis.setOpaque(true);
        caelestis.setBackground(Color.blue);
        caelestis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        caelestis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    escolherNave(nave, 2);
                }
                catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
                    Jogo.interrompeJogo(imagemNaoEncontradaException.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                caelestis.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                caelestis.setBackground(Color.BLUE);
            }
        });
        opcoesNaves.add(caelestis);
        JLabel prophet = new JLabel();
        prophet.setOpaque(true);
        prophet.setBackground(Color.blue);
        prophet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prophet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    escolherNave(nave, 3);
                }
                catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
                    Jogo.interrompeJogo(imagemNaoEncontradaException.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                prophet.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                prophet.setBackground(Color.BLUE);
            }
        });
        opcoesNaves.add(prophet);

        JEditorPane descricaoCopendium = new JEditorPane("text/html", "");
        descricaoCopendium.setEditable(false);
        descricaoCopendium.setText(Database.getDescricaoCopendium());
        descricaoCopendium.setBackground(Color.blue);
        descricaoCopendium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        descricaoCopendium.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    escolherNave(nave, 1);
                }
                catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
                    Jogo.interrompeJogo(imagemNaoEncontradaException.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                copendium.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                copendium.setBackground(Color.BLUE);
            }
        });
        opcoesNaves.add(descricaoCopendium);
        JEditorPane descricaoCaelestis = new JEditorPane("text/html", "");
        descricaoCaelestis.setEditable(false);
        descricaoCaelestis.setText(Database.getDescricaoCaelestis());
        descricaoCaelestis.setBackground(Color.blue);
        descricaoCaelestis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        descricaoCaelestis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    escolherNave(nave, 2);
                }
                catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
                    Jogo.interrompeJogo(imagemNaoEncontradaException.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                caelestis.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                caelestis.setBackground(Color.BLUE);
            }
        });
        opcoesNaves.add(descricaoCaelestis);
        JEditorPane descricaoProphet = new JEditorPane("text/html", "");
        descricaoProphet.setEditable(false);
        descricaoProphet.setText(Database.getDescricaoProphet());
        descricaoProphet.setBackground(Color.blue);
        descricaoProphet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        descricaoProphet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    escolherNave(nave, 3);
                }
                catch (ImagemNaoEncontradaException imagemNaoEncontradaException){
                    Jogo.interrompeJogo(imagemNaoEncontradaException.getMessage());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                prophet.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                prophet.setBackground(Color.BLUE);
            }
        });
        opcoesNaves.add(descricaoProphet);

        try {
            copendium.setIcon(new ImageIcon(Database.getSpriteEscolhaCopendium()));
            caelestis.setIcon(new ImageIcon(Database.getSpriteEscolhaCaelestis()));
            prophet.setIcon(new ImageIcon(Database.getSpriteEscolhaProphet()));
        }
        catch (Exception exception){
            throw new ImagemNaoEncontradaException("dos ícones de escolha das naves");
        }

        add(opcoesNaves, BorderLayout.CENTER);
        setLocation(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 300);
        setVisible(true);
    }

    private void escolherNave(Nave nave, int naveEscolhida) throws ImagemNaoEncontradaException {
        try {
            //Inicializando a nave inimiga
            Jogo.naveInimiga.setId(Database.getIdCopendium());
            Jogo.naveInimiga.setSpriteNave(Database.getSpriteNaveCopendium());
            Jogo.naveInimiga.setVelocidade(Database.getVelocidadeCopendium());
            Jogo.naveInimiga.setVelocidadeNormal(Database.getVelocidadeCopendium());
            Jogo.naveInimiga.setVelocidadeReparo(Database.getVelocidadeReparoCopendium());
            Jogo.naveInimiga.setVelocidadeTurbo(Database.getVelocidadeTurboCopendium());
            Jogo.naveInimiga.setCooldownDisparo(Database.getCooldownDisparoCopendium());
            Jogo.naveInimiga.setLarguraNave(Database.getLarguraNaveCopendium());
            Jogo.naveInimiga.setAlturaNave(Database.getAlturaNaveCopendium());
            Jogo.naveInimiga.setDistanciaArma1(Database.getDistanciaArma1Copendium());
            Jogo.naveInimiga.setDistanciaArma2(Database.getDistanciaArma2Copendium());
            Jogo.naveInimiga.setAlturaNaveAux(Database.getAlturaNaveAuxCopendium());

            Jogo.naveInimiga.getDisparo().setSprite(Database.getSpriteDisparoCopendium());
            Jogo.naveInimiga.getDisparo().setVelocidade(Database.getVelocidadeDisparoCopendium());
            Jogo.naveInimiga.getDisparo().setLargura(Database.getLarguraDisparoCopendium());
            Jogo.naveInimiga.getDisparo().setComprimento(Database.getComprimentoDisparoCopendium());
            //Fim da inicialização de nave inimiga

            switch (naveEscolhida) {
                case 1:
                    nave.setId(Database.getIdCopendium());
                    nave.setSpriteNave(Database.getSpriteNaveCopendium());
                    nave.setVelocidade(Database.getVelocidadeCopendium());
                    nave.setVelocidadeNormal(Database.getVelocidadeCopendium());
                    nave.setVelocidadeReparo(Database.getVelocidadeReparoCopendium());
                    nave.setVelocidadeTurbo(Database.getVelocidadeTurboCopendium());
                    nave.setCooldownDisparo(Database.getCooldownDisparoCopendium());
                    nave.setLarguraNave(Database.getLarguraNaveCopendium());
                    nave.setAlturaNave(Database.getAlturaNaveCopendium());
                    nave.setDistanciaArma1(Database.getDistanciaArma1Copendium());
                    nave.setDistanciaArma2(Database.getDistanciaArma2Copendium());
                    nave.setAlturaNaveAux(Database.getAlturaNaveAuxCopendium());
                    nave.setPosY(Database.getJanelaInicialAltura() - Database.getAlturaNaveAuxCopendium());

                    nave.getDisparo().setSprite(Database.getSpriteDisparoCopendium());
                    nave.getDisparo().setVelocidade(Database.getVelocidadeDisparoCopendium());
                    nave.getDisparo().setLargura(Database.getLarguraDisparoCopendium());
                    nave.getDisparo().setComprimento(Database.getComprimentoDisparoCopendium());
                    break;

                case 2:
                    nave.setId(Database.getIdCaelestis());
                    nave.setSpriteNave(Database.getSpriteNaveCaelestis());
                    nave.setVelocidade(Database.getVelocidadeCaelestis());
                    nave.setVelocidadeNormal(Database.getVelocidadeCaelestis());
                    nave.setVelocidadeReparo(Database.getVelocidadeReparoCaelestis());
                    nave.setVelocidadeTurbo(Database.getVelocidadeTurboCaelestis());
                    nave.setCooldownDisparo(Database.getCooldownDisparoCaelestis());
                    nave.setLarguraNave(Database.getLarguraNaveCaelestis());
                    nave.setAlturaNave(Database.getAlturaNaveCaelestis());
                    nave.setDistanciaArma1(Database.getDistanciaArma1Caelestis());
                    nave.setAlturaNaveAux(Database.getAlturaNaveAuxCaelestis());
                    nave.setPosY(Database.getJanelaInicialAltura() - Database.getAlturaNaveAuxCaelestis());

                    nave.getDisparo().setSprite(Database.getSpriteDisparoCaelestis());
                    nave.getDisparo().setVelocidade(Database.getVelocidadeDisparoCaelestis());
                    nave.getDisparo().setLargura(Database.getLarguraDisparoCaelestis());
                    nave.getDisparo().setComprimento(Database.getComprimentoDisparoCaelestis());
                    break;

                case 3:
                    nave.setId(Database.getIdProphet());
                    nave.setSpriteNave(Database.getSpriteNaveProphet());
                    nave.setVelocidade(Database.getVelocidadeProphet());
                    nave.setVelocidadeNormal(Database.getVelocidadeProphet());
                    nave.setVelocidadeReparo(Database.getVelocidadeReparoProphet());
                    nave.setVelocidadeTurbo(Database.getVelocidadeTurboProphet());
                    nave.setCooldownDisparo(Database.getCooldownDisparoProphet());
                    nave.setLarguraNave(Database.getLarguraNaveProphet());
                    nave.setAlturaNave(Database.getAlturaNaveProphet());
                    nave.setDistanciaArma1(Database.getDistanciaArma1Prophet());
                    nave.setAlturaNaveAux(Database.getAlturaNaveAuxProphet());
                    nave.setPosY(Database.getJanelaInicialAltura() - Database.getAlturaNaveAuxProphet());

                    nave.getDisparo().setSprite(Database.getSpriteDisparoProphet());
                    nave.getDisparo().setVelocidade(Database.getVelocidadeDisparoProphet());
                    nave.getDisparo().setLargura(Database.getLarguraDisparoProphet());
                    nave.getDisparo().setComprimento(Database.getComprimentoDisparoProphet());
                    break;
            }
            super.dispose();
            Jogo.comecarJogo();
        } catch (Exception exception) {
            super.dispose();
            throw new ImagemNaoEncontradaException("das imagens da nave escolhida");
        }
    }
}

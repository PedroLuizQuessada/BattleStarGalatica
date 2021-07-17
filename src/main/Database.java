package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Database {
    private static final int JANELA_INICIAL_LARGURA = 1000;
    private static final int JANELA_INICIAL_ALTURA = 600;
    private static final int JANELA_MINIMA_LARGURA = 500;
    private static final int JANELA_MINIMA_ALTURA = 400;
    private static final int JANELA_EXCECAO_POSX = 550;
    private static final int JANELA_EXCECAO_POSY = 300;
    private static final int COOLDOWN_PROTECAO = 50;
    private static final int COOLDOWN_REPARO = 100;
    private static final int DURACAO_REPARO = 50;
    private static final int COOLDOWN_TURBO = 70;
    private static final int DURACAO_TURBO = 40;

    private final static String SPRITE_PATH_FUNDO = "src/imagens/telas/fundo.jpg";
    private final static String SPRITE_PATH_VITORIA = "src/imagens/telas/vitoria.jpg";
    private final static String SPRITE_PATH_DERROTA = "src/imagens/telas/derrota.jpg";
    private final static String SPRITE_PATH_VIDA_CHEIA = "src/imagens/icones/vidaCheia.png";
    private final static String SPRITE_PATH_VIDA_VAZIA = "src/imagens/icones/vidaVazia.png";
    private final static String SPRITE_PATH_ARMA = "src/imagens/icones/arma.png";
    private final static String SPRITE_PATH_TURBO = "src/imagens/icones/turbo.png";
    private final static String SPRITE_PATH_REPARO = "src/imagens/icones/reparo.png";
    private final static String SPRITE_PATH_NUM0 = "src/imagens/numeros/0.png";
    private final static String SPRITE_PATH_NUM1 = "src/imagens/numeros/1.png";
    private final static String SPRITE_PATH_NUM2 = "src/imagens/numeros/2.png";
    private final static String SPRITE_PATH_NUM3 = "src/imagens/numeros/3.png";
    private final static String SPRITE_PATH_NUM4 = "src/imagens/numeros/4.png";
    private final static String SPRITE_PATH_NUM5 = "src/imagens/numeros/5.png";
    private final static String SPRITE_PATH_NUM6 = "src/imagens/numeros/6.png";
    private final static String SPRITE_PATH_NUM7 = "src/imagens/numeros/7.png";
    private final static String SPRITE_PATH_NUM8 = "src/imagens/numeros/8.png";
    private final static String SPRITE_PATH_NUM9 = "src/imagens/numeros/9.png";
    
    private final static String SPRITE_PATH_METEORO = "src/imagens/meteoros/meteoro.png";
    private final static int MIN_VELOCIDADE_METEORO = 1;
    private final static int MAX_VELOCIDADE_METEORO = 10;
    private final static int MIN_DIAMETRO_METEORO = 40;
    private final static int MAX_DIAMETRO_METEORO = 70;

    public static final int ID_COPENDIUM = 1;
    private final static String SPRITE_PATH_NAVE_COPENDIUM = "src/imagens/naves/copendium/copendium.png";
    private final static String SPRITE_PATH_ESCOLHA_COPENDIUM = "src/imagens/naves/copendium/escolha.png";
    private final static int VELOCIDADE_COPENDIUM = 10;
    private final static int VELOCIDADE_REPARO_COPENDIUM = 5;
    private final static int VELOCIDADE_TURBO_COPENDIUM = 40;
    private final static int COOLDOWN_DISPARO_COPENDIUM = 40;
    private final static int LARGURA_NAVE_COPENDIUM = 120;
    private final static int ALTURA_NAVE_COPENDIUM = 92;
    private final static int ALTURA_NAVE_AUX_COPENDIUM = 132;
    private final static int DISTANCIA_ARMA_1_COPENDIUM = 19;
    private final static int DISTANCIA_ARMA_2_COPENDIUM = 73;
    private final static String DESCRICAO_COPENDIUM = "<center><b>Copendium</b><br>Seus dois canhões de lasers são capazes de destruir planetas inteiros</center>";
    private final static String SPRITE_PATH_DISPARO_COPENDIUM = "src/imagens/disparos/laser.png";
    private final static int VELOCIDADE_DISPARO_COPENDIUM = 10;
    private final static int LARGURA_DISPARO_COPENDIUM = 17;
    private final static int COMPRIMENTO_DISPARO_COPENDIUM = 22;

    public static final int ID_CAELESTIS = 2;
    private final static String SPRITE_PATH_NAVE_CAELESTIS = "src/imagens/naves/caelestis/caelestis.png";
    private final static String SPRITE_PATH_ESCOLHA_CAELESTIS = "src/imagens/naves/caelestis/escolha.png";
    private final static int VELOCIDADE_CAELESTIS = 15;
    private final static int VELOCIDADE_REPARO_CAELESTIS = 7;
    private final static int VELOCIDADE_TURBO_CAELESTIS = 45;
    private final static int COOLDOWN_DISPARO_CAELESTIS = 40;
    private final static int LARGURA_NAVE_CAELESTIS = 120;
    private final static int ALTURA_NAVE_CAELESTIS = 92;
    private final static int ALTURA_NAVE_AUX_CAELESTIS = 132;
    private final static int DISTANCIA_ARMA_1_CAELESTIS = 43;
    private final static String DESCRICAO_CAELESTIS = "<center><b>Caelestis</b><br>Uma nave com turbinas propulsoras muito poderosas que garantem uma grande agilidade</center>";
    private final static String SPRITE_PATH_DISPARO_CAELESTIS = "src/imagens/disparos/disparoCosmico.png";
    private final static int VELOCIDADE_DISPARO_CAELESTIS = 10;
    private final static int LARGURA_DISPARO_CAELESTIS = 17;
    private final static int COMPRIMENTO_DISPARO_CAELESTIS = 22;

    public static final int ID_PROPHET = 3;
    private final static String SPRITE_PATH_NAVE_PROPHET = "src/imagens/naves/prophet/prophet.png";
    private final static String SPRITE_PATH_ESCOLHA_PROPHET = "src/imagens/naves/prophet/escolha.png";
    private final static int VELOCIDADE_PROPHET = 10;
    private final static int VELOCIDADE_REPARO_PROPHET = 5;
    private final static int VELOCIDADE_TURBO_PROPHET = 40;
    private final static int COOLDOWN_DISPARO_PROPHET = 30;
    private final static int LARGURA_NAVE_PROPHET = 120;
    private final static int ALTURA_NAVE_PROPHET = 92;
    private final static int ALTURA_NAVE_AUX_PROPHET = 132;
    private final static int DISTANCIA_ARMA_1_PROPHET = 43;
    private final static String DESCRICAO_PROPHET = "<center><b>Prophet</b><br>Uma máquina mortal aos inimigos por conta da sua grande velocidade de disparos</center>";
    private final static String SPRITE_PATH_DISPARO_PROPHET = "src/imagens/disparos/lavaGalatica.png";
    private final static int VELOCIDADE_DISPARO_PROPHET = 15;
    private final static int LARGURA_DISPARO_PROPHET = 17;
    private final static int COMPRIMENTO_DISPARO_PROPHET = 22;

    public static int getJanelaInicialLargura() {
        return JANELA_INICIAL_LARGURA;
    }

    public static int getJanelaInicialAltura() {
        return JANELA_INICIAL_ALTURA;
    }

    public static int getJanelaMinimaLargura() {
        return JANELA_MINIMA_LARGURA;
    }

    public static int getJanelaMinimaAltura() {
        return JANELA_MINIMA_ALTURA;
    }

    public static int getJanelaExcecaoPosx() {
        return JANELA_EXCECAO_POSX;
    }

    public static int getJanelaExcecaoPosy() {
        return JANELA_EXCECAO_POSY;
    }

    public static int getCooldownProtecao() {
        return COOLDOWN_PROTECAO;
    }

    public static int getCooldownReparo() {
        return COOLDOWN_REPARO;
    }

    public static int getDuracaoReparo() {
        return DURACAO_REPARO;
    }

    public static int getCooldownTurbo() {
        return COOLDOWN_TURBO;
    }

    public static int getDuracaoTurbo() {
        return DURACAO_TURBO;
    }

    public static Image getSpriteFundo() throws Exception{
        return ImageIO.read(new File(SPRITE_PATH_FUNDO));
    }

    public static Image getSpriteVitoria() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_VITORIA));
    }

    public static Image getSpriteDerrota() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_DERROTA));
    }

    public static Image getSpriteVidaCheia() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_VIDA_CHEIA));
    }

    public static Image getSpriteVidaVazia() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_VIDA_VAZIA));
    }

    public static Image getSpriteArma() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_ARMA));
    }

    public static Image getSpriteTurbo() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_TURBO));
    }

    public static Image getSpriteReparo() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_REPARO));
    }

    public static Image getSpriteNum0() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM0));
    }

    public static Image getSpriteNum1() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM1));
    }

    public static Image getSpriteNum2() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM2));
    }

    public static Image getSpriteNum3() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM3));
    }

    public static Image getSpriteNum4() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM4));
    }

    public static Image getSpriteNum5() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM5));
    }

    public static Image getSpriteNum6() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM6));
    }

    public static Image getSpriteNum7() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM7));
    }

    public static Image getSpriteNum8() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM8));
    }

    public static Image getSpriteNum9() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NUM9));
    }

    public static Image getSpriteMeteoro() throws Exception{
        return ImageIO.read(new File(SPRITE_PATH_METEORO));
    }

    public static int getMinVelocidadeMeteoro() {
        return MIN_VELOCIDADE_METEORO;
    }

    public static int getMaxVelocidadeMeteoro() {
        return MAX_VELOCIDADE_METEORO;
    }

    public static int getMinDiametroMeteoro() {
        return MIN_DIAMETRO_METEORO;
    }

    public static int getMaxDiametroMeteoro() {
        return MAX_DIAMETRO_METEORO;
    }

    public static int getIdCopendium() {
        return ID_COPENDIUM;
    }

    public static Image getSpriteNaveCopendium() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NAVE_COPENDIUM));
    }

    public static Image getSpriteEscolhaCopendium() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_ESCOLHA_COPENDIUM));
    }

    public static Image getSpriteDisparoCopendium() throws Exception{
        return ImageIO.read(new File(SPRITE_PATH_DISPARO_COPENDIUM));
    }

    public static int getVelocidadeCopendium() {
        return VELOCIDADE_COPENDIUM;
    }

    public static int getVelocidadeReparoCopendium() {
        return VELOCIDADE_REPARO_COPENDIUM;
    }

    public static int getVelocidadeTurboCopendium() {
        return VELOCIDADE_TURBO_COPENDIUM;
    }

    public static int getVelocidadeDisparoCopendium() {
        return VELOCIDADE_DISPARO_COPENDIUM;
    }

    public static int getLarguraDisparoCopendium() {
        return LARGURA_DISPARO_COPENDIUM;
    }

    public static int getComprimentoDisparoCopendium() {
        return COMPRIMENTO_DISPARO_COPENDIUM;
    }

    public static int getCooldownDisparoCopendium() {
        return COOLDOWN_DISPARO_COPENDIUM;
    }

    public static int getLarguraNaveCopendium() {
        return LARGURA_NAVE_COPENDIUM;
    }

    public static int getAlturaNaveCopendium() {
        return ALTURA_NAVE_COPENDIUM;
    }

    public static int getDistanciaArma1Copendium() {
        return DISTANCIA_ARMA_1_COPENDIUM;
    }

    public static int getDistanciaArma2Copendium() {
        return DISTANCIA_ARMA_2_COPENDIUM;
    }

    public static int getAlturaNaveAuxCopendium() {
        return ALTURA_NAVE_AUX_COPENDIUM;
    }

    public static String getDescricaoCopendium() {
        return DESCRICAO_COPENDIUM;
    }

    public static int getIdCaelestis() {
        return ID_CAELESTIS;
    }

    public static Image getSpriteNaveCaelestis() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NAVE_CAELESTIS));
    }

    public static Image getSpriteEscolhaCaelestis() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_ESCOLHA_CAELESTIS));
    }

    public static int getVelocidadeCaelestis() {
        return VELOCIDADE_CAELESTIS;
    }

    public static int getVelocidadeReparoCaelestis() {
        return VELOCIDADE_REPARO_CAELESTIS;
    }

    public static int getVelocidadeTurboCaelestis() {
        return VELOCIDADE_TURBO_CAELESTIS;
    }

    public static int getCooldownDisparoCaelestis() {
        return COOLDOWN_DISPARO_CAELESTIS;
    }

    public static int getLarguraNaveCaelestis() {
        return LARGURA_NAVE_CAELESTIS;
    }

    public static int getAlturaNaveCaelestis() {
        return ALTURA_NAVE_CAELESTIS;
    }

    public static int getAlturaNaveAuxCaelestis() {
        return ALTURA_NAVE_AUX_CAELESTIS;
    }

    public static int getDistanciaArma1Caelestis() {
        return DISTANCIA_ARMA_1_CAELESTIS;
    }

    public static String getDescricaoCaelestis() {
        return DESCRICAO_CAELESTIS;
    }

    public static Image getSpriteDisparoCaelestis() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_DISPARO_CAELESTIS));
    }

    public static int getVelocidadeDisparoCaelestis() {
        return VELOCIDADE_DISPARO_CAELESTIS;
    }

    public static int getLarguraDisparoCaelestis() {
        return LARGURA_DISPARO_CAELESTIS;
    }

    public static int getComprimentoDisparoCaelestis() {
        return COMPRIMENTO_DISPARO_CAELESTIS;
    }

    public static int getIdProphet() {
        return ID_PROPHET;
    }

    public static Image getSpriteNaveProphet() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_NAVE_PROPHET));
    }

    public static Image getSpriteEscolhaProphet() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_ESCOLHA_PROPHET));
    }

    public static int getVelocidadeProphet() {
        return VELOCIDADE_PROPHET;
    }

    public static int getVelocidadeReparoProphet() {
        return VELOCIDADE_REPARO_PROPHET;
    }

    public static int getVelocidadeTurboProphet() {
        return VELOCIDADE_TURBO_PROPHET;
    }

    public static int getCooldownDisparoProphet() {
        return COOLDOWN_DISPARO_PROPHET;
    }

    public static int getLarguraNaveProphet() {
        return LARGURA_NAVE_PROPHET;
    }

    public static int getAlturaNaveProphet() {
        return ALTURA_NAVE_PROPHET;
    }

    public static int getAlturaNaveAuxProphet() {
        return ALTURA_NAVE_AUX_PROPHET;
    }

    public static int getDistanciaArma1Prophet() {
        return DISTANCIA_ARMA_1_PROPHET;
    }

    public static String getDescricaoProphet() {
        return DESCRICAO_PROPHET;
    }

    public static Image getSpriteDisparoProphet() throws Exception {
        return ImageIO.read(new File(SPRITE_PATH_DISPARO_PROPHET));
    }

    public static int getVelocidadeDisparoProphet() {
        return VELOCIDADE_DISPARO_PROPHET;
    }

    public static int getLarguraDisparoProphet() {
        return LARGURA_DISPARO_PROPHET;
    }

    public static int getComprimentoDisparoProphet() {
        return COMPRIMENTO_DISPARO_PROPHET;
    }
}

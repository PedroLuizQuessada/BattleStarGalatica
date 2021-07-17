package main;

import javax.swing.*;

public class ExceptionHandler extends JFrame {
    ExceptionHandler(String mensagem){
        JEditorPane mensagemErro = new JEditorPane("text/html", "<center>Falha ao carregar mídia " + mensagem + ".<br>Favor contatar o desenvolvedor.<center>");
        mensagemErro.setEditable(false);
        add(mensagemErro);
        setLocation(Database.getJanelaExcecaoPosx(), Database.getJanelaExcecaoPosy());
        setResizable(false);
        pack();
        setVisible(true);
    }
}

package exceptions;

public class ImagemNaoEncontradaException extends Exception{
    public ImagemNaoEncontradaException(String imagem){
        super(imagem);
    }
}

package exceptions;

public class CttNaoEncontradoException extends RuntimeException{

    public CttNaoEncontradoException() {
        super();
    }

    public CttNaoEncontradoException(String mensagem) {

        super(mensagem);
    }
}

package exceptions;

public class DeletarException extends RuntimeException {

    public DeletarException(){
        super();
    }

    public DeletarException(String msg){
        super(msg);
    }
}

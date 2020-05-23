package exception;

public class BevandaNonValidaException extends Exception {

    private String errorCode="Bevanda Non Valida";

    public BevandaNonValidaException(String message){
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode(){
        return this.errorCode;
    }

}

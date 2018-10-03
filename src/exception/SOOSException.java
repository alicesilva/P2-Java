package exception;

public class SOOSException extends Exception{

	public SOOSException(String mensagem){
		super(mensagem);
	}
	
	public SOOSException(){
		super("Erro no Sistema");
	}
}

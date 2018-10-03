package exception;

public class ErroLoginException extends SOOSException {
	
	public ErroLoginException(){
		super("Nao foi possivel realizar o login.");
	}
	
	public ErroLoginException(String mensagem){
		super("Nao foi possivel realizar o login." + mensagem);
	}
}

package exception;

public class FechaSistemaException extends SOOSException{

	public FechaSistemaException(){
		super("Nao foi possivel fechar o sistema.");
	}
	
	public FechaSistemaException(String mensagem){
		super("Nao foi possivel fechar o sistema."+mensagem);
	}
}

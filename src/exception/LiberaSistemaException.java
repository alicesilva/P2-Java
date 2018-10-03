package exception;

public class LiberaSistemaException extends SOOSException{
	

	public LiberaSistemaException(){
		super("Erro ao liberar o sistema.");
	}
	
	public LiberaSistemaException(String mensagem){
		super("Erro ao liberar o sistema."+mensagem);
	}
	

}

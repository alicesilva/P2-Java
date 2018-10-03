package exception;

public class ConsultarProntuarioException extends SOOSException {
	
	public ConsultarProntuarioException(){
		super("Erro ao consultar prontuario.");
	}
	
	public ConsultarProntuarioException(String mensagem){
		super("Erro ao consultar prontuario." + mensagem);
	}
	
}

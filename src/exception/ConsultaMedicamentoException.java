package exception;

public class ConsultaMedicamentoException extends SOOSException {
	
	public ConsultaMedicamentoException(){
		super("Erro na consulta de medicamentos.");
	}
	
	public ConsultaMedicamentoException(String mensagem){
		super("Erro na consulta de medicamentos." + mensagem);
	}
	

}

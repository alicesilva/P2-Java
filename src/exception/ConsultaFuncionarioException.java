package exception;

public class ConsultaFuncionarioException extends SOOSException{

	public ConsultaFuncionarioException(){
		super("Erro na consulta de funcionario.");
	}
	
	public ConsultaFuncionarioException(String mensagem){
		super("Erro na consulta de funcionario." + mensagem);
	}
}

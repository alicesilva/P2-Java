package exception;

public class CadastroPacienteException extends SOOSException{
	
	public CadastroPacienteException(){
		super("Nao foi possivel cadastrar o paciente.");
	}
	
	public CadastroPacienteException(String mensagem){
		super("Nao foi possivel cadastrar o paciente." + mensagem);
	}
	

}

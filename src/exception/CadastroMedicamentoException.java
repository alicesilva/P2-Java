package exception;

public class CadastroMedicamentoException extends SOOSException{
	
	public CadastroMedicamentoException(){
		super("Erro no cadastro de medicamento.");
	}
	
	public CadastroMedicamentoException(String mensagem){
		super("Erro no cadastro de medicamento." + mensagem);
	}

}

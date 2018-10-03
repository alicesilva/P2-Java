package exception;

public class CadastroFuncionarioException extends SOOSException{
	
	public CadastroFuncionarioException(){
		super("Erro no cadastro de funcionario.");
	}
	
	public CadastroFuncionarioException(String mensagem){
		super("Erro no cadastro de funcionario." + mensagem);
	}

}

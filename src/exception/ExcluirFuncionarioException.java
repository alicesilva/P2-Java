package exception;

public class ExcluirFuncionarioException extends SOOSException{
	

	public ExcluirFuncionarioException(){
		super("Erro ao excluir funcionario.");
	}
	
	public ExcluirFuncionarioException(String mensagem){
		super("Erro ao excluir funcionario."+mensagem);
	}

}

package exception;

public class AtualizaFuncionarioException extends SOOSException {
	
	public AtualizaFuncionarioException(){
		super("Erro ao atualizar funcionario.");
	}
	
	public AtualizaFuncionarioException(String mensagem){
		super("Erro ao atualizar funcionario."+mensagem);
	}

}

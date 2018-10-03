package exception;

public class AtualizaMedicamentoException extends SOOSException {

	public AtualizaMedicamentoException(){
		super("Erro ao atualizar medicamento.");
	}
	
	public AtualizaMedicamentoException(String mensagem){
		super("Erro ao atualizar medicamento." + mensagem);
	}
}

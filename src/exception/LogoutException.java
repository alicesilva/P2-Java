package exception;

public class LogoutException extends SOOSException{
	
	public LogoutException(){
		super("Nao foi possivel realizar o logout.");
	}
	public LogoutException(String mensagem){
		super("Nao foi possivel realizar o logout."+mensagem);
	}

}

package utilexception;

public class ValidaLogin {

	
	public boolean validaMatricula(String matricula){
		char mat[] = matricula.toCharArray();
		
		for (char c : mat) {
			if(Character.isLetter(c)){
				return false;
			}
		}
		return true;
	}
	
	public boolean validaSenha(String senha){
		char mat[] = senha.toCharArray();
		int numeros = 0;
		int letras = 0;
		
		
		for (char c : mat) {
			if(!Character.isLetter(c) && !Character.isDigit(c)){
				return false;
			}
		}

		if(senha.length() < 8 || senha.length() > 12){
			return false;
		}
		return true;
	}
		
}

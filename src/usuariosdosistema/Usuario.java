package usuariosdosistema;

import java.util.HashSet;
import java.util.Set;

public abstract class Usuario {
	
	private String nome;
	private String dataDeNascimento;
	private String matricula;
	private String senha;
	private String cargo;
	protected Set<Funcionalidades> permissao;
	
	public Usuario(String nome, String dataDeNascimento, String matricula, String senha, String cargo){
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.matricula = matricula;
		this.senha = senha;
		this.cargo = cargo;
		this.permissao = new HashSet<Funcionalidades>();

		
	}
	
	
	public String getNome(){
		return this.nome;
	}
	
	public String getDataDeNascimento(){
		return this.dataDeNascimento;
	}
	
	public String getMatricula(){
		return this.matricula;
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	
	public void setSenha(String novaSenha){
		this.senha = novaSenha;
	}
	
	public void setDataDeNascimento(String novaDataDeNascimento){
		this.dataDeNascimento = novaDataDeNascimento;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Usuario){
			Usuario novoUsuario = (Usuario)obj;
			if(this.matricula.equals(novoUsuario.getMatricula()) & this.senha.equals(novoUsuario.getSenha())){
				return true;
			}
		}
		
		return false;
		
	}
	
	public abstract void addPermissao();
	
	public Set<Funcionalidades> getPermissao(){
		return this.permissao;
	}
	

}

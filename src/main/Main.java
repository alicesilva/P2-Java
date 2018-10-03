package main;

import easyaccept.EasyAccept;
import usuariosdosistema.DiretorGeral;

public class Main {
	
	public static void main(String[] args)  {

		args = new String[] {"controller.HospitalController", "testes/usecase_1.txt", "testes/usecase_2.txt",
				"testes/usecase_3.txt"};
	    EasyAccept.main(args);
	}

}

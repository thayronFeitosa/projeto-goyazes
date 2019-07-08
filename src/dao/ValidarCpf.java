package dao;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;

public class ValidarCpf implements IValidar {

	/**
	 * metodo isCalid e resposanvel pela validação do Cpf
	 */
	
	
	@Override
	public boolean isValid(Cliente obj) {
		int valor = obj.getCpf().length();
		String cpf =  obj.getCpf();
		int verifica =0;
	
		if (valor < 11 || valor > 11) {
			Alert alert = new Alert(AlertType.ERROR, "Verifique o CPF e tente novamente.");
			alert.setTitle("Erro. no PCF");
			alert.setHeaderText("Quantidade de numeros insuficientes para o cadastro do  CPF");
			alert.show();
			return true;
		}
		
		for (int i = 0; i < 11; i++) {
			if(cpf.charAt(i)=='0' || cpf.charAt(i)=='1' || cpf.charAt(i)=='2' || cpf.charAt(i)=='3' || cpf.charAt(i)=='4' || cpf.charAt(i)=='5' || cpf.charAt(i)=='6' || cpf.charAt(i)=='7' || cpf.charAt(i)=='8' || cpf.charAt(i)=='9' ) {
				verifica++;
			}
			}if(verifica<11){
			Alert alert = new Alert(AlertType.ERROR, "Verifique o CPF e tente novamente.");
			alert.setTitle("Erro. no PCF");
			alert.setHeaderText("O CPF só pode conter Numeros");
			alert.show();
			return true;
		}
		

		return false;

	}

	/**
	 * valida se algum dos campos da tela de cadastro é nulas. caso seja não deixa
	 * inserir no banco de dados
	 */
	@Override
	public boolean isEmpty(Cliente obj) {
		if (obj.getNome().equals("") || obj.getSobreNome().equals("") || obj.getCpf().equals("")
				|| obj.getSexo().equals("")) {

			Alert alert = new Alert(AlertType.ERROR, "Tende novamente.");
			alert.setTitle("Erro. cadastro null");
			alert.setHeaderText("Todos os campos devem ser preenchidos");

			alert.show();
			return true;
		}
		return false;
	}

}

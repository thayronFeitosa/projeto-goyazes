package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ValidarCpf implements IValidar {

	/**
	 * metodo verifica se os a quantidade de numeros do CPF maior ou menor que 11 e
	 * retorna true, caso contrario retorna false
	 */
	public boolean numeroInfuciciente(Cliente obj) {
		int valor = obj.getCpf().length();
		if (valor < 11 || valor > 11) {
			return true;
		}
		return false;
	}

	/**
	 * m�todo verifica se todos os numeros s�o numeros.
	 * 
	 * @return true caso encontra alguma letra
	 */
	public boolean somenteNumeros(Cliente obj) {
		numeroInfuciciente(obj);
		
		String cpf = obj.getCpf();
		int verifica = 0;
		for (int i = 0; i < 11; i++) {

			if (cpf.charAt(i) == '0' || cpf.charAt(i) == '1' || cpf.charAt(i) == '2' || cpf.charAt(i) == '3'
					|| cpf.charAt(i) == '4' || cpf.charAt(i) == '5' || cpf.charAt(i) == '6' || cpf.charAt(i) == '7'
					|| cpf.charAt(i) == '8' || cpf.charAt(i) == '9') {
				verifica++;
			}
		}
		if (verifica < 11) {
			return true;
		}
		return false;
	}

	/**
	 * m�todo isValida usa todos os m�todos da classe ValidaCpf trazendo mais seguran�a para a valida��o. 
	 */
	@Override
	public boolean isValid(Cliente obj) {
		if (isEmpty(obj) == true) {
			return true;
		}

		if (numeroInfuciciente(obj) == true) {
			Alert alert = new Alert(AlertType.ERROR, "verifique o CPF e tente novamamente.");
			alert.setTitle("Erro. No CPF");
			alert.setHeaderText("O CPF deve conter 11 digitos");

			alert.show();
			return true;
		}

		if (somenteNumeros(obj) == true) {
			Alert alert = new Alert(AlertType.ERROR, "verifique o CPF e tente novamamente.");
			alert.setTitle("Erro. No CPF");
			alert.setHeaderText("O CPF n�o pode conter letras");
			alert.show();
			return true;
		}

		return false;

	}

	/**
	 * valida se algum dos campos da tela de cadastro � nulas. caso seja n�o deixa
	 * inserir no banco de dados
	 */
	@Override
	public boolean isEmpty(Cliente obj) {
		if (obj.getNome().equals("")) {
			AlertBox.campoObrigatorio("Nome");
			return true;
		}
		if (obj.getSobreNome().equals("")) {
			AlertBox.campoObrigatorio("Sobre Nome");
			return true;
		}if (obj.getEmail().equals("")) {
			AlertBox.campoObrigatorio("Email");
			return true;
		}if (obj.getCpf().equals("")) {
			AlertBox.campoObrigatorio("CPF");
			return true;
		}
		return false;
	}

}

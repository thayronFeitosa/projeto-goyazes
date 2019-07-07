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
		String valorCpf = obj.getCpf();
		int numeroConvertido = Integer.parseInt(valorCpf);
		if (valor < 11 || valor > 11) {
			Alert alert = new Alert(AlertType.ERROR, "Verifique o CPF e tente novamente.");
			alert.setTitle("Erro. no PCF");
			alert.setHeaderText("Quantidade de numeros insuficientes para o cadastro do  CPF");
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

package dao;

import java.util.InputMismatchException;

import javafx.scene.control.Alert;
import model.Cliente;
import javafx.scene.control.Alert.AlertType;

public class ValidarCpf implements IValidar {
	
	
	 public boolean isCPF(Cliente obj) {
		 String CPF = obj.getCpf();
	        // considera-se erro CPF's formados por uma sequencia de numeros iguais
	        if (CPF.equals("00000000000") ||
	            CPF.equals("11111111111") ||
	            CPF.equals("22222222222") || CPF.equals("33333333333") ||
	            CPF.equals("44444444444") || CPF.equals("55555555555") ||
	            CPF.equals("66666666666") || CPF.equals("77777777777") ||
	            CPF.equals("88888888888") || CPF.equals("99999999999") ||
	            (CPF.length() != 11))
	            return(false);
	          
	        char dig10, dig11;
	        int sm, i, r, num, peso;
	          
	        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	        try { 
	        // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {              
	        // converte o i-esimo caractere do CPF em um numero:
	        // por exemplo, transforma o caractere '0' no inteiro 0         
	        // (48 eh a posicao de '0' na tabela ASCII)         
	            num = (int)(CPF.charAt(i) - 48); 
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }
	          
	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
	          
	        // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }
	          
	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);
	          
	        // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }
	 
	 
	 
	          
	        public static String imprimeCPF(String CPF) {
	            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
	            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	        }
	
	
	
	
	
	

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

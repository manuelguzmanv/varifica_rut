package ipchile;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> listaInicial = new ArrayList<String>();

		for (int i = 0; i < (Archivo.leer()).size(); i++) {

			listaInicial.add(Archivo.leer().get(i));

		}

		Rut.validarRut(listaInicial);

	}

}
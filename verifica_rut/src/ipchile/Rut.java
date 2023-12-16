package ipchile;

import java.util.ArrayList;

public class Rut {

	public static void validarRut(ArrayList<String> lista) {

		ArrayList<String> rutsValidos = new ArrayList<String>();
		ArrayList<String> rutsNoValidos = new ArrayList<String>();

		for (int i = 0; i < lista.size(); i++) {

			String[] parts = Archivo.leer().get(i).split("-");
			String rutNumero = parts[0];
			String rutVerificador = parts[1];

			int cantidadNumeros = rutNumero.length();

			int numeros[] = new int[cantidadNumeros];

			for (int j = 0; j < cantidadNumeros; j++) {
				numeros[j] = Integer.parseInt(rutNumero.substring(j, j + 1));
			}

			int factor = 2;
			for (int k = numeros.length - 1; k >= 0; k--) {

				numeros[k] = numeros[k] * factor;

				factor++;

				if (factor > 7) {
					factor = 2;
				}
			}

			Integer sumatoria = 0;

			for (int l = 0; l < numeros.length; l++) {
				sumatoria = sumatoria + numeros[l];
			}

			int resto = sumatoria % 11;

			String verificador = String.valueOf(11 - resto);

			if (verificador.equals("10")) {
				verificador = "k";
			}

			if (verificador.equals("11")) {
				verificador = "0";
			}

			if (verificador.equals(rutVerificador.toLowerCase())) {
				rutsValidos.add(rutNumero + "-" + rutVerificador);

			} else {

				rutsNoValidos.add(rutNumero + "-" + rutVerificador);

			}

		}

		Archivo.crearArchivo("rut_validos");
		Archivo.crearArchivo("rut_no_validos");

		Archivo.escribirArchivo(rutsValidos, "src/archivos/rut_validos.txt");
		Archivo.escribirArchivo(rutsNoValidos, "src/archivos/rut_no_validos.txt");

	}

}

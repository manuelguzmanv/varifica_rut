package ipchile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

	
	
	
	public static ArrayList<String> leer() {

		ArrayList<String> ruts = new ArrayList<String>();

		File archivo = new File("src/archivos/lista_inicial.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String line;
			while ((line = br.readLine()) != null) {
				ruts.add(line);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		ruts.sort((o1, o2) -> o1.compareTo(o2));

		return ruts;

	}

	
	public static void crearArchivo(String fichero) {

		File archivo = new File("src/archivos/" + fichero + ".txt");

		try {
			archivo.createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public static void escribirArchivo(ArrayList<String> listado, String rutaArchivo) {

		File file = new File(rutaArchivo);

		try {

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (String stn : listado) {
				bw.write(stn + "\n");
			}

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

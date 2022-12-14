package ejercicioDatoscsv;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class main {
	public static final String rutaCarpeta = "C:\\Users\\dduran\\Downloads\\csvs\\";
	
	public static void inscribirUsuario(Usuario usr) {
		try {
			FileWriter datosA = new FileWriter(rutaCarpeta + "datosA.csv",true);
			FileWriter datosB = new FileWriter(rutaCarpeta + "datosB.csv",true);

            datosA.append(usr.getEmail() + "," 
            			+ usr.getPwd() + "," 
            			+ usr.getUsername()+ "," 
            			+ usr.getPhone()+'\n');
            datosA.flush();
            datosA.close();

            datosB.append(usr.getCpostal() + "," 
            			+ usr.getDni() + "," 
            			+ usr.getPhone() + '\n');
            datosB.flush();
            datosB.close();
        } 
		catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static archivoCSV mergeCSVs(String rutaA, String rutaB, String rutaNewFile, Integer nUsuarios) throws IOException {
		FileWriter fw = new FileWriter(rutaNewFile);
		File fA = new File(rutaA);
		File fB = new File(rutaB);
		Scanner scA = new Scanner(fA);
		Scanner scB = new Scanner(fB);
		
		String encabezadoA = scA.nextLine();
		String encabezadoB = scB.nextLine();
		String nuevoEncabezado = encabezadoA.replaceAll("number","") + encabezadoB;
		
		fw.append(nuevoEncabezado + "\n");
		
		String linea = "";
		
		for(int i = 0; i < nUsuarios; i++) {
			
			String[] datosA = scA.nextLine().split(",");
			String[] datosB = scB.nextLine().split(",");
			Usuario usr = new Usuario(datosA, datosB);
			
			linea = usr.toCSVLine();
			fw.append(linea);
			
		}
		
		scA.close();
		scB.close();
		fw.close();
		
		return new archivoCSV(rutaNewFile);
	}
	
	public static void inscribirUsuarios(String rutaRaw) throws FileNotFoundException {
		
		File f = new File(rutaRaw);
		Scanner sc = new Scanner(f);
		String encabezado = sc.nextLine();
		while (sc.hasNextLine()) {
			Usuario usr = new Usuario(sc.nextLine().split(","));
			inscribirUsuario(usr);
		}
	}
	
	public static void main(String[] args) throws IOException {
		String rutaRaw = rutaCarpeta + "userDataraw.csv";
		String rutaDatosA = rutaCarpeta + "datosA.csv";
		String rutaDatosB = rutaCarpeta + "datosB.csv";
		String rutaCamposOrdenadosA = rutaCarpeta + "newDatosA.csv";
		String rutaCamposOrdenadosB = rutaCarpeta + "newDatosB.csv";
		String rutaFilasOrdenadasA = rutaCarpeta + "ordenadosA.csv";
		String rutaFilasOrdenadasB = rutaCarpeta + "ordenadosB.csv";
		String rutaSinDuplicadosA = rutaCarpeta + "sinDuplicadosA.csv";
		String rutaSinDuplicadosB = rutaCarpeta + "sinDuplicadosB.csv";
		String rutaMerged = rutaCarpeta + "merged.csv";
		String rutaOrdenDNI = rutaCarpeta + "ordenadoDNI.csv";
		
		//inscribirUsuarios(rutaRaw); USAR SOLO PARA PASAR DEL 1er CSV A LOS CSV datosA y datosB
		
		archivoCSV archA = new archivoCSV(rutaDatosA);
		archivoCSV archB = new archivoCSV(rutaDatosB);
		
		archivoCSV newArchA = archA.ordenarCamposCsvA(rutaDatosA, rutaCamposOrdenadosA);
		archivoCSV newArchB = archB.ordenarCamposCsvB(rutaDatosB, rutaCamposOrdenadosB);	
		
		archivoCSV ordenA = newArchA.ordenarFilasCsv(rutaFilasOrdenadasA, 3);
		archivoCSV ordenB = newArchB.ordenarFilasCsv(rutaFilasOrdenadasB, 2);// campo = 0,1,2...

		archivoCSV listoA = ordenA.eliminarFilasRepetidas(rutaSinDuplicadosA);
		archivoCSV listoB = ordenB.eliminarFilasRepetidas(rutaSinDuplicadosB);

		System.out.println(listoA.getnLines() + " usuarios registrados.");
		
		archivoCSV merged = mergeCSVs(rutaSinDuplicadosA, rutaSinDuplicadosB, rutaMerged, listoA.getnLines());
		
		archivoCSV ordenadoDNI = merged.ordenarFilasCsv(rutaOrdenDNI, 4);
		
		ordenadoDNI.imprimirCsv();
		
	}
}

package ejercicioDatoscsv;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class archivoCSV {
	private String ruta;
	private String encabezado;
	private List <String> campos;
	private Scanner sc;
	private File f;
	 
	public archivoCSV(String ruta) throws FileNotFoundException {
		this.ruta = ruta;
		this.f = new File(ruta);
		this.sc = new Scanner(f);
		this.encabezado = sc.nextLine();
		this.campos = new ArrayList<>(Arrays.asList(encabezado.split(",")));	
	}
	public String getRuta() {
		return ruta;
	}
	public String getEncabezado() {
		return encabezado;
	}
	public List<String> getCampos() {
		return campos;
	}
	
	public Integer getnLines() throws FileNotFoundException {
		sc = new Scanner(f);
		encabezado = sc.nextLine();
		Integer n = 0;
		while(sc.hasNextLine()) {
			n += 1;
			sc.nextLine();
		}
		return n;
	}
	public void imprimirCsv() throws FileNotFoundException {
		sc = new Scanner(f);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
	
	public archivoCSV ordenarCamposCsvA(String rutaA, String rutaNewA) throws IOException {
		File fileA = new File(rutaA);
		FileWriter datosA = new FileWriter(rutaNewA);
		Scanner scA = new Scanner(fileA);
		encabezado = scA.nextLine();
		datosA.append(encabezado.replaceAll(",repetido","\n"));
		
		String lineaA;
		String lineaAOrdenada;
		DatosA a = new DatosA();
		
		while (scA.hasNextLine()) {

			lineaA = scA.nextLine();
			lineaAOrdenada = a.ordenarCampos(lineaA);
			datosA.append(lineaAOrdenada + "\n");
			
		}
		datosA.close();
		scA.close();		
		return new archivoCSV(rutaNewA);
	}
	
	public archivoCSV ordenarCamposCsvB(String rutaB, String rutaNewB) throws IOException {
		File fileB = new File(rutaB);
		FileWriter datosB = new FileWriter(rutaNewB);
		Scanner scB = new Scanner(fileB);
		encabezado = scB.nextLine();
		datosB.append(encabezado.replaceAll(",repetido","\n"));
		
		String lineaB;
		String lineaBOrdenada;
		DatosB b = new DatosB();
		
		while (scB.hasNextLine()) {

			lineaB = scB.nextLine();
			lineaBOrdenada = b.ordenarCampos(lineaB);
			datosB.append(lineaBOrdenada + "\n");
			
		}
		
		scB.close();
		datosB.close();
		
		return new archivoCSV(rutaNewB);
	}
	
	public archivoCSV ordenarFilasCsv(String rutaNewFile, Integer campo) throws IOException{
		sc = new Scanner(f);
		encabezado = sc.nextLine();
		
		FileWriter fw = new FileWriter(rutaNewFile);
		fw.append(encabezado + "\n");
		String linea = "";
		String[] campos;
        ArrayList <String[]> lineas = new ArrayList <String[]>();
        
        while (sc.hasNextLine()) {
        	linea = sc.nextLine();
        	campos = linea.split(",");
        	lineas.add(campos);
        }
        
        lineas.sort((String[] a, String[] b) -> a[campo].compareTo(b[campo]));
		
        for(String[] i : lineas){
        	fw.append(String.join(",", i) + "\n");
        }
        
		sc.close();
		fw.close();

		return new archivoCSV(rutaNewFile);
	}
	
	public archivoCSV eliminarFilasRepetidas(String rutaNewFile) throws IOException {
		sc = new Scanner(f);
		encabezado = sc.nextLine();
		
		FileWriter fw = new FileWriter(rutaNewFile);
		fw.append(encabezado + "\n");
		String lineaanterior = sc.nextLine();
		fw.append(lineaanterior + "\n");
		
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			if(!linea.equals(lineaanterior)) {
				
				fw.append(linea + "\n");
				lineaanterior = linea;
			}
			else {
				System.out.println("Línea duplicada eliminada: \n" + linea);
			}
		}
		
		sc.close();
		fw.close();
		
		return new archivoCSV(rutaNewFile);
		
	}
	
	
}


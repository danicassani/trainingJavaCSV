package ejercicioDatoscsv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosB {


	private String cpostal;
	private String dni;
	private String phone;
	
	public DatosB() {
	}
	public String ordenarCampos(String linea) {
		List <String> data = new ArrayList<String>(Arrays.asList(linea.split(",")));
		List <String> dataOrden = new ArrayList<String>();
		
		Validador v = new Validador();
		for (String i : data) {
			if 		(v.validarCPostal(i)) 		this.cpostal = i;
			else if (v.validarDNI(i)) 			this.dni = i;
			else if (v.validarTelefono(i)) 		this.phone = i;
		}
		
		dataOrden.add(this.cpostal);
		dataOrden.add(this.dni);
		dataOrden.add(this.phone);
		
		String lineaOrdenada = String.join(",",dataOrden);
		return lineaOrdenada;
		
	}
}

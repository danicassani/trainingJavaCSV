package ejercicioDatoscsv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosA {
	private String email;
	private String pwd;
	private String username;
	private String phone;
	
	public DatosA() {
	}
	
	public String ordenarCampos(String linea) {
		List <String> data = new ArrayList<String>(Arrays.asList(linea.split(",")));
		List <String> dataOrden = new ArrayList<String>();
		
		Validador v = new Validador();
		for (String i : data) {
			i = i.replaceAll("[&-]", "");
			if 		(v.validarEmail(i)) 		this.email = i;
			else if (v.validarPwd(i)) 			this.pwd = i;
			else if (v.validarUsername(i)) 	this.username = i;
			else if (v.validarTelefono(i)) 		this.phone = i;
		}
		dataOrden.add(this.email);
		dataOrden.add(this.pwd);
		dataOrden.add(this.username);
		dataOrden.add(this.phone);
		
		String lineaOrdenada = String.join(",",dataOrden);
		return lineaOrdenada;
		
	}	
}

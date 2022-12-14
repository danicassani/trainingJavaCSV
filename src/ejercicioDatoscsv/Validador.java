package ejercicioDatoscsv;

public class Validador {
	public boolean validarUsername(String username) {	
		return username.matches("^[a-zA-Z0-9]{2,6}");
	}
	public boolean validarTelefono(String telefono)	{
	return telefono.matches("^\\d{9}"); //he tenido que quitar el &
	}
	public boolean validarCPostal(String cpostal)	{
	return cpostal.matches("^\\d{5}"); //he tenido que quitar el &
	}
	public boolean validarEmail(String email) {
		return email.matches("^[A-Za-z0-9._\\-]+@[A-Za-z\\-_.]+\\.[A-Za-z]{2,3}$");
	}
	public boolean validarPwd(String password) {
		return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,12}$");//
	}
	public boolean validarDNI(String DNI) {
		return DNI.matches("^\\d{8}[A-Z]{1}$");//
	}
}

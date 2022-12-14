package ejercicioDatoscsv;

public class Usuario {
	private String email;
	private String pwd;
	private String username;
	private String phone;
	private String cpostal;
	private String dni;

	public Usuario(String[] dataA ,String[] dataB) {
		this.email = dataA[0];
		this.pwd = dataA[1];
		this.username = dataA[2];
		this.phone = dataA[3];
		this.cpostal = dataB[0];
		this.dni = dataB[1];
	}
	public Usuario(String[] data) {
		this.email = data[0];
		this.pwd = data[1];
		this.username = data[2];
		this.phone = data[3];
		this.cpostal = data[4];
		this.dni = data[5];
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCpostal() {
		return cpostal;
	}
	public void setCpostal(String cpostal) {
		this.cpostal = cpostal;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String datosA() {
		return this.email + "," + 
				this.pwd +"," + 
				this.username + "," + 
				this.phone;
	}
	public String datosB() {
		return this.cpostal + "," + 
				this.dni + "," + 
				this.phone;
	}
	public String toCSVLine() {
		return 	this.email + "," + 
				this.pwd +"," + 
				this.username + "," + 
				this.cpostal + "," + 
				this.dni + ","+
				this.phone + "\n";//
	}
	
}

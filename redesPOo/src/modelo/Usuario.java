package modelo;

/**
 * Clase que representa un usuario de la red social.
 * 
 * @author Sofía Pacheco, Aldana De Sampigny y Macarena Repetto
 *
 */
public class Usuario {

	private String id;
	private String nombre;
	private int edad;
	private String genero;
	private String ciudad;
	private String nivelAcademico; 
	
	public Usuario(String id, String nombre, int edad, String genero, String ciudad, String nivelAcademico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.nivelAcademico = nivelAcademico;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}


	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}


	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}


	public int getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public String getCiudad() {
		return ciudad;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", ciudad="
				+ ciudad + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		
}

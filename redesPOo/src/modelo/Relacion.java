package modelo;

/**
 * Clase que representa la relacion entre 2 usuarios.
 * 
 * @author Maca Repetto
 *
 */
public class Relacion {
	private Usuario usuario1;
	private Usuario usuario2;
	private int tiempoAmistad;
	private int cantLikes;
	private int interaccDiaria;
	
	public Relacion(Usuario usuario1, Usuario usuario2, int tiempoAmistad, int cantLikes, int interaccDiaria) {
		super();
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.tiempoAmistad = tiempoAmistad;
		this.cantLikes = cantLikes;
		this.interaccDiaria = interaccDiaria;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public int getTiempoAmistad() {
		return tiempoAmistad;
	}

	public void setTiempoAmistad(int tiempoAmistad) {
		this.tiempoAmistad = tiempoAmistad;
	}

	public int getCantLikes() {
		return cantLikes;
	}

	public void setCantLikes(int cantLikes) {
		this.cantLikes = cantLikes;
	}

	public int getInteraccDiaria() {
		return interaccDiaria;
	}

	public void setInteraccDiaria(int interaccDiaria) {
		this.interaccDiaria = interaccDiaria;
	}

	@Override
	public String toString() {
		return "Relaciones [usuario1=" + usuario1 + ", usuario2=" + usuario2 + ", tiempoAmistad=" + tiempoAmistad
				+ ", cantLikes=" + cantLikes + ", interaccDiaria=" + interaccDiaria + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relacion other = (Relacion) obj;
		if ((usuario1 != null) && (usuario2 != null)) {
			if (usuario1.equals(other.usuario1) && usuario2.equals(other.usuario2))
				return true;
			if (usuario1.equals(other.usuario2) && usuario2.equals(other.usuario1))
				return true;
		}
		return false;
	}
	
	
		

}

package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

import datos.CargaDatos;
import datos.CargaParametros;
import modelo.Modelo;
import modelo.Relacion;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import vista.PantallaIniciarSesion;
import vista.PantallaPrincipal;

/**
 * Clase principal, la que se encarga de manejar la interaccion con las demas.
 * 
 * @author Maca Repetto
 *
 */
public class Controlador {
	private PantallaIniciarSesion pantalla2;
	private PantallaPrincipal pantalla1;
	private Modelo modelo;

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setPantallaPrincipal(PantallaPrincipal vista) {
		this.pantalla1 = vista;
	}

	public void setPantallaIniciarSesion(PantallaIniciarSesion vista) {
		this.pantalla2 = vista;
	}

	public PantallaIniciarSesion getPantalla() {
		return pantalla2;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void cargarParametros() {
		// Cargar parametros
		try {
			CargaParametros.parametros();
		} catch (IOException e) {
			System.err.print("Error al cargar parámetros");
			System.exit(-1);
		}
	}

	public void cargarDatos() {
		// Cargar datos desde los archivos
		Map<String, Usuario> usuarios = null;
		List<Relacion> relaciones = null;

		try {
			usuarios = CargaDatos.cargarUsuarios(CargaParametros.getArchUsuarios());
			relaciones = CargaDatos.cargarRelaciones(CargaParametros.getArchRelaciones(), usuarios);

		} catch (FileNotFoundException e) {
			System.err.print("Error al cargar archivos de datos");
			System.exit(-1);
		}

		// Crea una red y muestra llama a mostrar la ventana principal.
		modelo = new Modelo(usuarios, relaciones);
	}

	public void iniciarVista() throws IOException {
		pantalla1.setSize(450, 200);
		pantalla1.setVisible(true);
		pantalla1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void gradoPromedio() {
		double promedio = modelo.calcularPromedio();
		pantalla2.mostrarPromedio(promedio);

	}

	public void calcularDensidad() {
		TreeMap<Integer, Usuario> densos = modelo.usuariosMasDensos();
		pantalla2.mostrarDensidad(densos.entrySet());
	}

	public void centralidad() {
		Map<Integer, List<Usuario>> centralidad = modelo.calcularCentralidad();
		pantalla2.mostrarCentralidad(centralidad);
	}

	public void usuarios() {
		List<Usuario> usuarios = modelo.getUsuarios();
		pantalla2.mostrarUsuarios(usuarios);
	}
	
	public void buscarUsuarioSugerencia(String nombreUsuario) {
		Usuario usuV = modelo.buscarVerticeUsuario2(nombreUsuario).getElement();
		List<Usuario> amigos = modelo.getAmigos(usuV);
		List<Usuario> usuarios= modelo.sugerencias(usuV);
		pantalla2.mostrarSugerencias(amigos, usuarios, usuV);
	}
	
	public void buscarUsuarioAntiguedad(ArrayList<String> usuarios) {
		Usuario usuario1 = modelo.buscarVerticeUsuario2(usuarios.get(0)).getElement();
		Usuario usuario2 = modelo.buscarVerticeUsuario2(usuarios.get(1)).getElement();
		List<Usuario> camino = modelo.calcularAntiguedad(usuario1, usuario2);
		pantalla2.mostrarAntiguedad(camino);
	}

	public void buscarAmigos(String usuario) {
		Usuario usuarioAmistad= modelo.buscarVerticeUsuario2(usuario).getElement();
		TreeMap<Integer, Usuario> amigos= modelo.tiempoAmistadYCantAmigos(usuarioAmistad);
		pantalla2.mostrarAmigos(amigos.entrySet());
	}
}

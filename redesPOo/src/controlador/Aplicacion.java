package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import datos.CargaDatos;
import datos.CargaParametros;
import modelo.Modelo;
import modelo.Relacion;
import modelo.Usuario;
import java.util.List;
import vista.PantallaIniciarSesion;
import vista.PantallaPrincipal;

/**
 * Clase principal, la que se encarga de manejar la interaccion con las demas.
 * 
 * @author Maca Repetto
 *
 */
public class Aplicacion {
	// lógica
	private Modelo modelo;
	// vista
	private PantallaIniciarSesion pantalla2;
	private PantallaPrincipal pantalla1;

	// controlador
	private Controlador controlador;

	public static void main(String[] args) throws IOException {
		Aplicacion miAplicacion = new Aplicacion();
		miAplicacion.iniciar();
	}

	public void iniciar() throws IOException {

		// Cargar parametros
		try {
			CargaParametros.parametros();
		} catch (IOException e) {
			System.err.print("Error al cargar parámetros");
			System.exit(-1);
		}

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

		this.modelo = new Modelo(usuarios, relaciones);
		this.pantalla1 = new PantallaPrincipal();
		this.pantalla2 = new PantallaIniciarSesion();
		this.pantalla1.setPantallaInicioSesion(pantalla2);
		this.controlador = new Controlador();
		pantalla1.setControlador(controlador);
		pantalla2.setControlador(controlador);
		modelo.setControlador(controlador);

		controlador.setModelo(modelo);
		controlador.setPantallaPrincipal(pantalla1);
		controlador.setPantallaIniciarSesion(pantalla2);

		controlador.iniciarVista();
	}
}

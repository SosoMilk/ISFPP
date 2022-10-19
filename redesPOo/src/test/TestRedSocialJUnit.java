package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import controlador.Controlador;
import datos.CargaDatos;
import datos.CargaParametros;
import junit.framework.TestCase;
import modelo.Modelo;
import modelo.Relacion;
import modelo.Usuario;
import java.util.List;

public class TestRedSocialJUnit extends TestCase {
	private Modelo modelo;
	private Controlador controlador;
	private TreeMap<Integer, String> mapaDensidad;
	private TreeMap<Integer, String> mapaCentralidad;
	private List<Usuario> usuariosSugerencias;
	private List<Usuario> usuariosAntiguedad;
	private Usuario usuario1;
	private Usuario usuario2;
	private TreeMap<Integer, String> amigosUsuario;

	protected void setUp() throws IOException {
		try {
			CargaParametros.parametros();
		} catch (IOException e) {
			System.err.print("Error al cargar parámetros");
			System.exit(-1);
		}

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
		// sugerencias
		usuario1 = new Usuario("B9872", "Marta Paredes", 21, "F", "Puerto Madryn", "Universitaria");
		usuariosSugerencias = new ArrayList<Usuario>();
		usuariosSugerencias.add(usuarios.get("R2908"));

		// antiguedad
		usuario2 = new Usuario("X4100", "Johanna Bechtelar", 43, "F", "North Mathildeberg", "Doctorado");
		usuariosAntiguedad = new ArrayList<Usuario>();

		usuariosAntiguedad.add(usuario1);
		usuariosAntiguedad.add(usuario2);

		// densidad
		mapaDensidad = new TreeMap<Integer, String>();
		mapaDensidad.put(118, "Johanna Bechtelar");
		mapaDensidad.put(95, "Kara Corwin");
		mapaDensidad.put(58, "Marta Paredes");
		mapaDensidad.put(57, "Loana Aguirre");
		mapaDensidad.put(42, "Tomas Effertz");
		mapaDensidad.put(10, "Cristian Alvarez");

		// tiempo de amisatad y amigos
		amigosUsuario = new TreeMap<Integer, String>();
		amigosUsuario.put(47, "Johanna Bechtelar");
		amigosUsuario.put(55, "Kara Corwin");

		// centralidad
		mapaCentralidad = new TreeMap<Integer, String>();
		mapaCentralidad.put(4, "Tomas Effertz");
		mapaCentralidad.put(4, "Johanna Bechtelar");
		mapaCentralidad.put(3, "Kara Corwin");
		mapaCentralidad.put(2, "Marta Paredes");
		mapaCentralidad.put(2, "Loana Aguirre");
		mapaCentralidad.put(1, "Cristian Alvarez");
	}

	public void testPromedio() {
		assertEquals(2.0, modelo.calcularPromedio());
	}

	public void testCentralidad() {
		Map<Integer, List<Usuario>> centralidad = modelo.calcularCentralidad();
		for (Entry<Integer, List<Usuario>> usuario : centralidad.entrySet()) {
			assertTrue(mapaCentralidad.containsKey(usuario.getKey()));
		}
		
		for (Entry<Integer, String> usuario : mapaCentralidad.entrySet()) {
			assertTrue(centralidad.containsKey(usuario.getKey()));
		}
		/*
		 * assertTrue(centralidad.containsValue(mapaCentralidad));
		 * assertTrue(centralidad.containsValue(mapaCentralidad));
		 * assertTrue(centralidad.equals(mapaCentralidad));
		 * assertTrue(mapaCentralidad.equals(centralidad));
		 */
	}

	public void testSugerencia() {
		List<Usuario> sugerencias = modelo.sugerencias(usuario1);
		assertTrue(sugerencias.containsAll(usuariosSugerencias));
		assertTrue(usuariosSugerencias.containsAll(sugerencias));
	}

	public void testUsuariosMasDensos() {
		TreeMap<Integer, Usuario> usuariosMasDensos = modelo.usuariosMasDensos();
		for (Entry<Integer, Usuario> usuario : usuariosMasDensos.entrySet()) {
			assertTrue(mapaDensidad.containsValue(usuario.getValue().getNombre()));
		}
		for (Entry<Integer, String> usuario : mapaDensidad.entrySet()) {
			assertTrue(usuariosMasDensos.containsKey(usuario.getKey()));
		}
	}

	public void testAntiguedad() {
		Usuario usu1 = modelo.buscarVerticeUsuario2(usuario1.getNombre()).getElement();
		Usuario usu2 = modelo.buscarVerticeUsuario2(usuario2.getNombre()).getElement();
		List<Usuario> antiguedad = modelo.calcularAntiguedad(usu1, usu2);
		assertTrue(antiguedad.containsAll(usuariosAntiguedad));
		assertTrue(usuariosAntiguedad.containsAll(antiguedad));
	}

	public void testTiempoDeAmistad() {
		TreeMap<Integer, Usuario> amistades = modelo.tiempoAmistadYCantAmigos(usuario1);
		for (Entry<Integer, Usuario> usuario : amistades.entrySet())
			assertTrue(amigosUsuario.containsValue(usuario.getValue().getNombre()));
	}
}
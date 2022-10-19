package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import modelo.Relacion;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;



/**
 * Clase que se encarga de la lectura y la carga de los datos desde los
 * archivos.
 * 
 * @author Sofía Pacheco, Aldana De Sampigny y Macarena Repetto
 *
 */
public class CargaDatos {

	/**
	 * Lee el archivo que se envía como argumento y los carga en un mapa.
	 * 
	 * @param fileName
	 * @return un mapa con el id como clave y el Usuario como valor.
	 * @throws FileNotFoundException
	 */
	public static Map<String, Usuario> cargarUsuarios(String fileName) throws FileNotFoundException {
		Scanner read;
		Map<String, Usuario> usuarios = new TreeMap<String, Usuario>();

		// Lee el archivo pasado como argumento y va almacenando los datos de los
		// usuarios.
		read = new Scanner(new File(fileName));
		read.useDelimiter("\\s*;\\s*");
		String id, nombre, genero, ciudad, nivelAca;
		int edad;
		while (read.hasNext()) {
			id = read.next();
			nombre = read.next();
			edad = read.nextInt();
			genero = read.next();
			ciudad = read.next();
			nivelAca = read.next();

			usuarios.put(id, new Usuario(id, nombre, edad, genero, ciudad, nivelAca));
		}
		read.close();

		return usuarios;
	}

	/**
	 * Lee las relaciones del archivo enviado como parámetro y, con el mapa de
	 * usuarios que también recibe, crea una lista con las relaciones.
	 * @param fileName
	 * @param usuarios
	 * @return una lista con las relaciones
	 * @throws FileNotFoundException
	 */
	public static List<Relacion> cargarRelaciones(String fileName, Map<String, Usuario> usuarios)
			throws FileNotFoundException {
		Scanner read;
		List<Relacion> relaciones = new ArrayList<Relacion>();

		// Lee el archivo pasado como argumento y va cargando las relaciones.
		read = new Scanner(new File(fileName));
		read.useDelimiter("\\s*;\\s*");
		Usuario v1, v2;
		int tiempo, likes, interacc;
		while (read.hasNext()) {
			v1 = usuarios.get(read.next());
			v2 = usuarios.get(read.next());
			tiempo = read.nextInt();
			likes = read.nextInt();
			interacc = read.nextInt();

			relaciones.add(0, new Relacion(v1, v2, tiempo, likes, interacc));
		}
		read.close();

		return relaciones;
	}

}

package datos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase representa los parámetros del archivo properties.
 * 
 * @author Maca Repetto
 *
 */
public class CargaParametros {

	private static String archUsuarios;
	private static String archRelaciones;

	/**
	 * Carga los parámetros leidos del archivo.
	 * @throws IOException
	 */
	public static void parametros() throws IOException {

		// Lee el archivo de configuración y carga los parametros para que se puedan
		// utilizar más adelante.
		Properties prop = new Properties();
		InputStream input = new FileInputStream("config.properties");

		prop.load(input);
		// Obtiene las propiedades de los valores
		archUsuarios = prop.getProperty("usuarios");
		archRelaciones = prop.getProperty("relaciones");
	}

	public static String getArchUsuarios() {
		return archUsuarios;
	}

	public static String getArchRelaciones() {
		return archRelaciones;
	}

}

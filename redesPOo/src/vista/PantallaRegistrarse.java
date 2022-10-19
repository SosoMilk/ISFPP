package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PantallaRegistrarse extends JFrame {
	private JPanel contentPane;
	private JComboBox<String> sexos;
	
	private JTextField codigoUsuario;
	private JTextField nombreCompleto;
	private JTextField edad;
	private JTextField sexo;
	private JTextField ciudad;
	
	private JLabel errorCodigo;
	private JLabel errorNombre;
	private JLabel errorEdad;
	private JLabel errorSexo;
	private JLabel ciudadError;

	public  PantallaRegistrarse() {
		
		setBounds(100, 100, 662, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220,150,250));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etiquetaNombre  = new JLabel("Nombre Y apellido:");
		etiquetaNombre .setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaNombre .setBounds(32, 55, 200, 16);
		contentPane.add(etiquetaNombre);
		
		nombreCompleto = new JTextField();
		nombreCompleto.setBounds(195, 24, 115, 25);
		nombreCompleto.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(nombreCompleto);
		nombreCompleto.setColumns(10);

		JLabel etiquetaCodUsuario = new JLabel("Codigo:");
		etiquetaCodUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaCodUsuario.setBounds(32, 24, 107, 16);
		contentPane.add(etiquetaCodUsuario);
		
		codigoUsuario = new JTextField();
		codigoUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		codigoUsuario.setBounds(195, 55,115, 25);
		contentPane.add(codigoUsuario);
		codigoUsuario.setColumns(10);


		JLabel etiquetaEdad = new JLabel("Edad :");
		etiquetaEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaEdad.setBounds(32, 89, 107, 16);
		contentPane.add(etiquetaEdad);

		edad = new JTextField();
		edad.setFont(new Font("Tahoma", Font.BOLD, 13));
		edad.setBounds(195, 86, 115, 25);
		contentPane.add(edad);
		edad.setColumns(10);

		JLabel etiquetaSexo = new JLabel("Sexo :");
		etiquetaSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaSexo.setBounds(32, 120, 107, 16);
		contentPane.add(etiquetaSexo);
		

		sexo = new JTextField();
		sexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexo.setColumns(10);
		sexo.setBounds(195, 117, 115, 25);
		contentPane.add(sexo);

		JLabel etiquetaCiudad = new JLabel("Ciudad:");
		etiquetaCiudad.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaCiudad.setBounds(32, 151, 107, 16);
		contentPane.add(etiquetaCiudad);

		ciudad = new JTextField();
		ciudad.setFont(new Font("Tahoma", Font.BOLD, 13));
		ciudad.setColumns(10);
		ciudad.setBounds(195, 148,115, 25);
		contentPane.add(ciudad);

		JButton botonAgregar = new JButton("Agregar");
		botonAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		
		botonAgregar.setBounds(255, 204, 114, 32);
		contentPane.add(botonAgregar);

		
		errorCodigo = new JLabel("");
		errorCodigo.setForeground(Color.RED);
		errorCodigo.setBounds(350, 55, 300, 20);
		errorCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(errorCodigo);

		errorNombre = new JLabel("");
		errorNombre.setForeground(Color.RED);
		errorNombre.setBounds(350, 24, 300, 20);
		errorNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(errorNombre);

		
		errorEdad = new JLabel("");
		errorEdad.setForeground(Color.RED);
		errorEdad.setBounds(350, 89, 300, 20);
		errorEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(errorEdad);

		errorSexo = new JLabel("");
		errorSexo.setForeground(Color.RED);
		errorSexo.setBounds(350, 120, 300, 20);
		errorSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(errorSexo);

		ciudadError = new JLabel("");
		ciudadError.setForeground(Color.RED);
		ciudadError.setBounds(350, 151, 300, 20);
		ciudadError.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(ciudadError);

		Handler handler = new Handler();
		botonAgregar.addActionListener(handler);

	}
	private class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
	
			boolean valido = true;

			errorCodigo.setText("");
			errorNombre.setText("");
			errorEdad.setText("");
			errorSexo.setText("");
			ciudadError.setText("");
	
			// validar nombre completo
			String nombreYapellido = nombreCompleto.getText().trim();
			if (nombreYapellido.isEmpty()) {
				errorNombre.setText("Campo obligatorio");
				valido = false;
			} 
			else 
				if (nombreYapellido.matches("[A-Z][a-zA-Z]*") != true) {
					errorNombre.setText("Solo letras. Primera con mayúscula");
					valido = false;
				}
	
			// validar codigo Usuario
			String codigo = codigoUsuario.getText().trim();
			if (codigo.isEmpty()) {
				errorCodigo.setText("Campo obligatorio");
				valido = false;
			} /*else if (codigo.matches("[A-Z][a-zA-Z]*") != true) {
				error.setText("Solo letras. Primera con mayúscula");
				valido = false;
			}*/
	
			// validar edad
			String edadUsuario = edad.getText().trim();
			if (edadUsuario.isEmpty()) {
				errorEdad.setText("Campo obligatorio");
				valido = false;
			} 
			else 
				if (edadUsuario.matches("[1-100]*") != true) {
					errorEdad.setText("Solo dígitos");
					valido = false;
				}
	
			
			String sexoUsuario = sexo.getText().trim();
			if (sexoUsuario.isEmpty()) {
				errorSexo.setText("Campo obligatorio");
				valido = false;
			}
			
			String localidad = ciudad.getText().trim();
			if (localidad.isEmpty()) {
				ciudadError.setText("Campo obligatorio");
				valido = false;
			} 
			else 
				if (nombreYapellido.matches("[A-Z][a-zA-Z]*") != true) {
					ciudadError.setText("Solo letras. Primera con mayúscula");
					valido = false;
				}
		}
	}
}


package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import controlador.Controlador;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class PantallaIniciarSesion extends JFrame implements ActionListener {
	private JComboBox<String> combo1;
	private JLabel titulo;
	private JTextArea jtaTexto;
	private static JList<String> jlista;
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JButton botonEnter, btnAceptar;
	private JButton botonVolver;
	private JPanel panel;
	private Controlador controlador;
	private static final int CANT_CENTRALIDAD = 15;
	private JScrollPane barra = new JScrollPane(jlista);
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	public PantallaIniciarSesion() {
		setTitle("SOALMA - Red Social");

		this.getContentPane().setBackground(new Color(220, 150, 250));

		modelo.removeAllElements();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 501 };
		gridBagLayout.rowHeights = new int[] { 52, 51, 52, 70, 0, 0, 80, 30, 0, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		this.titulo = new JLabel("Elija Una Opcion ", JLabel.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.fill = GridBagConstraints.BOTH;
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 0;
		getContentPane().add(titulo, gbc_titulo);
		// texto.setBackground(new Color(220,150,250));
		combo1 = new JComboBox<String>();

		combo1.addItem("Amistades Promedio");
		combo1.addItem("Lista de amistades y duración");
		combo1.addItem("Usuarios más influyentes");
		combo1.addItem("Camino más nuevo");
		combo1.addItem("Sugerencia de nuevas amistades");
		combo1.addItem("Usuaros más densamente conectados");

		combo1.setBounds(10, 5, 5, 10);
		GridBagConstraints gbc_combo1 = new GridBagConstraints();
		gbc_combo1.fill = GridBagConstraints.BOTH;
		gbc_combo1.insets = new Insets(0, 0, 5, 0);
		gbc_combo1.gridx = 0;
		gbc_combo1.gridy = 1;
		getContentPane().add(combo1, gbc_combo1);

		this.botonEnter = new JButton("Enter ");
		this.botonVolver = new JButton("Atras");
		this.panel = new JPanel();
		this.panel.setBackground(new Color(220, 150, 250));

		this.panel.add(botonEnter);
		this.panel.add(botonVolver);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		getContentPane().add(panel, gbc_panel);

		botonEnter.addActionListener(this);
		botonVolver.addActionListener(this);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		jtaTexto = new JTextArea("");
		scrollPane_1.setViewportView(jtaTexto);
		jtaTexto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtaTexto.setEditable(false);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		getContentPane().add(scrollPane, gbc_scrollPane);
		this.jlista = new JList<String>();
		scrollPane.setViewportView(jlista);
		jlista.setValueIsAdjusting(true);
		jlista.setVisibleRowCount(20);

		this.btnAceptar = new JButton("Seleccionar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 8;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		btnAceptar.addActionListener(this);

	}

	public JButton getBotonEnter() {
		return botonEnter;
	}

	public JButton getBotonVovler() {
		return botonEnter;
	}

	public void actionPerformed(ActionEvent evento) {

		String opcionElegida = (String) combo1.getSelectedItem();
		if (evento.getSource().equals(botonEnter)) {

			if (opcionElegida == "Amistades Promedio") {
				this.controlador.gradoPromedio();
			}

			if (opcionElegida == "Lista de amistades y duración") {
				jtaTexto.setText("Seleccione un usuario");
				jlista.setVisible(true);
				this.controlador.usuarios();
			}

			if (opcionElegida == "Usuarios más influyentes") {
				this.controlador.centralidad();
			}

			if (opcionElegida == "Camino más nuevo") {
				jtaTexto.setText("Presionar CTRL para seleccionar 2 usuarios");
				controlador.usuarios();
			}

			if (opcionElegida == "Sugerencia de nuevas amistades") {
				jtaTexto.setText("Seleccione un usuario");
				this.controlador.usuarios();
			}

			if (opcionElegida == "Usuaros más densamente conectados") {
				this.controlador.calcularDensidad();
			}
		}

		if (evento.getSource().equals(botonVolver)) {
			this.setVisible(false);
		}

		if (evento.getSource().equals(btnAceptar)) {
			if (opcionElegida == "Sugerencia de nuevas amistades") {
				String usuario = jlista.getSelectedValue().toString();
				controlador.buscarUsuarioSugerencia(usuario);
			}

			if (opcionElegida == "Camino más nuevo") {
				jlista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				ArrayList<String> usuarios = new ArrayList<String>();
				for (String a : jlista.getSelectedValuesList()) {
					usuarios.add(0, a);
				}
				controlador.buscarUsuarioAntiguedad(usuarios);
			}

			if (opcionElegida == "Lista de amistades y duración") {
				String usuarioAmistad = jlista.getSelectedValue().toString();
				controlador.buscarAmigos(usuarioAmistad);
			}
		}
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void mostrarDensidad(Iterable<Entry<Integer, Usuario>> usuariosMasDensos) {
		jtaTexto.setText("");
		for (Entry<Integer, Usuario> mayorInteraccion : usuariosMasDensos) {
			jtaTexto.append(mayorInteraccion.getKey() + " " + mayorInteraccion.getValue().getNombre() + "\n");
		}
	}

	public void mostrarPromedio(double promedio) {
		jtaTexto.setText("Los usuarios tienen un promedio de " + String.valueOf(promedio) + " amigos cada uno.");
	}

	public void mostrarCentralidad(Map<Integer, List<Usuario>> mapa) {
		jtaTexto.setText("");
		int cantidad = 0;
		for (Entry<Integer, List<Usuario>> elem : mapa.entrySet()) {
			for (Usuario usuario : elem.getValue()) {
				if (cantidad < CANT_CENTRALIDAD) {
					jtaTexto.append(usuario.getId() + "\t" + usuario.getNombre() + "\t\t" + elem.getKey() + "\n");
					cantidad++;
				}
			}
		}
	}

	public void mostrarAntiguedad(List<Usuario> camino) {
		jtaTexto.setText("");
		for (Usuario elem : camino)
			jtaTexto.append(elem.getId() + "\t" + elem.getNombre() + "\n");

	}

	public void mostrarSugerencias(List<Usuario> amistades, List<Usuario> sugerencias, Usuario usuario) {
		jtaTexto.setText("");
		if (amistades.isEmpty()) {
			jtaTexto.setText("No se han Encontrado Sugerencias para" + usuario.getNombre());
		} else {
			for (Usuario user : sugerencias) {
				jtaTexto.append(user.getNombre() + " - " + usuario.getEdad() + " - " + user.getCiudad() + " - "
						+ user.getNivelAcademico() + "\n");
			}
		}
	}

	public void mostrarUsuarios(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			modelo.addElement(usuario.getNombre());
		}
		jlista.setModel(modelo);
	}

	public void mostrarAmigos(Iterable<Entry<Integer, Usuario>> mapa) {
		jtaTexto.setText("Tiempo de amistad"+ "\t" +"Amig@" +  "\n");
		for (Entry<Integer, Usuario> usuario : mapa) {
			jtaTexto.append(usuario.getKey() + "\t" + usuario.getValue().getNombre()  +  "\n");

		}
	}
}

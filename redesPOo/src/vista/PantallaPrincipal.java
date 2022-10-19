package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaPrincipal extends JFrame implements ActionListener {
	private JPanel panel1;
	private JPanel panelImage;
	private JButton botonIniciarSesion;
	private JButton botonRegistrarse;
	private JLabel titulo;
	// private Image backgroundImage;
	private PantallaIniciarSesion inicio;
	private PantallaRegistrarse registrarse;
	private Controlador controlador;

	public PantallaPrincipal() throws IOException {
		setTitle("SOALMA - Red Social");

		this.getContentPane().setBackground(new Color(220, 150, 250));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 434, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 31, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		this.titulo = new JLabel(" \u00A1Bienvenido/a a SOALMA - la mejor Red Social! ", JLabel.CENTER);
		this.titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridheight = 2;
		gbc_titulo.fill = GridBagConstraints.BOTH;
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 1;
		getContentPane().add(this.titulo, gbc_titulo);

		this.botonIniciarSesion = new JButton("Iniciar Sesion");
		this.botonIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.botonRegistrarse = new JButton(" Registrarse ");
		this.botonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.panel1 = new JPanel();
		this.panel1.setBackground(new Color(220, 150, 250));

		this.panel1.add(botonIniciarSesion);
		this.panel1.add(botonRegistrarse);
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 3;
		getContentPane().add(panel1, gbc_panel1);

		this.botonIniciarSesion.addActionListener(this);
		this.botonRegistrarse.addActionListener(this);
	}

	public void setPantallaInicioSesion(PantallaIniciarSesion pantalla) {
		this.inicio = pantalla;
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource().equals(botonIniciarSesion)) {
			inicio.setSize(560, 430);
			inicio.setVisible(true);
			inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		if (evento.getSource().equals(botonRegistrarse)) {
			registrarse = new PantallaRegistrarse();
			registrarse.setVisible(true);
			registrarse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}

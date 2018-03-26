package gui;

/**
 * @author PMOO 2018
 *
 */

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaProductoBasica extends JDialog {

	private JPanel panelContenido;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtPeso;

	private boolean guardar = false;

	/**
	 * Indica si se ha pulsado en el bot�n "guardar" o no
	 * 
	 * @return true sii se ha pulsado el bot�n "guardar"
	 */
	public boolean pulsadoGuardar() {
		return guardar;
	}

	/**
	 * Costructora que genera la ventana que visualiza los productos
	 */
	public VentanaProductoBasica() {
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 708, 313);
		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelContenido.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));
		setContentPane(panelContenido);

		this.setTitle(ExternalTextVP.TITLE);// "Super Online - Produktua");

		JLabel lblProducto = new JLabel(ExternalTextVP.PRODUCT);// "PRODUKTUA");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelContenido.add(lblProducto, "10, 2");

		JLabel lblNombre = new JLabel(ExternalTextVP.NAME);// "Izena");
		panelContenido.add(lblNombre, "2, 6, right, default");

		txtNombre = new JTextField();
		panelContenido.add(txtNombre, "4, 6, 7, 1, fill, default");
		txtNombre.setColumns(10);

		JLabel lblPrecio = new JLabel(ExternalTextVP.PRICE);// "Prezioa");
		panelContenido.add(lblPrecio, "2, 8, right, default");

		txtPrecio = new JTextField();
		panelContenido.add(txtPrecio, "4, 8, fill, default");
		txtPrecio.setColumns(10);

		JLabel lblCantidad = new JLabel(ExternalTextVP.AMOUNT);
		panelContenido.add(lblCantidad, "2, 12, right, default");

		txtCantidad = new JTextField();
		panelContenido.add(txtCantidad, "4, 12, fill, default");
		txtCantidad.setColumns(10);

		JLabel lblPeso = new JLabel(ExternalTextVP.WEIGHT);
		panelContenido.add(lblPeso, "2, 14, right, default");

		txtPeso = new JTextField();
		panelContenido.add(txtPeso, "4, 14, fill, default");
		txtPeso.setColumns(10);

		JButton btnCancelar = new JButton(ExternalTextVP.CANCEL);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiaCuadroDeTexto();
				guardar = false;
				setVisible(false);
			}
		});

		JButton btnGuardar = new JButton(ExternalTextVP.SAVE);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// validaci�n de campos:
				String mensaje = "";

				// debe rellenarse el campo obligatorio:
				for (Component control : panelContenido.getComponents()) {
					if ((control instanceof JTextField) && (control.isVisible()) && (control.isEnabled())) {
						if (((JTextField) control).getText().equals("")) {
							mensaje = ExternalTextVP.MESSAGE_ALL_FIELD;// "Eremu guztietan sartu behar da balioren
																		// bat.";
							break;
						}
					}
				}

				// campos num�ricos correctamente rellenados:
				if (((txtPrecio.isVisible()) && !esTipoReal(txtPrecio.getText()))
						|| ((txtPeso.isVisible()) && !esTipoReal(txtPeso.getText()))
						|| ((txtCantidad.isVisible()) && !esTipoEntero(txtCantidad.getText()))) {
					mensaje = mensaje + ExternalTextVP.MESSAGE_NUMERICS_INT_OR_FLOAT;
					;// " Zenbakizko eremuetan zenbakizko balio egokiak (osoak edo errealak) sartu
						// behar dira.";
				}

				if (mensaje.equals("")) {
					guardar = true;
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, mensaje, ExternalTextVP.VALIDATION_ERROR, // "Super Online -
																									// Balidazio-errorea",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnLimpiar = new JButton(ExternalTextVP.CLEAR);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiaCuadroDeTexto();
			}
		});

		panelContenido.add(btnGuardar, "4, 20");
		panelContenido.add(btnLimpiar, "12, 20");
		panelContenido.add(btnCancelar, "14, 20");

	}

	/**
	 * Comprueba si n corresponde con un valor num�rico entero
	 * 
	 * @param n
	 *            String recogido de un campo num�rico entero
	 * @return truee sii n corresponde con un n�mero entero
	 */
	private static boolean esTipoEntero(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Comprueba si n corresponde con un valor num�rico real
	 * 
	 * @param n
	 *            String recogido de un campo num�rico real
	 * @return
	 */
	private static boolean esTipoReal(String n) {
		try {
			Double.parseDouble(n);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Limpia el cuadrdo de texto sin ninguna informaci�n
	 */
	private void limpiaCuadroDeTexto() {
		for (Component control : panelContenido.getComponents()) {
			if (control instanceof JTextField) {
				((JTextField) control).setText("");
			} else if (control instanceof JComboBox<?>) {
				((JComboBox<?>) control).setSelectedIndex(0);
			}
		}
	}

	// M�todos que obtienen valores de las ventanas:

	/**
	 * Obtiene el valor correspondiente al nombre
	 * 
	 * @return el nombre del producto
	 */
	public String getTxtNombre() {
		return txtNombre.getText();
	}

	/**
	 * Obtiene el valor correspondiente al precio
	 * 
	 * @return el precio del producto
	 */
	public double getTxtPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	/**
	 * Obtiene el valor correspondiente a la cantidad
	 * 
	 * @return cantidad de unidades del producto
	 */
	public int getTxtCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	/**
	 * Obtiene el valor correspondiente al peso
	 * 
	 * @return peso del producto
	 */
	public double getTxtPeso() {
		return Double.parseDouble(txtPeso.getText());
	}

}

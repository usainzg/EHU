package gui;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class VentanaProducto extends JDialog {

	private String[] tipos=new String[] {"Bebida", "Herramienta", "Lacteo", "Fruta y Hortaliza", "Otro"};
	private JPanel edukiPanela;
	private JTextField txtIzena;
	private JTextField txtPrezioa;
	private JTextField txtKopurua;
	private JTextField txtPisua;
	private JTextField txtIraungitzeData;
	private JTextField txtJatorria;
	private JTextField txtLotea;
	private JTextField txtKategoria;
	private JTextField txtGraduazioa;


	private JLabel lblIraungitzeData;
	private JLabel lblJatorria;
	private JLabel lblLotea;
	private JLabel lblKategoria;
	private JLabel lblGraduazioa;

	private boolean guardar=false;
	private JComboBox<String> listaKonbinatua;

	/**
	 * Indica si se ha pulsado en el botón "guardar" o no
	 * @return true sii se ha pulsado el botón "guardar"
	 */
	public boolean pulsadoGuardar () {
		return guardar;
	}

	/**
	 * Costructora que genera la ventana que visualiza los productos
	 */
	public VentanaProducto() {
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 610, 313);
		edukiPanela = new JPanel();
		edukiPanela.setBorder(new EmptyBorder(5, 5, 5, 5));
		edukiPanela.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		setContentPane(edukiPanela);

		this.setTitle(ExternalTextVP.TITLE);//"Super Online - Produktua");

		JLabel lblProduktua = new JLabel(ExternalTextVP.PRODUCT);//"PRODUKTUA");
		lblProduktua.setFont(new Font("Tahoma", Font.BOLD, 14));
		edukiPanela.add(lblProduktua, "10, 2");

		JLabel lblMota = new JLabel(ExternalTextVP.TYPE);//"Mota");
		edukiPanela.add(lblMota, "12, 4, right, default");

		listaKonbinatua = new JComboBox<String>();
		listaKonbinatua.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//				JComboBox cb = (JComboBox) e.getSource();
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = e.getItem().toString();
					agregarCuadroTextoOculto();
					switch (item) {
					case "Bebida"://"Edaria":
						lblIraungitzeData.setVisible(true);
						lblGraduazioa.setVisible(true);
						txtIraungitzeData.setVisible(true);
						txtGraduazioa.setVisible(true);
						break;  
					case "Lacteo":
						lblIraungitzeData.setVisible(true);
						lblLotea.setVisible(true);
						txtIraungitzeData.setVisible(true);
						txtLotea.setVisible(true);
						break;  
					case "Herramienta":
						// Hay que tratar la fragilidad
						break;  
					case "Fruta y Hortaliza":
						lblIraungitzeData.setVisible(true);
						lblJatorria.setVisible(true);
						txtIraungitzeData.setVisible(true);
						txtJatorria.setVisible(true);
						break;  
					case "Otro":
						lblKategoria.setVisible(true);
						txtKategoria.setVisible(true);
						break; 
					default: //***						
					}
				}
			}

		});

		listaKonbinatua.setModel(new DefaultComboBoxModel<String>(tipos
				//new String[] {"Edaria", "Erreminta", "Esnekia", "Fruta / Barazkia", "Bestelakoa"}
				));
		edukiPanela.add(listaKonbinatua, "14, 4, 7, 1, fill, default");

		JLabel lblIzena = new JLabel(ExternalTextVP.NAME);//"Izena");
		edukiPanela.add(lblIzena, "2, 6, right, default");

		txtIzena = new JTextField();
		edukiPanela.add(txtIzena, "4, 6, 7, 1, fill, default");
		txtIzena.setColumns(10);

		JLabel lblPrezioa = new JLabel(ExternalTextVP.PRICE);//"Prezioa");
		edukiPanela.add(lblPrezioa, "2, 8, right, default");

		txtPrezioa = new JTextField();
		edukiPanela.add(txtPrezioa, "4, 8, fill, default");
		txtPrezioa.setColumns(10);

		lblIraungitzeData = new JLabel(ExternalTextVP.EXPIRATION_DATE);//"Iraungitze-data (UUUU-HH-EE)");
		edukiPanela.add(lblIraungitzeData, "12, 8, right, default");

		txtIraungitzeData = new JTextField();
		edukiPanela.add(txtIraungitzeData, "14, 8, fill, default");
		txtIraungitzeData.setColumns(10);

		lblLotea = new JLabel(ExternalTextVP.LOT);
		edukiPanela.add(lblLotea, "12, 10, right, default");

		txtLotea = new JTextField();
		edukiPanela.add(txtLotea, "14, 10, fill, default");
		txtLotea.setColumns(10);

		JLabel lblKopurua = new JLabel(ExternalTextVP.AMOUNT);
		edukiPanela.add(lblKopurua, "2, 10, right, default");

		txtKopurua = new JTextField();
		edukiPanela.add(txtKopurua, "4, 10, fill, default");
		txtKopurua.setColumns(10);

		lblKategoria = new JLabel(ExternalTextVP.CATEGORY);
		edukiPanela.add(lblKategoria, "12, 8, right, default");

		txtKategoria = new JTextField();
		edukiPanela.add(txtKategoria, "14, 8, fill, default");
		txtKategoria.setColumns(10);

		JLabel lblPisua = new JLabel(ExternalTextVP.WEIGHT);
		edukiPanela.add(lblPisua, "2, 12, right, default");

		txtPisua = new JTextField();
		edukiPanela.add(txtPisua, "4, 12, fill, default");
		txtPisua.setColumns(10);

		lblGraduazioa = new JLabel(ExternalTextVP.ALCOHOL);
		edukiPanela.add(lblGraduazioa, "12, 10, right, default");

		txtGraduazioa = new JTextField();
		edukiPanela.add(txtGraduazioa, "14, 10, fill, default");
		txtGraduazioa.setColumns(10);

		lblJatorria = new JLabel(ExternalTextVP.ORIGIN);
		edukiPanela.add(lblJatorria, "12, 10, right, default");

		txtJatorria = new JTextField();
		edukiPanela.add(txtJatorria, "14, 10, fill, default");
		txtJatorria.setColumns(10);

		JButton btnUtzi = new JButton(ExternalTextVP.CANCEL);
		btnUtzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiaCuadroDeTexto();
				guardar = false;
				setVisible(false);
			}
		});

		JButton btnAdos = new JButton(ExternalTextVP.SAVE);
		btnAdos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validación de campos:
				String mezua = "";

				//debe rellenarse el campo obligatorio:
				for (Component kontrola : edukiPanela.getComponents()) {
					if ((kontrola instanceof JTextField) &&
							(kontrola.isVisible()) &&
							(kontrola.isEnabled())) {
//						System.out.println(kontrola.getName());
						if (((JTextField) kontrola).getText().equals("")) {
							mezua = ExternalTextVP.MESSAGE_ALL_FIELD;//"Eremu guztietan sartu behar da balioren bat.";
							break;
						}
					}
				}
				
				//campos númericos correctamente rellenados:
				if (((txtPrezioa.isVisible()) && !esTipoReal(txtPrezioa.getText())) || 
						((txtPisua.isVisible()) && !esTipoReal(txtPisua.getText())) || 
						((txtKopurua.isVisible()) && !esTipoEntero(txtKopurua.getText())) ||
						((txtGraduazioa.isVisible()) && !esTipoEntero(txtGraduazioa.getText()))) {
					mezua = mezua + ExternalTextVP.MESSAGE_NUMERICS_INT_OR_FLOAT;;//" Zenbakizko eremuetan zenbakizko balio egokiak (osoak edo errealak) sartu behar dira.";
				}
				
				if (mezua.equals("")) {
					guardar = true;
					setVisible(false);					
				} else {
					JOptionPane.showMessageDialog(null, mezua, ExternalTextVP.VALIDATION_ERROR,//"Super Online - Balidazio-errorea",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		JButton btnGarbitu = new JButton(ExternalTextVP.CLEAR);
		btnGarbitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiaCuadroDeTexto();
			}
		});

		edukiPanela.add(btnAdos, "4, 20");
		edukiPanela.add(btnGarbitu, "12, 20");
		edukiPanela.add(btnUtzi, "14, 20");

		agregarCuadroTextoOculto();
		lblIraungitzeData.setVisible(true);
		lblGraduazioa.setVisible(true);
		txtIraungitzeData.setVisible(true);
		txtGraduazioa.setVisible(true);

	}

	/**
	 * Comprueba si n corresponde con un valor numérico entero
	 * @param n String recogido de un campo numérico entero
	 * @return truee sii n corresponde con un número entero
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
	 * Comprueba si n corresponde con un valor numérico real
	 * @param n String recogido de un campo numérico real
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
	 * Limpia el cuadrdo de texto sin ninguna información
	 */
	private void limpiaCuadroDeTexto() { 
		for(Component kontrola : edukiPanela.getComponents()) {
			if(kontrola instanceof JTextField) {
				((JTextField)kontrola).setText("");
			}
			else if (kontrola instanceof JComboBox<?>) {
				((JComboBox<?>)kontrola).setSelectedIndex(0);
			}
		}
	}

	/**
	 * Agrega cuadro de texto oculto
	 */
	private void agregarCuadroTextoOculto() {
		lblIraungitzeData.setVisible(false);
		lblLotea.setVisible(false);
		lblKategoria.setVisible(false);
		lblGraduazioa.setVisible(false);
		lblJatorria.setVisible(false);				
		txtIraungitzeData.setVisible(false);
		txtLotea.setVisible(false);
		txtKategoria.setVisible(false);
		txtGraduazioa.setVisible(false);
		txtJatorria.setVisible(false);				
	}


	//Métodos que obtienen valores de las ventanas:

//	/**
//	 * Obtiene el valor correspondiente al código
//	 * @return el código del producto
//	 */
//	public int getTxtCodigo() {
//		return Integer.parseInt(txtKodea.getText());
//	}

	/**
	 * Obtiene el valor correspondiente al nombre
	 * @return el nombre del producto
	 */
	public String getTxtNombre() {
		return txtIzena.getText();
	}
	
	/**
	 * Obtiene el valor correspondiente al precio
	 * @return el precio del producto
	 */
	public double getTxtPrecio() {
		return Double.parseDouble(txtPrezioa.getText());
	}

	/**
	 * Obtiene el valor correspondiente a la cantidad
	 * @return cantidad de unidades del producto
	 */
	public int getTxtCantidad() {
		return Integer.parseInt(txtKopurua.getText());
	}
	
	/**
	 * Obtiene el valor correspondiente al peso
	 * @return peso del producto
	 */
	public double getTxtPeso() {
		return Double.parseDouble(txtPisua.getText());
	}
	
	/**
	 * Obtiene el valor correspondiente al tipo
	 * @return tipo del producto
	 */
	public String getTipoProducto() {
		return listaKonbinatua.getSelectedItem().toString();
	}
	
	/**
	 * Obtiene el valor correspondiente a la fecha de caducidad
	 * @return fecha caducidad del producto
	 */
	public String getTxtFechaCaducidad() {
		return txtIraungitzeData.getText();
	}
	
	/**
	 * Obtiene el valor correspondiente al lote
	 * @return lote del producto
	 */
	public String getTxtLote() {
		return txtLotea.getText();
	}
	
	/**
	 * Obtiene el valor correspondiente a la categoria
	 * @return categoria del producto
	 */
	public String getTxtCategoria() {
		return txtKategoria.getText();
	}
	
	/**
	 * Obtiene el valor correspondiente a la graduación
	 * @return graduación del producto
	 */
	public int getTxtGraduacion() {
		return Integer.parseInt(txtGraduazioa.getText());
	}
	
	
	/**
	 * Obtiene el valor correspondiente al origen
	 * @return origen del producto
	 */
	public String getTxtOrigen() {
		return txtJatorria.getText();
	}

}

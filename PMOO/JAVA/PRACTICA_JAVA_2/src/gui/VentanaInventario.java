package gui;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import super4.Inventario;

import java.util.ArrayList;
import java.awt.Component;

@SuppressWarnings("serial")
public class VentanaInventario extends JDialog {

	private JTable taula;

	private JLabel lblInbentarioa, lblBehekoOharra;

	class ProduktuTaulaModelo extends AbstractTableModel { //inbentarioa bistaratzeko taularen modeloa

		private final ArrayList<ArrayList<String>> produktuMatrizea;

		private final ArrayList<String> zutabeIzenak = new ArrayList<String>(); 

		public ProduktuTaulaModelo (ArrayList<ArrayList<String>> prodMatrizea)
		{
			zutabeIzenak.add(ExternalTextVI.CODE);
			zutabeIzenak.add(ExternalTextVI.NAME);
			zutabeIzenak.add(ExternalTextVI.PRICE);
			zutabeIzenak.add(ExternalTextVI.PRICE_VAT);
			zutabeIzenak.add(ExternalTextVI.AMOUNT);
			//zutabeIzenak.add("Pisua");
			zutabeIzenak.add(ExternalTextVI.EXPIRATIONDATE);
			zutabeIzenak.add(ExternalTextVI.OTHERS);
			this.produktuMatrizea = prodMatrizea;
		}

		@Override
		public String getColumnName(int column)
		{
			return zutabeIzenak.get(column);
		}

		@Override
		public int getColumnCount()
		{
			return zutabeIzenak.size();
		}

		@Override
		public int getRowCount()
		{
			return produktuMatrizea.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
		{
			//System.out.println("getValueAt: " + rowIndex + ", " + columnIndex + " = " + produktuMatrizea.get(rowIndex).get(columnIndex));
			return produktuMatrizea.get(rowIndex).get(columnIndex);
		}

		/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		@Override
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			if (col == 4) { //kopurua soilik da editagarria (hala ere, ez da editatzen) 
				return true;
			} else {
				return false;
			}
		}

		public void removeRow(int row){
			produktuMatrizea.remove(row);
			fireTableDataChanged();
		}

	}

	private static boolean zenbOsoaDa(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


	/**
	 * Create the dialog.
	 */
	public VentanaInventario(ArrayList<ArrayList<String>> prodMatrizea) {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		lblInbentarioa = new JLabel(ExternalTextVI.INVENTORY);
		lblInbentarioa.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(lblInbentarioa);
		lblInbentarioa.setFont(new Font("Tahoma", Font.BOLD, 14));

		this.setTitle(ExternalTextVI.TITLE);

		//taulako datuen modeloa
		ProduktuTaulaModelo modeloa = new ProduktuTaulaModelo(prodMatrizea);
		//taula 
		taula = new JTable(modeloa);
		//taula = new JTable(produktuMatrizea, zutabeIzenak);

		//testuinguruko menua (saguaren botoi lagungarria)
		final JPopupMenu testuingurukoMenua = new JPopupMenu();
		JMenuItem mnuKopEguneratu = new JMenuItem(ExternalTextVI.UPDATE_AMOUNT);
		JMenuItem mnuProdEzabatu = new JMenuItem(ExternalTextVI.DELETE_PRODUCT);


		mnuKopEguneratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kodea = Integer.parseInt(taula.getModel().
						getValueAt(taula.getSelectedRow(), 0).toString()); //hautatutako errenkadako kodea
				int oraingoKop = Integer.parseInt(taula.getModel().
						getValueAt(taula.getSelectedRow(), 4).toString());
				String kopBerria = JOptionPane.showInputDialog(taula, ExternalTextVI.methodProductAmountUpdate(kodea, oraingoKop),
						/*"Sartu hemen behean " + 
								kodea + 
								" kodeko produktuaren kopuru berria (oraintxe " + 
								oraingoKop +		
						" unitate daude).", 
						"Super Online - Kopurua eguneratu", */
						ExternalTextVI.UPDATE_AMOUNT , JOptionPane.QUESTION_MESSAGE);

				if (!(kopBerria == null)) { //Ez du Cancel sakatu

					//sartutakoa zenbaki osoa dela egiaztatu:
					while (!(kopBerria == null) && !(zenbOsoaDa(kopBerria))) {
						kopBerria = JOptionPane.showInputDialog(null, ExternalTextVI.methodProductAmountError(kodea, oraingoKop),
								/*"Kopuruak zenbaki osoa izan behar du; saiatu berriz (produktuaren kodea: " + 
										kodea +
										"; oraingo kopurua: " +
										oraingoKop +
										")!", */
										ExternalTextVI.VALIDATION_ERROR, //"Super Online - Balidazio-errorea",
										JOptionPane.ERROR_MESSAGE);
					}

					Inventario inb = Inventario.getInventario();
					
					if (!(kopBerria == null)) { //Ez du Cancel sakatu
						try {
							inb.actualizarCantidad(kodea,
									Integer.parseInt(kopBerria));
							taula.setModel(new ProduktuTaulaModelo(inb.inventarioAListaListaString())); //bistaratutako taula freskatzeko
							JOptionPane.showMessageDialog(
									taula, ExternalTextVI.methodProductAmountUpdated(kodea, Integer.parseInt(kopBerria))
									/*kodea
									+ " kodeko produktuaren kopurua eguneratu egin da ("
									+ kopBerria + ")."*/
									);
						} catch (super4.ProductoInexistente e1) {
							System.err.println(ExternalTextVI.methodProductCodeError(kodea)//"Ez da aurkitu inbentarioa "
									//+ kodea + " kodeko produkturik."
									); //***
						} catch (Exception e1) {
							System.err.println(ExternalTextVI.MESSAGE_UPDATING_ERROR);//"Erroreren bat gertatu da kopurua eguneratzerakoan.");
						}
					}
				}
			}
		});

		mnuProdEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int erantzuna = JOptionPane.YES_OPTION;
				int kodea = 
						Integer.parseInt(taula.getModel().
								getValueAt(taula.getSelectedRow(), 0).toString()); //hautatutako errenkadako kodea
				erantzuna = JOptionPane.showConfirmDialog (
						null, 
						ExternalTextVI.methodProductDelete(kodea),//kodea + " kodeko produktua ezabatzera zoaz: ziur zaude?",
						ExternalTextVI.QUESTION,//"Super Online - Produktua ezabatu, baieztapena",
						JOptionPane.YES_NO_OPTION);
				
				Inventario inb = Inventario.getInventario();
				
				if (erantzuna == JOptionPane.YES_OPTION) {
					try {
						// kode bidezko ezabaketa:
						inb.eliminarProducto(kodea);
						taula.setModel(new ProduktuTaulaModelo(inb.inventarioAListaListaString())); //bistaratutako taula freskatzeko
						JOptionPane.showMessageDialog(taula, ExternalTextVI.methodProductDeleted(kodea)
								//kodea	+ " kodeko produktua ezabatu da."
								);
					} catch (super4.ProductoInexistente p) {
						System.err.println(ExternalTextVI.methodProductCodeError(kodea));
						//"Ez da aurkitu inbentarioa " + kodea
							//	+ " kodeko produkturik."); //***
					}
				}
			}
		});

		testuingurukoMenua.add(mnuKopEguneratu);
		testuingurukoMenua.add(mnuProdEzabatu);
		taula.setComponentPopupMenu(testuingurukoMenua);

		getContentPane().add(new JScrollPane( taula ));
		//taula.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		lblBehekoOharra = new JLabel(ExternalTextVI.MESSAGE_NOTICE);
				/*"Oharra: Hautatutako produktua ezabatzeko edo kopurua eguneratzeko," +
				" jo testuinguruko menura saguaren botoi lagungarria (eskuina, normalean) sakatuz.");*/
		getContentPane().add(lblBehekoOharra);
		this.pack();
	}

}

package gui;

import productos.*;
import super4.Inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanSuperOnLine extends JFrame {

    JButton btnInbKargatu, btnInbBistaratu, btnProdBidalgTxostenaSortu, btnInbGorde, btnProdGehitu, btnIrten;
    private JLabel izenburukoEtiketa;
    private JOptionPane oharra;
    private JDialog oharLeihoa;

    public VentanSuperOnLine() {

        this.setTitle(ExternalTextVS.MAIN);//"Super Online - Leiho nagusia");
        //this.setSize( 1200, 5000);
        //setLayout();
        this.getContentPane().setLayout(
                new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));


        // menu-barra sortu eta markoan gehitu
        JMenuBar menuBarra = new JMenuBar();
        this.setJMenuBar(menuBarra);

        // Drop down menua sortu eta menu-barrari egokitu
        JMenu menuNagusia = new JMenu(ExternalTextVS.MENU);
        //JMenu editMenu = new JMenu("Edit");
        menuBarra.add(menuNagusia);
        //menuBarra.add(editMenu);


        izenburukoEtiketa = new JLabel(ExternalTextVS.SUPER);
        izenburukoEtiketa.setFont(new Font("Arial", 1, 18));
        //izenburukoEtiketa.setSize(new Dimension (2000, 2000));
        //testuNagusia.setBounds(3000, 300, 390, 10);
        izenburukoEtiketa.setAlignmentX(CENTER_ALIGNMENT);
        //izenburukoEtiketa.setAlignmentY(TOP_ALIGNMENT);
        this.add(izenburukoEtiketa);


        // Menu nagusia sortu:
        JMenuItem mnuInbKargatu = new JMenuItem(ExternalTextVS.LOAD_INVENTORY);
        JMenuItem mnuInbBistaratu = new JMenuItem(ExternalTextVS.SHOW_INVENTORY);
        JMenuItem mnuProdGehitu = new JMenuItem(ExternalTextVS.ADD_PRODUCT);
        JMenuItem mnuProdBidalgTxostenaSortu = new JMenuItem(ExternalTextVS.SHOW_SHIPPING_PRODUCT);
        JMenuItem mnuInbGorde = new JMenuItem(ExternalTextVS.SAVE_INVENTORY);
        JMenuItem mnuIrten = new JMenuItem(ExternalTextVS.LEAVE);

        menuNagusia.add(mnuInbKargatu);
        menuNagusia.add(mnuInbBistaratu);
        menuNagusia.add(mnuInbGorde);
        menuNagusia.add(mnuIrten);
        menuNagusia.addSeparator();
        menuNagusia.add(mnuProdGehitu);
        menuNagusia.add(mnuProdBidalgTxostenaSortu);


        // Botoi nagusiak sortu:
        btnInbKargatu = new JButton(ExternalTextVS.LOAD_INVENTORY);
        this.add(btnInbKargatu);
        btnInbBistaratu = new JButton(ExternalTextVS.SHOW_INVENTORY);
        this.add(btnInbBistaratu);
        btnProdBidalgTxostenaSortu = new JButton(ExternalTextVS.SHOW_SHIPPING_PRODUCT);
        this.add(btnProdBidalgTxostenaSortu);
        btnInbGorde = new JButton(ExternalTextVS.SAVE_INVENTORY);
        this.add(btnInbGorde);
        btnProdGehitu = new JButton(ExternalTextVS.ADD_PRODUCT);
        this.add(btnProdGehitu);
        btnIrten = new JButton(ExternalTextVS.LEAVE);
        this.add(btnIrten);

        this.pack();


        // menuko aukerei eta botoiei erantzuteko ekintzak definitu:

        //		mnuKargatu.addActionListener(new ActionListener() {
        ActionListener actInbKargatu = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int erantzuna = JOptionPane.YES_OPTION;
                Inventario inb = Inventario.getInstance();
                if (inb.estaCargado()) { //kontuz, inbentarioa lehendik kargatuta dago-eta...
                    erantzuna = JOptionPane.showConfirmDialog(
                            null,
                            ExternalTextVS.MESSAGE_RELOAD_INVENTORY,//"Inbentarioa fitxategitik kargatuz gero, gorde gabeko aldaketa guztiak galduko dira. Aurrera egingo?",
                            ExternalTextVS.QUESTION, //"Super Online - Inbentarioa kargatu, baieztapena",
                            JOptionPane.YES_NO_OPTION);
                }

                if (erantzuna == JOptionPane.YES_OPTION) {
                    inb.cargarProductosDelFichero();
                    //JOptionPane.showMessageDialog((Component)(arg0.getSource()), "Kargatu da inbentarioa fitxategitik.");
                    //JOptionPane.showMessageDialog(null, "Kargatu da inbentarioa fitxategitik.");
                    oharra = new JOptionPane(ExternalTextVS.UPLOAD,//"Kargatu da inbentarioa fitxategitik.",
                            JOptionPane.INFORMATION_MESSAGE);
                    oharLeihoa = oharra.createDialog(ExternalTextVS.INFO);//"Super Online - Info");
                    oharLeihoa.setAlwaysOnTop(true);
                    oharLeihoa.setVisible(true);
                }
            }

        };

        //		mnuInbBistaratu.addActionListener(new ActionListener() {
        ActionListener actInbBistaratu = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Inventario inb = Inventario.getInstance();
                if (!inb.estaCargado()) {
                    oharra = new JOptionPane(ExternalTextVS.MESSAGE_BEFORE_VISUALIZING,
                            JOptionPane.WARNING_MESSAGE);
                    oharLeihoa = oharra.createDialog(ExternalTextVS.WARNING);
                    oharLeihoa.setAlwaysOnTop(true);
                    oharLeihoa.setVisible(true);
                } else {
                    try {
                        VentanaInventario inbLeihoa = new VentanaInventario(inb.inventarioAListaString());
                        inbLeihoa.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        inbLeihoa.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //		mnuInbGorde.addActionListener(new ActionListener() {
        ActionListener actInbGorde = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Inventario inb = Inventario.getInstance();
                if (!inb.estaCargado()) {
                    oharra = new JOptionPane(ExternalTextVS.MESSAGE_LOAD_EARLIER,//"Inbentarioa gorde ahal izateko, lehenago kargatu egin behar da.",
                            JOptionPane.WARNING_MESSAGE);
                    oharLeihoa = oharra.createDialog(ExternalTextVS.WARNING);//"Super Online - Oharra");
                    oharLeihoa.setAlwaysOnTop(true);
                    oharLeihoa.setVisible(true);
                } else {
                    inb.guardarProductosEnFichero();
                    //					JOptionPane.showMessageDialog((Component)(arg0.getSource()), "Gorde da inbentario eguneratua fitxategian.");
                    //					JOptionPane.showMessageDialog(null, "Gorde da inbentario eguneratua fitxategian.");
                    oharra = new JOptionPane(ExternalTextVS.MESSAGE_SAVE_INVENTORY,//"Gorde da inbentario eguneratua fitxategian.",
                            JOptionPane.INFORMATION_MESSAGE);
                    JDialog oharLeihoa = oharra.createDialog(ExternalTextVS.INFO);//"Super Online - Info");
                    oharLeihoa.setAlwaysOnTop(true);
                    oharLeihoa.setVisible(true);
                }
            }
        };

        //		mnuIrten.addActionListener(new ActionListener() {
        ActionListener actIrten = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //System.out.println("Agur, hurrena arte.");
                //				JOptionPane.showMessageDialog((Component)(arg0.getSource()), "Agur, hurrena arte.");
                oharra = new JOptionPane(ExternalTextVS.MESSAGE_GOODBYE, //"Agur, hurrena arte.",
                        JOptionPane.INFORMATION_MESSAGE);
                oharLeihoa = oharra.createDialog(ExternalTextVS.BYE);//"Super Online - Agurra");
                oharLeihoa.setAlwaysOnTop(true);
                oharLeihoa.setVisible(true);
                System.exit(0);
            }
        };

        //		mnuProdGehitu.addActionListener(new ActionListener() {
        ActionListener actProdGehitu = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Inventario inb = Inventario.getInstance();
                if (!inb.estaCargado()) {
                    oharra = new JOptionPane(ExternalTextVS.MESSAGE_BEFORE_ADDING,//"Produktu bat gehitu aurretik inbentarioa kargatu behar da.",
                            JOptionPane.WARNING_MESSAGE);
                    oharLeihoa = oharra.createDialog(ExternalTextVS.WARNING);//"Super Online - Oharra");
                    oharLeihoa.setAlwaysOnTop(true);
                    oharLeihoa.setVisible(true);
                } else {
                    try {
                        VentanaProducto dlgProduktua = new VentanaProducto();
                        dlgProduktua.setModal(true);
                        dlgProduktua.setVisible(true);

                        if (dlgProduktua.pulsadoGuardar()) {
                            //produktua eraiki eta gehitu inbentarioan, motaren arabera:
                            int kodea = inb.getCodigoParaNuevoProducto();
                            Producto p = new Otro();

                            String tipo = dlgProduktua.getTipoProducto().replace(" ", "");

                            switch (tipo) {
                                case "Bebida":
                                    p = new Bebida(
                                            kodea,
                                            dlgProduktua.getTxtNombre(),
                                            dlgProduktua.getTxtCantidad(),
                                            dlgProduktua.getTxtPrecio(),
                                            dlgProduktua.getTxtPeso(),
                                            dlgProduktua.getTxtFechaCaducidad(),
                                            dlgProduktua.getTxtGraduacion());
                                    inb.incluirNuevoProducto(p);
                                    break;
                                case "Lacteo":
                                    p = new Lacteo(
                                            kodea,
                                            dlgProduktua.getTxtNombre(),
                                            dlgProduktua.getTxtCantidad(),
                                            dlgProduktua.getTxtPrecio(),
                                            dlgProduktua.getTxtPeso(),
                                            dlgProduktua.getTxtFechaCaducidad(),
                                            dlgProduktua.getTxtLote());
                                    inb.incluirNuevoProducto(p);
                                    break;
                                case "Herramienta":
                                    p = new Herramienta(
                                            kodea,
                                            dlgProduktua.getTxtNombre(),
                                            dlgProduktua.getTxtCantidad(),
                                            dlgProduktua.getTxtPrecio(),
                                            dlgProduktua.getTxtPeso(),
                                            dlgProduktua.getTxtCategoria());
                                    inb.incluirNuevoProducto(p);
                                    break;
                                case "FrutayHortaliza":
                                    p = new FrutaYHortaliza(
                                            kodea,
                                            dlgProduktua.getTxtNombre(),
                                            dlgProduktua.getTxtCantidad(),
                                            dlgProduktua.getTxtPrecio(),
                                            dlgProduktua.getTxtPeso(),
                                            dlgProduktua.getTxtFechaCaducidad(),
                                            dlgProduktua.getTxtOrigen());
                                    inb.incluirNuevoProducto(p);
                                    break;
                                case "Otro":
                                    p = new Otro(
                                            kodea,
                                            dlgProduktua.getTxtNombre(),
                                            dlgProduktua.getTxtCantidad(),
                                            dlgProduktua.getTxtPrecio(),
                                            dlgProduktua.getTxtPeso(),
                                            dlgProduktua.getTxtCategoria());
                                    inb.incluirNuevoProducto(p);
                                    break;
                                default:
                                    System.out.println("Tipo " + dlgProduktua.getTipoProducto() + " desconocido.");
                                    break;
                            }
                            JOptionPane.showMessageDialog(dlgProduktua, ExternalTextVS.ADDED + p.getCodigoProducto() + ".");//" kodeko produktua gehitu da."//ExternalTextLN.ADDED
                        }
                        dlgProduktua.dispose(); //'Ados' zein 'Utzi' sakatu
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        };

        //		actProdBidalgTxostenaSortu.addActionListener(new ActionListener() {
        ActionListener actProdBidalgTxostenaSortu = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Inventario inb = Inventario.getInstance();
                if (!inb.estaCargado()) {
                    oharra = new JOptionPane(ExternalTextVS.MESSAGE_BEFORE_REPORT,//"Produktu bidalgarrien txostena sortu ahal izateko, lehenago inbentarioa kargatu egin behar da.",
                            JOptionPane.WARNING_MESSAGE);
                    oharLeihoa = oharra.createDialog(ExternalTextVS.WARNING);//"Super Online - Oharra");
                    oharLeihoa.setAlwaysOnTop(true);
                    oharLeihoa.setVisible(true);
                } else {
                    inb.crearInformeProductosEnviables();
                }
            }
        };


        //menu-aukerak eta botoiak ekintza berberen bidez erantzun dezaten prestatu:
        mnuInbKargatu.addActionListener(actInbKargatu);
        btnInbKargatu.addActionListener(actInbKargatu);

        mnuInbBistaratu.addActionListener(actInbBistaratu);
        btnInbBistaratu.addActionListener(actInbBistaratu);

        mnuProdBidalgTxostenaSortu.addActionListener(actProdBidalgTxostenaSortu);
        btnProdBidalgTxostenaSortu.addActionListener(actProdBidalgTxostenaSortu);

        mnuInbGorde.addActionListener(actInbGorde);
        btnInbGorde.addActionListener(actInbGorde);

        mnuProdGehitu.addActionListener(actProdGehitu);
        btnProdGehitu.addActionListener(actProdGehitu);

        mnuIrten.addActionListener(actIrten);
        btnIrten.addActionListener(actIrten);

    }

}

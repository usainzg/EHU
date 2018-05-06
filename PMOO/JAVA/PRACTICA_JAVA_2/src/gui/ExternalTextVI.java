package gui;

/**
 * @author PMOO 2018
 *
 */
public class ExternalTextVI {
	final static String TITLE="Super4 on-line - INVENTARIO";//""Super4 on-line - Inbentarioa";
	final static String UPDATE_AMOUNT="Actualizar cantidad";//"Kopurua eguneratu"
	final static String DELETE_PRODUCT= "Eliminar producto";// "Produktua ezabatu"
	final static String VALIDATION_ERROR="Super4 on-line - Validación errónea";//"Super4 on-line - Balidazio-errorea"
	final static String QUESTION="Super4 on-line - PREGUNTA";//"Super4 on-line - Galdera"
	
	// LABEL
	final static String CODE="Codigo";//"Kodea"
	final static String NAME="Nombre";//"Izena"
	final static String PRICE="Precio";//"Prezioa"
	final static String PRICE_VAT="Precio (con IVA)";//"Prezioa (BEZarekin)"
	final static String EXPIRATIONDATE="Fecha-caducidad";//"Iraungitze-data"
	final static String VAT="IVA";//"BEZa"
	final static String AMOUNT="Cantidad";//"Kopurua"
	final static String WEIGHT="Peso";//"Pisua"
	final static String OTHERS="Otros";//"Bestelakoak"
	final static String INVENTORY="Inventario";//"Inbentarioa"
	
	
	// BUTTON
	final static String CLEAR="LIMPIAR";//"Garbitu"
	
	// MESSAGE
	final static String MESSAGE_UPDATING_ERROR="Se ha producido un error al actualizar la cantidad del producto.";//""Erroreren bat gertatu da kopurua eguneratzerakoan.""
	final static String MESSAGE_NOTICE="NOTA. Para eliminar o actualizar la cantidad de un producto, sitúese con el ratón sobre dicho producto, pulse el botón derecho y seleccione funcionalidad ";//Oharra: Hautatutako produktua ezabatzeko edo kopurua eguneratzeko jo testuinguruko menura saguaren botoi lagungarria (eskuina, normalean) sakatuz.";

			
			//METHODS
	public static String methodProductAmountUpdate(int kodea, int oraingoKop)
	{	return  "Indique en el cuadro inferior la cantidad del producto de código " + kodea+ " (actualmente hay "+ oraingoKop+ " unidades).";
		/*"Sartu hemen behean " + 
				kodea + 
				" kodeko produktuaren kopuru berria (oraintxe " + 
				oraingoKop +		
		" unitate daude).";*/
	}
	
	public static String methodProductAmountError(int kodea, int oraingoKop) {
	return "La cantidad debe ser un valor numérico entero; inténtelo de nuevo (código de producto: " +
			kodea+ 	
			"; cantidad actual: "+
			oraingoKop
			+")!";
			/*"Kopuruak zenbaki osoa izan behar du; saiatu berriz (produktuaren kodea: " + 
	kodea +
	"; oraingo kopurua: " +
	oraingoKop +
	")!";*/
	}
	
	public static String methodProductAmountUpdated(int kodea, int oraingoKop) {
		return "Se ha actualizado la cantidad del producto de código "+ 
				kodea+ " con " + oraingoKop + " unidades.";
	/*kodea
	+ " kodeko produktuaren kopurua eguneratu egin da ("
	+ kopBerria + ")."*/
	}
	
	public static String methodProductCodeError(int kodea) {
		return "No se ha encontrado en el inventario el producto de código "+ kodea+ ".";
	/*"Ez da aurkitu inbentarioa "
	+ kodea + " kodeko produkturik."*/
	}
	
	public static String methodProductDelete(int kodea) {
		return "¿Está seguro de querer eliminar el producto de código "+ kodea+ "?";
	/*kodea + " kodeko produktua ezabatzera zoaz: ziur zaude?",*/
	}

	public static String methodProductDeleted(int kodea) {
		return "Se ha eliminado el producto de código "+ kodea+ ".";
	/*kodea+ " kodeko produktua ezabatu da.",*/
	}
}

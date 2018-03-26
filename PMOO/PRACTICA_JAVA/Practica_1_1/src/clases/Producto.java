package clases;

/**
 * @author PMOO 2018:
 *
 */

public class Producto {
	
	private final double IVA_PRODUCTO = 0.21;

	private int codigoProducto;
	private String nombreProducto;
	private int cantidadProducto;
	private double precioProducto;
	private double pesoProducto;

    /**
     * Constructor por defecto, no inicializa
     */
    Producto() {
    }

    /**
     * Constructor que setea solo el nombre
     * @param nombre string
     */
    public Producto(String nombre) {
        this.nombreProducto = nombre;
    }

    /**
     * Constructor que setea todos los atributos
     * @param codigoProducto int
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     */
    public Producto(int codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto,
                    double pesoProducto) {
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioProducto = precioProducto;
		this.pesoProducto = pesoProducto;
	}

    /**
     * Constructor que setea todos los atributos menos el codigo
     * @param nombreProducto string
     * @param cantidadProducto int
     * @param precioProducto double
     * @param pesoProducto double
     */
    public Producto(String nombreProducto, int cantidadProducto, double precioProducto, double pesoProducto) {
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.pesoProducto = pesoProducto;
    }

    /**
     * Imprime el producto formato "normal"
     */
    public void imprimirProducto() {
		System.out.println("--Codigo--\t--Nombre--\t--Cantidad--\t--Precio--\t--PrecioIVA--");
		System.out.println(this.codigoProducto + "\t\t" + this.nombreProducto + "\t\t" + this.cantidadProducto + "\t\t\t" +
				+ this.precioProducto + "\t\t" +
				+ this.precioConIva());
	}

    /**
     * Imprime el producto, formato "enviable"
     */
	public void imprimirEnviable() {
		System.out.println("--Codigo--\t--Nombre--\t--Peso--\t--Precio--");
		System.out.println(this.codigoProducto + "\t\t" + this.nombreProducto + "\t\t" + this.pesoProducto + "\t\t" +
				+ this.precioProducto);
	}
	
	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public double getPrecioProducto() {
		return precioProducto;
	}


	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}


	public double getPesoProducto() {
		return pesoProducto;
	}


	public void setPesoProducto(double pesoProducto) {
		this.pesoProducto = pesoProducto;
	}
	
	public double getIVA() {
		return this.IVA_PRODUCTO;
	}

    /**
     * Devuelve el precio con el iva anadido
     * @return double
     */
	private double precioConIva() {
		return this.precioProducto * (1 + IVA_PRODUCTO);
	}

	@Override
	public String toString() {
		return codigoProducto + " " + nombreProducto
				+ " " + cantidadProducto + " " + precioProducto + " "
				+ pesoProducto + " ";
	}

}

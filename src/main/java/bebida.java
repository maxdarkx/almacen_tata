public class bebida
{
    private String id;
    private Float cantidadProducto; //cantidad de producto, en litros
    private Float precio;
    private String marca;
    private Integer estante;    //En que parte del almacen esta ubicada la bebida?

    public String getId() {
        return id;
    }

    public Float getCantidadProducto() {
        return cantidadProducto;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getEstante() {
        return estante;
    }

    public bebida(String id, Float cantidadProducto, Float precio, String marca, Integer estante) {
        this.id = id;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.marca = marca;
        this.estante = estante;
    }

    public String mostrarProducto()
    {
        String text = "[id:"+this.id+ ", Producto: Bebida, Cantidad: "+this.cantidadProducto.toString() +
                ", Precio: "+this.precio.toString()+ ", Marca: "+ this.marca+ ", Estante: "+this.estante.toString()+"]\n";
        System.out.print(text);
        return text;
    }

}

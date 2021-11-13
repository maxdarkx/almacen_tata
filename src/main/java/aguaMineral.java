public class aguaMineral extends bebida
{
    private String origen;

    public aguaMineral(String id, Float cantidadProducto, Float precio, String marca, Integer estante, String origen) {
        super(id, cantidadProducto, precio, marca, estante);
        this.origen = origen;
    }

    @Override
    public String mostrarProducto()
    {
        String text = "[id:"+super.getId()+ ", Producto: Agua Mineral, Cantidad: "+super.getCantidadProducto().toString() +
                ", Precio: "+super.getPrecio().toString()+ ", Marca: "+ super.getMarca().toString()+", Origen: "+this.origen+ ", Estante: "+super.getEstante().toString()+"]\n";
        System.out.print(text);
        return text;
    }
}

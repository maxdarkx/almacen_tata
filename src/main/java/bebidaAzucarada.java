public class bebidaAzucarada extends bebida
{
    private Float porcentajeAzucar;
    private Boolean promocion;

    public bebidaAzucarada(String id, Float cantidadProducto, Float precio, String marca, Integer estante, Float porcentajeAzucar, Boolean promocion) {
        super(id, cantidadProducto, precio, marca, estante);
        this.porcentajeAzucar = porcentajeAzucar;
        this.promocion = promocion;
    }

    @Override
    public String mostrarProducto()
    {
        String text = "[id:"+super.getId()+ ", Producto: Bebida Azucarada, Cantidad: "+super.getCantidadProducto().toString() +
                ", Precio: "+super.getPrecio().toString()+ ", Marca: "+ super.getMarca().toString()+
                ", Porcentaje de Azucar: "+this.porcentajeAzucar+", Estante: "+super.getEstante().toString()+"]\n";
        System.out.print(text);
        return text;
    }
    @Override
    public Float getPrecio()
    {
        if(this.promocion)
        {
            return super.getPrecio()*0.9F;
        }
        else
        {
            return super.getPrecio();
        }

    }
}

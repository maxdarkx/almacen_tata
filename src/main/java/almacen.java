import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class almacen
{
    public static int testError()
    {
        Integer op;
        Scanner key = new Scanner(System.in);

        try {
            op = Integer.parseInt(key.nextLine());
            return op;
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public static Float testErrorFloat()
    {
        Float cant;
        Scanner key = new Scanner(System.in);

        try {
            cant = Float.parseFloat(key.nextLine());
            return cant;
        }
        catch (NumberFormatException e)
        {
            return 0F;
        }
    }

    public static String getText()
    {
        Scanner key = new Scanner(System.in);
        return key.nextLine();
    }

    public static Integer menu()
    {
        System.out.println("\n1. Agregar producto");
        System.out.println("2. Ver los productos ingresados (y guardarlos en un archivo)");
        System.out.println("3. Eliminar un producto");
        System.out.println("4. Calcular el precio de todos los productos ingresados");
        System.out.println("5. Calcular el precio de los productos de una marca");
        System.out.println("6. Calcular el precio de los productos de un estante");
        System.out.println("7. Finalizar el programa");
        System.out.print("Ingrese su opcion: ");

        return testError();
    }

    public static void agregarProducto(ArrayList<bebida> listaProductos)
    {
        int tipo = 0;
        int marca = 0;
        String marcaString = "";
        int estante = 0;
        float cantidad = 0;
        float precio = 0;
        bebida item;
        //bebidaAzucarada gaseosa;
        //aguaMineral agua;
        Boolean error = false;
        String id = "";

        System.out.println("Tipo de producto a ingresar:");
        System.out.println("1. Agua Mineral");
        System.out.println("2. Bebida Azucarada");
        System.out.print("Ingrese su opcion: ");
        tipo = testError();
        switch (tipo)
        {
            case (1):
                break;
            case (2):
                break;
            default:
                System.out.println("Ha ingresado un valor incorrecto, intentelo de nuevo");
                error = true;
                break;
        }

        if(!error) {
            System.out.println("Marca del producto a ingresar:");
            System.out.println("1. Coca-Cola");
            System.out.println("2. Pepsi-Cola");
            System.out.println("3. Postobon");
            System.out.print("Ingrese su opcion: ");
            marca = testError();
            switch (marca) {
                case (1):
                    marcaString = "Coca-Cola";
                    break;
                case (2):
                    marcaString = "Pepsi-Cola";
                    break;
                case (3):
                    marcaString = "Postobon";
                    break;
                default:
                    System.out.println("Ha ingresado un valor incorrecto, intentelo de nuevo");
                    error = true;
                    break;
            }
        }

        if(!error) {
            System.out.println("Ingrese el id del producto");
            id = getText();


            System.out.println("Ingrese la cantidad del producto");
            cantidad = testErrorFloat();
            if(cantidad <= 0F )
            {
                System.out.println("Ha ingresado una cantidad no permitida");
                error = true;
            }
        }

        if(!error) {
            System.out.println("Ingrese el precio del producto");
            precio = testErrorFloat();
            if(precio <= 0F)
            {
                System.out.println("Ha ingresado un precio no permitida");
                error = true;
            }
        }

        if(!error)
        {
            System.out.println("Ingrese la ubicacion del producto (Estante 0 - 10)");
            estante = testError();
            if(estante < 0 || estante > 10)
            {
                System.out.println("Ha ingresado un estante no permitido");
                error = true;
            }
        }
        if(!error)
        {
            switch (tipo)
            {
                case(1):
                    item = new aguaMineral(id, cantidad,precio,marcaString,estante,"Natural");
                    break;
                case(2):
                    item = new bebidaAzucarada(id,cantidad,precio,marcaString,estante,10F,false);
                    break;
                default:
                    item = new bebida(id,cantidad,precio,marcaString,estante);

            }
            listaProductos.add(item);
            if(!listaProductos.isEmpty())
            {
                listaProductos.get(listaProductos.size()-1).mostrarProducto();
            }
        }
    }


    public static void mostrarProductos(ArrayList<bebida> listaProductos)
    {
        String contenido = "";
        Iterator <bebida> it = listaProductos.iterator();

        while (it.hasNext())
        {
            contenido= contenido + it.next().mostrarProducto();
        }
        guardarArchivo("Operacines.txt", contenido);
    }

    public static void guardarArchivo(String nombreArchivo, String contenido)
    {
        try {
            String ruta = nombreArchivo;
            File file = new File(ruta);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Boolean eliminarProducto(ArrayList<bebida> listaProductos) {
        String eliminaId = "";
        Boolean encontrado = false;

        System.out.println("Ingrese el id del producto a eliminar");
        eliminaId = getText();

        for (int i = 0; i< listaProductos.size(); i++)
        {
            if(listaProductos.get(i).getId().equals(eliminaId))
            {
                listaProductos.remove(i);
                encontrado = true;
                System.out.println("Se ha eliminado el elemento con id "+eliminaId);
            }
        }
        if(!encontrado)
        {
            System.out.println("No se ha encontrado ningun producto con el Id: "+eliminaId);
        }

        return encontrado;
    }


    private static void calcularPrecioTotal(ArrayList<bebida> listaProductos) {
        Iterator <bebida> it = listaProductos.iterator();
        Float total = 0F;

        while (it.hasNext())
        {
            total += it.next().getPrecio();
        }
        System.out.println("El valor total del Almacen es: "+total);
    }

    private static void calcularPrecioMarca(ArrayList<bebida> listaProductos) {
        Float totalMarca = 0F;
        bebida item;
        int marcaOpcion= 0;
        String marcaPedida = "";
        Boolean error = false;
        Iterator <bebida> it = listaProductos.iterator();

        System.out.println("Ingrese la Marca de los productos a calcular:");
        System.out.println("1. Coca-Cola");
        System.out.println("2. Pepsi-Cola");
        System.out.println("3. Postobon");
        System.out.print("Ingrese su opcion: ");
        marcaOpcion = testError();

        switch (marcaOpcion)
        {
            case (1):
                marcaPedida = "Coca-Cola";
                break;
            case (2):
                marcaPedida = "Pepsi-Cola";
                break;
            case (3):
                marcaPedida = "Postobon";
                break;
            default:
                System.out.println("Ha ingresado una marca inexistente");
                error = true;
                break;
        }

        if(!error) {

            while (it.hasNext()) {
                item = it.next();
                if (item.getMarca() == marcaPedida) {
                    totalMarca += item.getPrecio();
                }
            }
            System.out.println("El valor total de la marca "+marcaPedida+" fue de: "+totalMarca);
        }
    }

    public static void calcularPrecioEstante(ArrayList<bebida> listaProductos) {

        int estante = 0;
        Float totalEstante = 0F;
        bebida item;
        Iterator <bebida> it = listaProductos.iterator();


        System.out.println("Ingrese el estante a calcular el valor (0 - 10): ");
        estante = testError();
        if(estante < 0 || estante > 10)
        {
            System.out.println("Ha ingresado un estante no permitido");
        }
        else
        {
            while (it.hasNext())
            {
                item = it.next();
                if(item.getEstante() == estante)
                {
                    totalEstante += item.getPrecio();
                }
            }
            System.out.println("El valor total del estante "+estante+" fue de: "+totalEstante);
        }
    }


    public static void main(String[] args) {
        ArrayList <bebida> listaProductos = new ArrayList<bebida>();
        Integer opcion = 0;
        do{
            opcion = menu();

            switch (opcion) {
                case (1):
                    agregarProducto(listaProductos);
                    break;
                case (2):
                    mostrarProductos(listaProductos);
                    break;
                case (3):
                    eliminarProducto(listaProductos);
                    break;
                case (4):
                    calcularPrecioTotal(listaProductos);
                    break;
                case (5):
                    calcularPrecioMarca(listaProductos);
                    break;
                case(6):
                    calcularPrecioEstante(listaProductos);
                    break;
                case (7):
                    System.out.println("Gracias por utilizar el programa. Hasta luego...");
                    break;
                default:
                    System.out.println("Ha seleccionado una opcion incorrecta, intentelo nuevamente");
                    break;
            }
        }while(opcion != 7);
    }
}

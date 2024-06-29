import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner tipeo=new Scanner(System.in);
        System.out.println("*********************************");
        System.out.println("Hola!");
        System.out.println("He aqui el conversor de monedas : ");
        System.out.println("Por favor, ingrese el tipo de conversion [1-5] que desea realizar :  \n 1) Dolar --> Peso argentino \n 2) Peso argentino --> Dolar \n 3) Real brasileño --> Peso argentino \n 4) Peso argentino --> Real brasileño \n 5) Peso chileno --> Peso argentino \n 6) Peso argentino --> Peso chileno");

        ConsultaApi consulta=new ConsultaApi();
        try {
            var moneda= tipeo.nextLine();
            String tipoMoneda = consulta.filtradoDeMonedas(moneda);
            System.out.println(tipoMoneda);
            //GeneradorDeArchivo generador=new GeneradorDeArchivo();
            //generador.guardarJson(conversion);
        } catch (NumberFormatException e ){
            System.out.println("Moneda no encontrada "+ e.getMessage());
        }catch (RuntimeException | IOException e ){
            System.out.println(e.getMessage());
            System.out.println("Es todo por hoy. Chau");
        }
       //

        //consulta.filtradoDeMonedas(moneda);

// AGREGAR EL WHILE EN BASE A LA RESPUESTA DE USUARIO!!!



        //var moneda= tipeo.nextLine();



       // TipoMoneda monedas = consulta.listadoDeMonedas(moneda);

        //System.out.println(monedas);



        System.out.println("*********************************");
    }
}

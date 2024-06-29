import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner tipeo=new Scanner(System.in);
        ConsultaApi consulta=new ConsultaApi();
        while(true ){
        System.out.println("*********************************");
        System.out.println("Hola!");
        System.out.println("He aqui el conversor de monedas : ");
        System.out.println("Por favor, ingrese el tipo de conversion [1-6] que desea realizar :  \n 1) Dolar --> Peso argentino \n 2) Peso argentino --> Dolar \n 3) Real brasileño --> Peso argentino \n 4) Peso argentino --> Real brasileño \n 5) Peso chileno --> Peso argentino \n 6) Peso argentino --> Peso chileno \n 7) SALIR");
        System.out.println("*********************************");

        try {
            var moneda= tipeo.nextInt();
            if(moneda==7){
                break;
            }
            String monedaBase="";
            String monedaAConvertir="";
                    switch (moneda) {
                        case 1:
                            monedaBase = "USD";
                            monedaAConvertir = "ARS";
                            break;
                        case 2:
                            monedaBase = "ARS";
                            monedaAConvertir = "USD";
                            break;
                        case 3:
                            monedaBase = "BRL";
                            monedaAConvertir = "ARS";
                            break;
                        case 4:
                            monedaBase = "ARS";
                            monedaAConvertir = "BRL";
                            break;
                        case 5:
                            monedaBase = "CLP";
                            monedaAConvertir = "ARS";
                            break;
                        case 6:
                            monedaBase = "ARS";
                            monedaAConvertir = "CLP";
                            break;
                        default:
                            System.out.println("Opción inválida. Intente nuevamente.");
                            continue;
                    }
            System.out.println("Ingrese el valor a convertir");
                    double valor=tipeo.nextDouble();
                    String resultadoJson=consulta.conversorMonedas(monedaBase,monedaAConvertir, valor);

        }catch (NumberFormatException e ){
            System.out.println("Moneda no encontrada "+ e.getMessage());;
        }catch (RuntimeException | IOException e ){
            System.out.println("Detalle del error : " +e.getMessage());
            System.out.println("Ingrese unicamente caracteres numericos.");
            break;
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
            System.out.println("Es todo por hoy. Chau");
        }
        System.out.println("Gracias! vuelva prontos!");
        System.out.println("*********************************");
    }
}}

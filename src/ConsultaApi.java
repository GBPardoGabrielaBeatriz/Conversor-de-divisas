import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaApi {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
   // URI direccion =URI.create("https://v6.exchangerate-api.com/v6/3a2f028ea828cddab20b7952/latest/USD");
    //URI direccion =URI.create("https://v6.exchangerate-api.com/v6/3a2f028ea828cddab20b7952/latest/" + moneda);
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3a2f028ea828cddab20b7952/pair/EUR/GBP");

    //HAY QUE HACER UN SWITCH EN DONDE EN CADA CASE, LAS DOS VARIABLES DE INGRESO QUE EL USUARIO DEBE ELEGIR, SE AUTOCOMPLETAN EN LA DIRECCION
    public String filtradoDeMonedas(String moneda) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

       /* try {
            TipoMoneda tipoMoneda = gson.fromJson(json, TipoMoneda.class);
            String tipoMonedasJson = gson.toJson(tipoMoneda);
            System.out.println(tipoMonedasJson);
            return tipoMonedasJson;
        } catch (Exception e) {
            System.err.println("Error al parsear el JSON: " + e.getMessage());
            throw e;
        }

        */

        TipoMoneda tipoMoneda = gson.fromJson(json, TipoMoneda.class);
        System.out.println(tipoMoneda);
        return gson.toJson(json,TipoMoneda.class);


        //return new Gson().fromJson(response.body(), TipoMoneda.class);

        // } catch (Exception e) {
        //   throw new RuntimeException("Algo ha pasado.");
        //}

        //YA TRAJIMOS LOS DATOS, AHORA VAMOS A MAPEARLOS.
       // TipoMoneda tipoMoneda1=gson.js

    }
}
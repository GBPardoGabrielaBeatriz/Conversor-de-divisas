import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ConsultaApi {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();
    public String conversorMonedas(String monedaBase, String monedaAConvertir, double valor) throws IOException, InterruptedException {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3a2f028ea828cddab20b7952/pair/"+monedaBase+"/"+monedaAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
       try {
            TipoMoneda tipoMoneda = gson.fromJson(json, TipoMoneda.class);
           double tasaConversion = Double.parseDouble(tipoMoneda.conversion_rate());
           double valorConvertido=valor * tasaConversion;
           System.out.println("*********************************");
           System.out.println("El valor de $" + valor + " " + monedaBase + " convertido a " + monedaAConvertir +" " + "nos da un total de $" + valorConvertido);

            String tipoMonedaJson=gson.toJson(tipoMoneda);
            //System.out.println(tipoMonedaJson);
            return tipoMonedaJson;
        } catch (Exception e) {
            System.err.println("Error al parsear el JSON: " + e.getMessage());
            throw e;
        }

    }
}
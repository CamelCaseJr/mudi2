package br.com.camalCase.mudi.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttpUtil {

    public static String ConectarAUmHttp(String url) throws IOException, InterruptedException {
        URI endereco = URI.create(url);
        System.out.println("Conectando em: "+ url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

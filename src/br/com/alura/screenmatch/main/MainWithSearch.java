package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.exception.ExceptionYearConversionError;
import br.com.alura.screenmatch.models.OmdbTitle;
import br.com.alura.screenmatch.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reading = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("sair")) {

            System.out.println("Digite o filme desejado: ");
            search = reading.nextLine();
            if(search.equalsIgnoreCase("sair")) {
                break;
            }

            String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=b2da5ba3";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                OmdbTitle myOmdbTitle = gson.fromJson(json, OmdbTitle.class);
                System.out.println(myOmdbTitle);
                //try {
                Title myTitle = new Title(myOmdbTitle);
                System.out.println("Título já convertido");
                System.out.println(myTitle);

                titles.add(myTitle);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço.");
            } catch (ExceptionYearConversionError e) {
                System.out.println(e.getMessage());

            }
        }
        System.out.println(titles);

        FileWriter writer = new FileWriter("filmes.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("O programa finalizou corretamente!");
    }
}

package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

import java.util.*;

public class MainWithLists {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.rate(9);
        Movie anotherMovie = new Movie("Avatar", 2023);
        anotherMovie.rate(6);
        var theMovie = new Movie("No Country For Old Man", 2007);
        theMovie.rate(10);
        Serie lost = new Serie("Lost", 2000, 10);

        List<Title> list = new LinkedList<>();
        list.add(myMovie);
        list.add(anotherMovie);
        list.add(theMovie);
        list.add(lost);
        for (Title item: list) {
            System.out.println(item);
            if (item instanceof Movie movie && movie.getRating() > 2) {
                System.out.println("Classificação " + movie.getRating());
            }
        }

        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Jaqueline");
        searchByArtist.add("Paulo");
        searchByArtist.add("Adam Sandler");
        System.out.println(searchByArtist);

        Collections.sort(searchByArtist);
        System.out.println("Depois da ordenação");
        System.out.println(searchByArtist);
        System.out.println("Lista de títulos ordenados");
        Collections.sort(list);
        System.out.println(list);

        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Ordenando por ano");
        System.out.println(list);
    }
}

package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculations.RecommendationFilter;
import br.com.alura.screenmatch.calculations.TimeCalculator;
import br.com.alura.screenmatch.models.Episode;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.setDurationInMinutes(180);

        myMovie.displayTechnicalSheet();
        myMovie.rate(8);
        myMovie.rate(5);
        myMovie.rate(10);
        System.out.println("Total de avaliações: " + myMovie.getTotalRatings());
        //System.out.println(myMovie.totalRatings);
        //System.out.println(myMovie.getAverage());

        Serie lost = new Serie("Lost", 2000, 10);
        lost.displayTechnicalSheet();
        lost.setEpisodesBySeason(10);
        lost.setMinutesByEpisode(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDurationInMinutes());

        Movie anotherMovie = new Movie("Avatar", 2023);
        anotherMovie.setDurationInMinutes(200);

        TimeCalculator calculator = new TimeCalculator();
        calculator.includes(myMovie);
        calculator.includes(anotherMovie);
        calculator.includes(lost);
        System.out.println(calculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filters(myMovie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSerie(lost);
        episode.setTotalViews(300);
        filter.filters(episode);

        var theMovie = new Movie("No Country For Old Man", 2007);
        theMovie.setDirector("Joel Coen");
        theMovie.setIncludedInThePlan(false);
        theMovie.setDurationInMinutes(122);
        theMovie.displayTechnicalSheet();

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(myMovie);
        movieList.add(anotherMovie);
        movieList.add(theMovie);
        System.out.println("Quantidade de filmes na lista: " + movieList.size());
        System.out.println("Primeiro filme: " + movieList.get(0).getName());
        System.out.println(movieList);


    }
}

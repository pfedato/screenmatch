package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.exception.ExceptionYearConversionError;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includedInThePlan;
    private double sumOfRatings;
    private int totalRatings;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(OmdbTitle myOmdbTitle) {
        this.name = myOmdbTitle.title();

        if (myOmdbTitle.year().length() > 4) {
            throw new ExceptionYearConversionError("Não consegui converter o ano " +
                    "porque tem mais de 4 caracteres.");
        }
        this.releaseYear = Integer.valueOf(myOmdbTitle.year());
        this.durationInMinutes = Integer.valueOf(myOmdbTitle.runtime().substring(0, 2));
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludedInThePlan() {
        return includedInThePlan;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public void setDurationInMinutes(int length)  {
        this.durationInMinutes = length;
    }

    public void displayTechnicalSheet(){
        System.out.println("Nome do Filme: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
    }

    public void rate(double note){
        sumOfRatings += note;
        totalRatings++;
    }

    public double getAverage(){
        return sumOfRatings / totalRatings;
    }

    @Override
    public int compareTo(Title anotherTitle) {
        return this.getName().compareTo(anotherTitle.getName());
    }

    @Override
    public String toString() {
        return "(name = "  + name +
                ", releaseYear = " + releaseYear + "," +
                " duração = " + durationInMinutes + ")";
    }
}

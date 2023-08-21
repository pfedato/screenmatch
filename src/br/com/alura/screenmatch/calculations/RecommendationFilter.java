package br.com.alura.screenmatch.calculations;

public class RecommendationFilter {

    public void filters(Rateable rateable) {
        if (rateable.getRating() >= 4) {
            System.out.println("Está entre os preferidos do momento.");
        } else if (rateable.getRating() >= 2) {
            System.out.println("Muito bem avaliado no momento.");
        } else {
            System.out.println("Coloque na sua lista para assistir depois.");
        }
    }
}

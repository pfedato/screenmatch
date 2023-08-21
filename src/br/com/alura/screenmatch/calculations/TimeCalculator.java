package br.com.alura.screenmatch.calculations;

import br.com.alura.screenmatch.models.Title;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class TimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return this.totalTime;
    }

//    public void includes(Movie m){
//        this.totalTime += m.getDurationInMinutes();
//    }
//
//    public void includes(Serie s){
//        this.totalTime += s.getDurationInMinutes();
//    }

    public void includes(Title title){
        System.out.println("Adicionando duração em minutos de " + title);;
        this.totalTime += title.getDurationInMinutes();
    }
}

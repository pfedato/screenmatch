package br.com.alura.screenmatch.models;

public class Serie extends Title{
    private int seasons;
    private boolean active;
    private int episodesBySeason;
    private int minutesByEpisode;

    public Serie(String name, int releaseYear, int seasons) {
        super(name, releaseYear);
        this.seasons = seasons;
    }

    public int getSeasons() {
        return seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesBySeason() {
        return episodesBySeason;
    }

    public void setEpisodesBySeason(int episodesBySeason) {
        this.episodesBySeason = episodesBySeason;
    }

    public int getMinutesByEpisode() {
        return minutesByEpisode;
    }

    public void setMinutesByEpisode(int minutesByEpisode) {
        this.minutesByEpisode = minutesByEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return seasons * episodesBySeason * minutesByEpisode;
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + "(" + getReleaseYear() + ")";
    }
}

import java.util.*;

public class Album {
    private int id;
    private  int releaseYear;
    private  String title;
    private  Integer artistId;
    private  List<Genre> genres;

    public Album(int id, int releaseYear, String title, Integer artistId, List<Genre> genres) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artistId = artistId;
        this.genres = genres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                ", genres=" + genres +
                '}'+ '\n';
    }
}

import labwork.DatabaseLab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      try{
          var artists = new ArtistDAO(Database.getConnection());
          artists.createArtist("Ion Paladi");

          var album = new AlbumDAO(Database.getConnection());
          var genre = new GenreDAO(Database.getConnection());
          var genre1 = new Genre(1,"Crack");
          genre.createGenre("Crack");
          var genres = new ArrayList<Genre>();
          genres.add(genre1);
          var album1 = new Album(1,2015,"CrackedAlbum",1,genres);
          album.createAlbum(album1);
          System.out.println(genre.getAllGenres());

          Database.getConnection().close();
      }catch (SQLException e){
          System.err.println(e);
      }
    }
}
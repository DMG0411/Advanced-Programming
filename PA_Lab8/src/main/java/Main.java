import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
      try{
          var artists = new ArtistDAO();
          artists.create("Pink Floyd");
          artists.create("Michael Jackson");

          Database.getConnection().commit();

          Database.getConnection().close();
      }catch (SQLException e){
          System.err.println(e);
      }
    }
}
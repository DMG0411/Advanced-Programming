import java.sql.SQLException;
import java.util.*;
public interface ArtistDAOInterface {
    void createArtist(String name) throws SQLException;
    Artist getArtistById(int id);
    void updateArtist(Artist artist);
    void deleteArtist(int id);
    List<Artist> getAllArtists();
}

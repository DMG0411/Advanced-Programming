import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO implements ArtistDAOInterface {

    private final Connection connection;

    public ArtistDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createArtist(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO artists (name) VALUES (?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Artist getArtistById(int id) {
        Artist artist = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM artists WHERE id = ?"
            );
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                artist = new Artist(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artist;
    }

    @Override
    public void updateArtist(Artist artist) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE artists SET name = ? WHERE id = ?"
            );
            statement.setString(1, artist.getName());
            statement.setInt(2, artist.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArtist(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM artists WHERE id = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        ResultSet rs = null;

        try {
            Statement statement = connection.prepareStatement(
                    "SELECT * FROM artists"
            );
            rs = statement.executeQuery("SELECT * FROM artists");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }
}

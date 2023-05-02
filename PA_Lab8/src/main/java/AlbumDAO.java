import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO implements AlbumDAOInterface {
    private final Connection connection;

    public AlbumDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void createAlbum(Album album) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO albums (release_year, title, artist_id) VALUES (?, ?, ?)"
            );
            statement.setInt(1, album.getReleaseYear());
            statement.setString(2, album.getTitle());
            statement.setInt(3, album.getArtistId());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                int albumId = generatedKeys.getInt(1);
                album.setId(albumId);

                insertAlbumGenres(albumId,album.getGenres());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Album getAlbumById(int id) {
        Album album = null;
        ResultSet rs = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM albums WHERE id = ?"
            );
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()) {
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                int artistId = rs.getInt("artist_id");

                List<Genre> genres = getAlbumGenres(id);

                return new Album(id, releaseYear, title, artistId, genres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAlbum(Album album) {
        try{
            PreparedStatement statement = connection.prepareStatement(
              "UPDATE albums SET release_year = ?, title = ?, artist_id = ? WHERE id = ?"
            );
        statement.setInt(1, album.getReleaseYear());
        statement.setString(2, album.getTitle());
        statement.setInt(3, album.getArtistId());
        statement.setInt(4, album.getId());
        statement.executeUpdate();

        updateAlbumGenres(album.getId(),album.getGenres());

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAlbum(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
              "DELETE FROM albums WHERE id = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();

            deleteAlbumGenres(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM albums"
            );

            while(rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                int artistId = rs.getInt("artist_id");

                List<Genre> genres = getAlbumGenres(id);

                Album album = new Album(id,releaseYear,title,artistId,genres);
                albums.add(album);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return albums;
    }

    private List<Genre> getAlbumGenres(int albumId){
        ResultSet rs = null;
        List<Genre> genres = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT g.id, g.name FROM genres g JOIN album_genres ag ON g.id = ag.genre_id WHERE ag.album_id = ?"
            );
            statement.setInt(1, albumId);
            rs = statement.executeQuery();

            while(rs.next()){
                int genreId = rs.getInt("id");
                String genreName = rs.getString("name");

                Genre genre = new Genre(genreId,genreName);
                genres.add(genre);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return genres;
    }

    private void insertAlbumGenres(int albumId, List<Genre> genres){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)"
            );

            for(Genre genre :genres){
                statement.setInt(1, albumId);
                statement.setInt(1, genre.getId());
                statement.addBatch();
            }
            statement.executeBatch();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void updateAlbumGenres(int albumId, List<Genre> genres){
        deleteAlbumGenres(albumId);
        insertAlbumGenres(albumId, genres);
    }

    private void deleteAlbumGenres(int albumId){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM album_genres WHERE album_id = ?"
            );
            statement.setInt(1, albumId);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

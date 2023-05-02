import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements GenreDAOInterface{

    private final Connection connection;

    public GenreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createGenre(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO genres (name) VALUES (?)"
            );
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Genre getGenreById(int id) {
        Genre genre = null;
        ResultSet rs = null;

        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT name FROM genres WHERE id = ?"
            );
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if(rs.next()){
                String name = rs.getString("name");
                genre = new Genre(id, name);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return genre;
    }

    @Override
    public void updateGenre(Genre genre) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE artists SET name = ? WHERE id = ?"
            );
            statement.setString(1, genre.getName());
            statement.setInt(2, genre.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGenre(Genre genre) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM genres WHERE id = ?"
            );
            statement.setInt(1, genre.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();

        ResultSet rs = null;

        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM genres"
            );
            rs = statement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Genre genre = new Genre(id,name);
                genres.add(genre);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return genres;
    }
}

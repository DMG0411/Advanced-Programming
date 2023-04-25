import java.sql.*;

public class ArtistDAO {

    public void create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO artists (name) VALUES (?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }


    public Integer findByName(String name) throws SQLException{
        Connection connection = Database.getConnection();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select id from artists where name='" + name +"'")
            ){
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

}

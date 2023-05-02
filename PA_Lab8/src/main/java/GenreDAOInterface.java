import java.util.*;
public interface GenreDAOInterface {
   void createGenre(String name);
   Genre getGenreById(int id);
   void updateGenre(Genre genre);
   void deleteGenre(Genre genre);
   List<Genre> getAllGenres();

}

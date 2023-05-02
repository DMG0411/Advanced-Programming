import java.util.*;
public interface AlbumDAOInterface {

    void createAlbum(Album album);
    Album getAlbumById(int id);
    void updateAlbum(Album album);
    void deleteAlbum(int id);
    List<Album> getAllAlbums();

}

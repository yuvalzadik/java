

package org.example;

        import java.util.List;

public class AlbumsPerUser {
    private byte userId;
    private List<albums> albums;

    public byte getUserId() {
        return userId;
    }

    public void setUserId(byte userId) {
        this.userId = userId;
    }

    public List<org.example.albums> getAlbums() {
        return albums;
    }

    public void setAlbums(List<org.example.albums> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "AlbumsPerUser{" +
                "userId=" + userId +
                ", albums=" + albums +
                '}';
    }
}
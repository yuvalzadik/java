package org.example;

public class photos {
    private byte albumId;
    private short id;
    private String title;
    private String url;
    private String thumbnailUrl;


    // Getter Methods

    public byte getAlbumId() {
        return albumId;
    }

    public short getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    // Setter Methods

    public void setAlbumId(byte albumId) {
        this.albumId = albumId;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}

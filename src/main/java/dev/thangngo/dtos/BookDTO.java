package dev.thangngo.dtos;

public class BookDTO {
    private int id;
    private String title;
    private String category;
    private boolean available;
    private String version;

    public BookDTO() {

    }

    public BookDTO(int id, String title, String category, boolean available, String version) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.available = available;
        this.version = version;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getVersion() {
        return version;
    }

}

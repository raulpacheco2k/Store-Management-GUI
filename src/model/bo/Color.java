package model.bo;

public class Color {
    private int id;
    private String description;

    public Color() {
    }

    public Color(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Color setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Color setDescription(String description) {
        this.description = description;
        return this;
    }
}

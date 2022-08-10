package com.example.ethpresidentlist;

public class President {
    private int id;
    private String name;
    private int date;
    private String imageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public President(int id, String name, int date, String imageURL) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}

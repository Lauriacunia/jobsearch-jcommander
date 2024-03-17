package com.letscodemom;
import java.util.List;
import java.util.Objects;

public class JobPosition {
    /* Como deprecó la Api de Jobs utilicé una de productos de Platzy */
    private int id;
    private String title;
    private int price;
    private String description;
    // private Category category;
    private List<String> images;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPosition that = (JobPosition) o;
        return id == that.id && price == that.price && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, images);
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", images=" + images +
                '}';
    }
}

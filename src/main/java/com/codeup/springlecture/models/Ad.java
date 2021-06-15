package com.codeup.springlecture.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    //All Ads have
    @Column(nullable = false)
    private String description;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ads_categories",
            joinColumns={@JoinColumn(name="ad_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<AdCategory> categories;


    // Spring framework uses this zero argument constructor
    public Ad() {
    }

    public Ad(String title, String description, User owner, List<AdImage> images, List<AdCategory> categories) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
        this.categories = categories;
    }

    public Ad(long id, String title, String description, User owner, List<AdImage> images, List<AdCategory> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<AdImage> getImages() {
        return images;
    }
    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public List<AdCategory> getCategories() {
        return categories;
    }
    public void setCategories(List<AdCategory> categories) {
        this.categories = categories;
    }
}

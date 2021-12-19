package com.webBlog.webBlog.userManager.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class UserBlog {

    @Id
    @Column(name = "id_blog")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
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

    public UserBlog(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public UserBlog() {
    }
}

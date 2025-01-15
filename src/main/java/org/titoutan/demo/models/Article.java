package org.titoutan.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // This tells Hibernate to make a table out of this class
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String content;

    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
package com.example.SpringMVC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name="clubs")
public class Club {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getCreatetion() {
        return createtion;
    }

    public void setCreatetion(LocalDateTime createtion) {
        this.createtion = createtion;
    }

    public LocalDateTime getUpdatation() {
        return updatation;
    }

    public void setUpdatation(LocalDateTime updatation) {
        this.updatation = updatation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String photourl;

    public Club(Long id, String title, String photourl, String contents, LocalDateTime createtion, LocalDateTime updatation) {
        this.id = id;
        this.title = title;
        this.photourl = photourl;
        this.contents = contents;
        this.createtion = createtion;
        this.updatation = updatation;
    }

    private  String contents;
    @CreationTimestamp
    private LocalDateTime createtion;
    @UpdateTimestamp
    private LocalDateTime updatation;

    public Club() {
    }
}

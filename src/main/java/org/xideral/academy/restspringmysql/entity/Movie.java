package org.xideral.academy.restspringmysql.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mv")
    private Integer id;

    @Column(name = "titulo_mv", nullable = false, length = 150)
    private String title;

    @Column(name = "fecha_mv")
    private LocalDate date;

    @Column(name = "duracion_mv")
    private Integer duration;

    @Column(name = "clasificacion_mv", length = 50)
    private String classification;

    @Column(name = "sinopsis_mv")
    private String synopsis;

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
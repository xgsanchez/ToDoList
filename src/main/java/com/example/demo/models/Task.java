package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;
    private String name;
    private String description;
    private LocalTime date;

    public Task(String name, String description, LocalTime date ) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Task() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}

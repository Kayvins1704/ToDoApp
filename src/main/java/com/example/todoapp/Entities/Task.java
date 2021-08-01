package com.example.todoapp.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue
    private long id;

    @JsonProperty
    private String task;

    @JsonProperty
    private boolean done;

    public Task(String task, boolean done) {
        this.task = task;
        this.done = done;
    }
}

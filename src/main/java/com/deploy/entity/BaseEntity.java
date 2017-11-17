package com.deploy.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp")
    private Date timestamp = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

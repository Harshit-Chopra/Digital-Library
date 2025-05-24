package com.example.Library.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class TimeStamps {

    @CreationTimestamp
    protected Date createdOn;
    @UpdateTimestamp
    protected Date updatedOn;


}

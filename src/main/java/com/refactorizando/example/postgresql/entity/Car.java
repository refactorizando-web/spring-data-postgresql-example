package com.refactorizando.example.postgresql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Table
@Entity
@Getter
@Setter
public class Car extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String model;

    @Column
    private String description;

    @Column
    private String color;


}
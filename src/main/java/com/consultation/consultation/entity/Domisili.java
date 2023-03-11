package com.consultation.consultation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name = "domisili")
public class Domisili implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String domisiliCode;

    public String domisiliName;
}

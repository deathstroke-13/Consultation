package com.consultation.consultation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Consultation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String consultCode;

    public String consultType;

    public String consultVia;

    @Temporal(TemporalType.TIMESTAMP)
    public Date dateRequest = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    public Date dateAppoint;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public Account userId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "consultant_id")
    public Consultant consultantId;

    public Boolean isPaid;
}
